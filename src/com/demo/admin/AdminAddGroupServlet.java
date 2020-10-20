package com.demo.admin;

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

@WebServlet(name = "AdminAddGroupServlet", urlPatterns = {"/task/AdminAddGroupServlet"})
public class AdminAddGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("groupName");
        String ID = request.getParameter("groupID");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        adminService.addMusterLinkAccount(ID, name, admin.getAccount());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
