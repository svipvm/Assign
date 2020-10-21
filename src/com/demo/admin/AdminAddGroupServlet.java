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
        request.setCharacterEncoding("UTF-8");

        String ID = request.getParameter("groupID");
        String name = request.getParameter("groupName");
        String code = request.getParameter("groupCode");

        if(ID.length() < 4 || name.length() < 4) {
            request.setAttribute("message", "ID、名称太短，请重新输入！");
            request.getRequestDispatcher("adminAddGroup.jsp").forward(request, response);
            return;
        }

        AdminService adminService = ServiceFactory.getAdminServiceImple();
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        boolean flag = false;

        if("".equals(code)) {
            flag = adminService.addMusterLinkAccount(ID, name, admin.getAccount());
        } else {
            flag = adminService.adminLinkMuster(admin.getAccount(), ID);
        }

        if(flag) {
            request.setAttribute("message", "操作完成，请返回首页查看！");
        } else {
            request.setAttribute("message", "操作失败，请重新操作！");
        }

        request.getRequestDispatcher("adminAddGroup.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
