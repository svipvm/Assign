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
import java.util.ArrayList;

@WebServlet(name = "UserTaskServlet", urlPatterns = {"/submit/UserTaskServlet"})
public class UserTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupID = request.getParameter("groupID");

        UserService userService = ServiceFactory.getUserServiceImpl();
        ArrayList<Task> tasks = userService.findTaskByMuster(groupID);

        HttpSession session = request.getSession();
        session.setAttribute("user-tasks", tasks);

        userService.close();
    }
}
