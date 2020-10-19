package com.demo.admin;

import com.demo.vo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet(name = "AdminAcceptServlet", urlPatterns = {"/task/AdminAcceptServlet"})
public class AdminAcceptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("APPLICATION/OCTET-STREAM");
        HttpSession session = request.getSession();
        Task task = (Task) session.getAttribute("admin-task");
        response.setHeader("Content-Disposition", "attachment; filename=" + task.getID());

        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        File files = new File(getServletContext().getRealPath("/WEB-INF/") + task.getID());
        zipFile(files, zos);
        zos.flush();
        zos.close();
    }

    private void zipFile(File file, ZipOutputStream zos) throws IOException {
        if(!file.exists()) return;
        if(file.isFile()) {
            zos.putNextEntry(new ZipEntry(file.getName()));
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int r = 0;
            while((r = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, r);
            }
            fis.close();
        } else {
            String dirNmae = file.getName() + "/";
            zos.putNextEntry(new ZipEntry(dirNmae));
            File[] sub = file.listFiles();
            if(sub != null) {
                for (File f : sub) {
                    zipFile(f, zos);
                }
            }
        }
    }
}
