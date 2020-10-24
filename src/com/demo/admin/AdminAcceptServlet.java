package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.vo.Task;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.ServiceDelegate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet(name = "AdminAcceptServlet", urlPatterns = {"/task/AdminAcceptServlet"})
public class AdminAcceptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Task task = (Task) session.getAttribute("admin-task");

        if(task.getEnd_time() == null) {
            String url = "adminContent.jsp?taskID=" + task.getID();
            request.setAttribute("message", "任务结束后才可下载！");
            request.getRequestDispatcher(url).forward(request, response);
            return;
        }

        response.setContentType("APPLICATION/OCTET-STREAM");
        String fileAttribute = "attachment; filename=" + task.getID() + ".zip";
//        System.out.println(fileAttribute);
        response.setHeader("Content-Disposition", fileAttribute);

        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        String basePath = getServletContext().getRealPath("/WEB-INF/upload/") + task.getID();
//        System.out.println(basePath);
        File files = new File(basePath);
//        System.out.println(files.getName());
        zipFile(files, "", zos);
        zos.flush();
        zos.close();

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        boolean flag = adminService.addTaskDownloadByID(task.getID());

        adminService.close();
    }

    private void zipFile(File file, String basePath, ZipOutputStream zos) throws IOException {
        if(!file.exists()) return;
        if(file.isFile()) {
            zos.putNextEntry(new ZipEntry(basePath + file.getName()));
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int r = 0;
            while((r = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, r);
            }
            fis.close();
        } else {
            String dirName = basePath + file.getName() + "/";
            zos.putNextEntry(new ZipEntry(dirName));
            File[] sub = file.listFiles();
            if(sub != null) {
                for (File f : sub) {
                    zipFile(f, dirName, zos);
                }
            }
        }
    }
}
