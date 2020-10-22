package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.Task;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "AdminMemberServlet", urlPatterns = {"/task/AdminMemberServlet"})
public class AdminMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String groupID = (String) session.getAttribute("admin-groupID");
        Task task = (Task) session.getAttribute("admin-task");
        ArrayList<User> users = null;
        Map<String, Integer> subCount = new HashMap<>();

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        users = adminService.findUsersByMusterID(groupID);
        if(users.size() != 0) {
            for(User user : users) {
//                System.out.println(user.getAccount() + " : " + task.getID());
                subCount.put(user.getAccount(), adminService.findCountByID(user.getAccount(), task.getID()));
            }
        }

        session.setAttribute("admin-member", users);
        session.setAttribute("admin-status", subCount);
//        session.setAttribute("user-member-img", imgPath);
    }
}
