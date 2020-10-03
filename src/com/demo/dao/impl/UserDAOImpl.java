package com.demo.dao.impl;

import com.demo.dao.UserDAO;
import com.demo.vo.Admin;
import com.demo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
