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
import java.io.IOException;

@WebServlet(name="AdminTaskHaltServlet", urlPatterns={"/task/AdminTaskHaltServlet"})
public class AdminTaskHaltServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Task task = (Task) session.getAttribute("admin-task");

        String url = "adminContent.jsp?taskID=" + task.getID();

        if(task.getEnd_time() != null) {
            request.setAttribute("message", "任务已结束！");
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            AdminService adminService = ServiceFactory.getAdminServiceImple();
            boolean flag = adminService.haltTaskByID(task.getID());
            response.sendRedirect(url);
        }

    }
}
