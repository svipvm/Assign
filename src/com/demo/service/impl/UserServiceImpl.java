package com.demo.service.impl;

import com.demo.dao.UserDAO;
import com.demo.factory.DAOFactory;
import com.demo.service.UserService;
import com.demo.util.DBConnection;
import com.demo.vo.Muster;
import com.demo.vo.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private final DBConnection dbc = new DBConnection();

    @Override
    public String loginUser(User user) {
        String messge = "error";
        if(user == null) return messge;
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            User user1 = userDAO.findByAccount(user.getAccount());
            if(user1 != null && user1.getPassword().equals(user.getPassword())) {
                messge = "success";
            }
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return messge;
    }

    @Override
    public User findUserByAccount(String account) {
        User user = null;
        Connection conn = dbc.getConnection();
        try {
            user = DAOFactory.getUserDAOImpl(conn).findByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public ArrayList<Muster> findGroupListByAccount(String account) {
        ArrayList<Muster> groupList = null;
        Connection conn = dbc.getConnection();
        try {
            groupList = DAOFactory.getUserDAOImpl(conn).findGroupListByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return groupList;
    }
}
