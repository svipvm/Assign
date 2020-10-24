package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.Muster;
import com.demo.vo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminTaskServlet", urlPatterns = {"/task/AdminTaskServlet"})
public class AdminTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupID = request.getParameter("groupID");

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        ArrayList<Task> tasks = adminService.findTaskByMuster(groupID);

//        Muster muster = adminService.findMusterByID(groupID);

        HttpSession session = request.getSession();
        session.setAttribute("admin-tasks", tasks);
        session.setAttribute("admin-groupID", groupID);
//        session.setAttribute("admin-muster", groupID);

        adminService.close();
    }
}
