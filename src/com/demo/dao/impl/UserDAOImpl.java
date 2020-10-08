package com.demo.dao.impl;

import com.demo.dao.UserDAO;
import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;
import com.demo.vo.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    Connection conn = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User findByAccount(String account) throws Exception {
        User user = null;
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from user where account=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            user = new User();
            user.setAccount(rsts.getString("account"));
            user.setPassword(rsts.getString("password"));
            user.setName(rsts.getString("name"));
            user.setSex(rsts.getString("sex"));
        }
        rsts.close();
        psmt.close();
        return user;
    }

    @Override
    public ArrayList<Muster> findGroupListByAccount(String account) throws Exception {
        ArrayList<Muster> groupList = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from belong, muster where belong.account=? and belong.ID=muster.ID";
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
    public int countGroupByAccount(String account) throws Exception {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        int result = 0;
        String sql = "select count(*) from belong where account=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        rsts = psmt.executeQuery();
        if(rsts.next()) result = rsts.getInt(1);
        rsts.close();
        psmt.close();
        return result;
    }

    @Override
    public int countTaskByAccount(String account) throws Exception {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        int result = 0;
        String sql = "select count(*) from task, belong where belong.account=?" +
                "and belong.ID=task.musterID and task.end_time is null";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        rsts = psmt.executeQuery();
        if(rsts.next()) result = rsts.getInt(1);
        rsts.close();
        psmt.close();
        return result;
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
}
