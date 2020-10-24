package com.demo.util;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.vo.Admin;
import com.demo.vo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckUserFilter", urlPatterns = "/submit/*")
public class CheckUserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = ((HttpServletRequest) req).getSession();
        User user = (User) session.getAttribute("user");

        UserService userService = ServiceFactory.getUserServiceImpl();
//        System.out.println(user.getAccount() + "\n" + user.getPassword());
        if(userService.loginUser(user).equals("success")) {
//            System.out.println("Debug: " + admin.getAccount() + " - " + admin.getPassword());
            chain.doFilter(req, resp);
        } else {
//            request.setAttribute("error", "账号、密码错误！");
//            request.getRequestDispatcher("../adminLogin.jsp").forward(request, response);
            ((HttpServletResponse) resp).sendRedirect("../userLogin.jsp");
        }

        userService.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
