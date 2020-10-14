package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.vo.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class LoginAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPassword(password);

        AdminService adminService = ServiceFactory.getAdminServiceImple();

        if(adminService.loginAdmin(admin).equals("success")) {
            HttpSession session = request.getSession();
            admin = adminService.findAdminByAccount(account);
            session.setAttribute("admin", admin);
            response.sendRedirect("task/index.jsp");
        } else {
            request.setAttribute("error", "账号、密码错误！");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
