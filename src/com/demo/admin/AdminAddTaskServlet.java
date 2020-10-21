package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="AdminAddTaskServlet", urlPatterns={"/task/AdminAddTaskServlet"})
public class AdminAddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        session.getAttribute("")

        String topic = request.getParameter("topic");
        String content = request.getParameter("content");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        Muster muster = (Muster) session.getAttribute("muster");

        Task task = new Task();
        AdminService adminService = ServiceFactory.getAdminServiceImple();
        task.setID(getTaskID(adminService.getTaskLastID()));
        task.setAccount(admin.getAccount());
        task.setMusterID(muster.getID());
        task.setTopic(topic);
        task.setContent(content);

    }

    private String getTaskID(String date) {
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
