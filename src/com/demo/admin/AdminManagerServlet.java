package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminManagerServlet", urlPatterns = {"/task/AdminManagerServlet"})
public class AdminManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupID = request.getParameter("groupID");
        ArrayList<User> users = null;
        AdminService adminService = ServiceFactory.getAdminServiceImple();
        users = adminService.findUsersByMusterID(groupID);
        HttpSession session = request.getSession();
        session.setAttribute("admin-member", users);
        adminService.close();
    }
}
