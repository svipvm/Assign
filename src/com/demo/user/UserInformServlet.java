package com.demo.user;

import com.demo.factory.ServiceFactory;
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

@WebServlet(name = "UserInformServlet", urlPatterns = {"/submit/UserInformServlet"})
public class UserInformServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> inform = new ArrayList<>();

        UserService userService = ServiceFactory.getUserServiceImpl();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        char[] chars = user.getAccount().toCharArray();
        int sum = 0, p = 233;
        for (char aChar : chars) {
            sum = (sum * 3 + (int) aChar) % p;
        }

        String imgID = String.format("../img/head/bot-%s.png", sum % 18 + 1);
        int group_count = userService.countGroupByAccount(user.getAccount());

        inform.add(user.getAccount());
        inform.add(user.getName());
        inform.add(user.getSex());
        inform.add(imgID);
        inform.add(String.valueOf(group_count));

        session.setAttribute("user-inform", inform);

        userService.close();
    }

}
