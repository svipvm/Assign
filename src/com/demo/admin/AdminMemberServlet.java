package com.demo.admin;

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
import java.util.ArrayList;

@WebServlet(name = "AdminMemberServlet", urlPatterns = {"/task/AdminMemberServlet"})
public class AdminMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupID = request.getParameter("groupID");
        ArrayList<User> users = null;

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        users = adminService.findUsersByMusterID(groupID);

//        ArrayList<String> imgPath = new ArrayList<>();
//        for(User user : users) {
//            char[] chars = user.getAccount().toCharArray();
//            int sum = 0, p = 233;
//            for (char aChar : chars) {
//                sum = (sum * 3 + (int) aChar) % p;
//            }
//            imgPath.add(String.format("../img/head/bot-%s.png", sum % 18 + 1));
//        }

        HttpSession session = request.getSession();
        session.setAttribute("admin-member", users);
//        session.setAttribute("user-member-img", imgPath);
    }
}
