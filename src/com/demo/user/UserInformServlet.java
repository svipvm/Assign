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
        String src = String.format("../img/head/bot-%s.png", sum % 18 + 1);
        int group_count = userService.countGroupByAccount(user.getAccount());
        int task_count = userService.countTaskByAccount(user.getAccount());
        String group_num = String.format("拥有小组数：%s", group_count);
        String submit_num = String.format("还未提交数：%s", task_count);

        inform.add(user.getAccount());
        inform.add(user.getName());
        inform.add(user.getSex());
        inform.add(src);
        inform.add(group_num);
        inform.add(submit_num);

        session.setAttribute("user-inform", inform);
    }

}
