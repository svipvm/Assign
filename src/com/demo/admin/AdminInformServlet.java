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
import java.util.ArrayList;

@WebServlet(name="AdminInformServlet", urlPatterns={"/task/AdminInformServlet"})
public class AdminInformServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> inform = new ArrayList<>();

        AdminService adminService = ServiceFactory.getAdminServiceImple();

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        char[] chars = admin.getAccount().toCharArray();
        int sum = 0, p = 233;
        for (char aChar : chars) {
            sum = (sum * 3 + (int) aChar) % p;
        }

        String imgID = String.format("../img/head/bot-%s.png", sum % 18 + 1);
//        int group_count = adminService.countGroupByAccount(admin.getAccount());

        inform.add(admin.getAccount());
        inform.add(admin.getName());
        inform.add(admin.getSex());
        inform.add(imgID);
//        inform.add(String.valueOf(group_count));

        session.setAttribute("admin-inform", inform);
    }
}
