package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
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

@WebServlet(name="AdminDelTaskServlet", urlPatterns={"/task/AdminDelTaskServlet"})
public class AdminDelTaskServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Task task = (Task) session.getAttribute("admin-task");
        String url = "adminContent.jsp";

        if(task.getEnd_time() == null) {
            request.setAttribute("message", "请先结束任务！");
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            AdminService adminService = ServiceFactory.getAdminServiceImple();
            boolean flag = adminService.delTaskByID(task.getID());
//            task = adminService.findTaskByTaskID(task.getID());
//            session.setAttribute("admin-task", task);
            if(flag) {
                String basePath = getServletContext().getRealPath("/WEB-INF/upload/") + task.getID();
                File files = new File(basePath);
                delTaskFiles(files, "");
            }
            request.setAttribute("message", "任务已删除！");
            request.getRequestDispatcher(url).forward(request, response);
            adminService.close();
        }
    }

    private void delTaskFiles(File file, String basePath) {
        if(!file.exists()) return;
        if(file.isFile()) {
            file.delete();
//            System.out.println(file.getPath());
        } else {
            String dirName = basePath + file.getName() + "/";
            File[] sub = file.listFiles();
            if(sub != null) {
                for (File f : sub) {
                    delTaskFiles(f, dirName);
                }
            }
        }
    }
}
