package com.demo;

import com.demo.dao.UserDAO;
import com.demo.factory.DAOFactory;
import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckAdminServlet", urlPatterns = {"/submit/CheckAdminServlet"})
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        UserService userService = ServiceFactory.getUserServiceImpl();

        if(!userService.loginUser(user).equals("success")) {
            request.setAttribute("error", "账号、密码错误！");
            request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
        }
    }
}
