package com.demo.user;

import com.demo.factory.ServiceFactory;
import com.demo.service.UserService;
import com.demo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserModifyServlet", urlPatterns = {"/submit/UserModifyServlet"})
public class UserModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String re_password = request.getParameter("re_password");

        if(new_password.length() < 6 || 20 < new_password.length()) {
            request.setAttribute("message", "新的密码不合要求！");
            request.getRequestDispatcher("userModify.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//        System.out.println(old_password + "\n" + new_password + "\n" + re_password);
        if(!old_password.equals(user.getPassword())) {
            request.setAttribute("message", "当前密码错误！");
            request.getRequestDispatcher("userModify.jsp").forward(request, response);
        } else if(!new_password.equals(re_password)) {
            request.setAttribute("message", "新密码两次不一致！");
            request.getRequestDispatcher("userModify.jsp").forward(request, response);
        } else {
            UserService userService = ServiceFactory.getUserServiceImpl();
            if(userService.modifyPassword(user.getAccount(), new_password)) {
                session.invalidate();
                response.sendRedirect("../userLogin.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
