package com.demo.admin;

import com.demo.factory.ServiceFactory;
import com.demo.service.AdminService;
import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="AdminAddTaskServlet", urlPatterns={"/task/AdminAddTaskServlet"})
public class AdminAddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String groupID = (String) session.getAttribute("admin-groupID");

        Task task = new Task();
        AdminService adminService = ServiceFactory.getAdminServiceImple();
        task.setID(getTaskID(adminService.getTaskLastID()));
        task.setAccount(admin.getAccount());
        task.setMusterID(groupID);
        task.setTopic(topic);
        task.setContent(content);
        boolean flag = false;
        flag = adminService.addTaskLinkUser(task);


        if(flag) {
            request.setAttribute("message", "已添加任务 " + task.getID());
        } else {
            request.setAttribute("message", "该任务添加失败！");
        }
        request.getRequestDispatcher("adminAddTask.jsp").forward(request, response);
    }

    private String getTaskID(String date) {
        String tmp;
        if("".equals(date)) {
            tmp = new String("");
        } else {
            tmp = date.substring(0, 8);
        }
        System.out.println(tmp);
        SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");//日期格式
        String time = sformat.format(new Date());
        System.out.println(time);
        String result = new String("");
        if(tmp.equals(time)) {
            int count = Integer.parseInt(date.substring(8)) + 1;
            if(count < 10) {
                result = time + "0" + count;
            } else {
                result = time + count;
            }
        } else {
            result = time + "01";
        }
        System.out.println(result);
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
