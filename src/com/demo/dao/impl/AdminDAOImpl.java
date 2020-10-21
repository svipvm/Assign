package com.demo.dao.impl;

import com.demo.dao.AdminDAO;
import com.demo.util.DBConnection;
import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;
import com.demo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class AdminDAOImpl implements AdminDAO {
    Connection conn = null;

    public AdminDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int countTaskDownloadByID(String ID) throws Exception {
        int count = 0;
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select down from task where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            count = rsts.getInt("down");
        }
        return count;
    }

    @Override
    public int countMemberByID(String ID) throws Exception {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        int count = 0;
        String sql = "select count(*) from belong where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            count = rsts.getInt(1);
        }
        return count;
    }

    @Override
    public ArrayList<User> findUsersByMusterID(String ID) throws Exception {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from belong, user where ID=? and belong.account=user.account";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        rsts = psmt.executeQuery();
        while(rsts.next()) {
            User user = new User();
            user.setAccount(rsts.getString("account"));
            user.setName(rsts.getString("name"));
            user.setSex(rsts.getString("sex"));
            users.add(user);
        }
        rsts.close();
        psmt.close();
        return users;
    }

    @Override
    public boolean haltTaskByID(String ID) throws Exception {
        PreparedStatement psmt = null;
        String sql = "update task set end_time=now() where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        psmt.executeUpdate();
        return true;
    }

    @Override
    public boolean addTaskDownloadByID(String ID) throws Exception {
        boolean flag = false;
        PreparedStatement psmt = null;
        String sql = "update task set down=down+1 where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        if(psmt.executeUpdate() == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int countAcceptionByID(String ID) throws Exception {
        int count = 0;
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select count(*) from submit where ID=? and total=0";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            count = rsts.getInt(1);
        }
        rsts.close();
        psmt.close();
        return count;
    }

    @Override
    public String findTaskNameByAccount(String account) throws Exception {
        String name = new String("");
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from admin where account=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            name = rsts.getString("name");
        }
        return name;
    }

    @Override
    public boolean addTask(Task task) throws Exception {
        boolean flag = false;
        PreparedStatement psmt = null;
        String sql = "insert into task values(?, ?, ?, ?, ?, now(), null)";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, task.getID());
        psmt.setString(2, task.getAccount());
        psmt.setString(3, task.getMusterID());
        psmt.setString(4, task.getTopic());
        psmt.setString(5, task.getContent());
        if(psmt.executeUpdate() == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public String getTaskLastID() throws Exception {
        String result = new String("");
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select ID from task order by ID desc";
        psmt = conn.prepareStatement(sql);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            result = rsts.getString(1);
        }
        return result;
    }

    @Override
    public Task findTaskByTaskID(String ID) throws Exception {
        Task task = new Task();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from task where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            task.setID(rsts.getString("ID"));
            task.setAccount(rsts.getString("account"));
            task.setMusterID(rsts.getString("musterID"));
            task.setTopic(rsts.getString("topic"));
            task.setContent(rsts.getString("content"));
            task.setStart_time(rsts.getString("start_time"));
            task.setEnd_time(rsts.getString("end_time"));
        }
        rsts.close();
        psmt.close();
        return task;
    }

    @Override
    public boolean adminLinkMuster(String account, String ID) throws Exception {
        boolean flag = false;
        PreparedStatement psmt = null;
        String sql = "insert into manager values(?, ?)";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        psmt.setString(2, ID);
        if(psmt.executeUpdate() == 1) {
            flag = true;
        }
//        System.out.println("2:" + flag);
        psmt.close();
        return flag;
    }

    @Override
    public boolean addMuster(String ID, String name) throws Exception {
        boolean flag = false;
        PreparedStatement psmt = null;
        String sql = "insert into muster values(?, ?, ?)";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        psmt.setString(2, name);
        psmt.setString(3, getCode());
        if(psmt.executeUpdate() == 1) {
            flag = true;
        }
//        System.out.println("1:" + flag);
        psmt.close();
        return flag;
    }

    private String getCode() {
        StringBuilder code = new StringBuilder(new String(""));
        Random random = new Random();
        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(3);
            if(index == 0) {
                code.append(random.nextInt(10));
            } else if(index == 1) {
                code.append((char) ('a' + random.nextInt(26)));
            } else {
                code.append((char) ('A' + random.nextInt(26)));
            }
        }
        System.out.println(code);
        return code.toString();
    }


    @Override
    public boolean modifyPassword(String account, String password) throws Exception {
        boolean flag = false;
        PreparedStatement psmt = null;
        String sql = "update admin set password=? where account=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, password);
        psmt.setString(2, account);
        if(psmt.executeUpdate() == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public ArrayList<Task> findTaskByMuster(String ID) throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from task where musterID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, ID);
        rsts = psmt.executeQuery();
        while(rsts.next()) {
            Task task = new Task();
            task.setID(rsts.getString(1));
            task.setAccount(rsts.getString(2));
            task.setMusterID(rsts.getString(3));
            task.setTopic(rsts.getString(4));
            task.setContent(rsts.getString(5));
            task.setStart_time(rsts.getString(6));
            task.setEnd_time(rsts.getString(7));
            tasks.add(task);
        }
        rsts.close();
        psmt.close();
        return tasks;
    }

    @Override
    public ArrayList<Muster> findGroupListByAccount(String account) throws Exception {
        ArrayList<Muster> groupList = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from manager, muster where manager.account=? and manager.ID=muster.ID";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        rsts = psmt.executeQuery();
        while(rsts.next()) {
            Muster group = new Muster();
            group.setID(rsts.getString("ID"));
            group.setName(rsts.getString("name"));
            groupList.add(group);
        }
        rsts.close();
        psmt.close();
        return groupList;
    }

    @Override
    public Admin findByAccount(String account) throws Exception {
        Admin admin = null;
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from admin where account=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            admin = new Admin();
            admin.setAccount(rsts.getString("account"));
            admin.setPassword(rsts.getString("password"));
            admin.setName(rsts.getString("Name"));
            admin.setSex(rsts.getString("sex"));
        }
        rsts.close();
        psmt.close();
        return admin;
    }
}
