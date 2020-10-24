package com.demo;

import com.demo.factory.DAOFactory;
import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.demo.vo.Admin;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = {"/UserLoginServlet"})
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);

        UserService userService = ServiceFactory.getUserServiceImpl();

        if(userService.loginUser(user).equals("success")) {
            HttpSession session = request.getSession();
            user = userService.findUserByAccount(account);
            session.setAttribute("user", user);
            response.sendRedirect("submit/index.jsp");
        } else {
            request.setAttribute("message", "’À∫≈°¢√‹¬Î¥ÌŒÛ£°");
            request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
        }

        userService.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
