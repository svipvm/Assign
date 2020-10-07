package com.demo.user;

import com.demo.factory.ServiceFactory;
import com.demo.service.UserService;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserMemberServlet", urlPatterns = {"/submit/UserMemberServlet"})
public class UserMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupID = request.getParameter("groupID");
        ArrayList<User> users = null;

        UserService userService = ServiceFactory.getUserServiceImpl();
        users = userService.findUsersByMusterID(groupID);

        HttpSession session = request.getSession();
        session.setAttribute("user-member", users);
    }
}
