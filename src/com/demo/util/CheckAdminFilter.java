package com.demo.util;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.vo.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckAdminFilter", urlPatterns = "/task/*")
public class CheckAdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

//        HttpSession session = ((HttpServletRequest) req).getSession();
//        Admin admin = (Admin) session.getAttribute("admin");
//
//        AdminService adminService = ServiceFactory.getAdminServiceImple();
//
//        if(adminService.loginAdmin(admin).equals("success")) {
//            chain.doFilter(req, resp);
//        } else {
//            ((HttpServletResponse) resp).sendRedirect("../adminLogin.jsp");
//        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
