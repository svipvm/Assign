package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminGroupServlet", urlPatterns = {"/task/AdminGroupServlet"})
public class AdminGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        ArrayList<Muster> groupList = adminService.findGroupListByAccount(admin.getAccount());

        ArrayList<Integer> countList = new ArrayList<>();
        for (Muster muster : groupList) {
            String ID = muster.getID();
            countList.add(adminService.countMemberByID(ID));
        }

        session.setAttribute("admin-group", groupList);
        session.setAttribute("admin-member-count", countList);

        adminService.close();
    }
}
