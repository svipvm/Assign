package com.demo.user;

import com.demo.factory.ServiceFactory;
import com.demo.service.UserService;
import com.demo.vo.Muster;
import com.demo.vo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserGroupServlet", urlPatterns = {"/submit/UserGroupServlet"})
public class UserGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        UserService userService = ServiceFactory.getUserServiceImpl();
        ArrayList<Muster> groupList = userService.findGroupListByAccount(user.getAccount());

        ArrayList<Integer> countList = new ArrayList<>();
        for (Muster muster : groupList) {
            String ID = muster.getID();
            countList.add(userService.countMemberByID(ID));
        }

        session.setAttribute("user-group", groupList);
        session.setAttribute("user-member-count", countList);
    }
}
