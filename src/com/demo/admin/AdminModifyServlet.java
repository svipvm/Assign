package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.Admin;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="AdminModifyServlet", urlPatterns={"/task/AdminModifyServlet"})
public class AdminModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String re_password = request.getParameter("re_password");

        if(new_password.length() < 6 || 20 < new_password.length()) {
            request.setAttribute("message", "�µ����벻��Ҫ��");
            request.getRequestDispatcher("adminModify.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

//        System.out.println(old_password + "\n" + new_password + "\n" + re_password);
        if(!old_password.equals(admin.getPassword())) {
            request.setAttribute("message", "��ǰ�������");
            request.getRequestDispatcher("adminModify.jsp").forward(request, response);
        } else if(!new_password.equals(re_password)) {
            request.setAttribute("message", "���������β�һ�£�");
            request.getRequestDispatcher("adminModify.jsp").forward(request, response);
        } else {
            AdminService adminService = ServiceFactory.getAdminServiceImple();
            if(adminService.modifyPassword(admin.getAccount(), new_password)) {
                session.invalidate();
                response.sendRedirect("../adminLogin.jsp");
            }
//            UserService userService = ServiceFactory.getUserServiceImpl();
//            if(userService.modifyPassword(user.getAccount(), new_password)) {
//                session.invalidate();
//                response.sendRedirect("../userLogin.jsp");
//            }

            adminService.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
