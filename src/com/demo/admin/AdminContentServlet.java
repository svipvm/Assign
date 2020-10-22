package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminContentServlet", urlPatterns = {"/task/AdminContentServlet"})
public class AdminContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        String taskID = request.getParameter("taskID");
        Task task = (Task) session.getAttribute("admin-task");

        AdminService adminService = ServiceFactory.getAdminServiceImple();
//        Task task = adminService.findTaskByTaskID(taskID);

        int sum = adminService.countMemberByID(task.getMusterID());
        int count = adminService.countAcceptionByID(task.getID());
//        int down = adminService.countTaskDownloadByID(task.getID());

//        session.setAttribute("admin-task", task);
        session.setAttribute("admin-sum", sum);
        session.setAttribute("admin-count", count);
//        session.setAttribute("admin-down", down);

    }
}
