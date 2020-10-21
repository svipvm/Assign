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
        String code = request.getParameter("groupCode");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        boolean flag = adminService.addMusterLinkAccount(ID, name, admin.getAccount());

        if(flag) {
            request.setAttribute("massage", "操作完成，请返回首页查看！");
            request.getRequestDispatcher("adminAddGroup.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
