package com.demo.dao.impl;

import com.demo.dao.AdminDAO;
import com.demo.util.DBConnection;
import com.demo.vo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements AdminDAO {
    Connection conn = null;

    public AdminDAOImpl(Connection conn) {
        this.conn = conn;
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
