package com.demo.user;

import com.demo.factory.ServiceFactory;
import com.demo.service.UserService;
import com.demo.vo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserContentServlet", urlPatterns = {"/submit/UserContentServlet"})
public class UserContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String taskID = request.getParameter("taskID");

        UserService userService = ServiceFactory.getUserServiceImpl();
        Task task = userService.findTaskByTaskID(taskID);
        String name = userService.findTaskNameByAccount(task.getAccount());

        HttpSession session = request.getSession();
        session.setAttribute("user-task", task);
        session.setAttribute("user-task-name", name);

        userService.close();
    }
}
