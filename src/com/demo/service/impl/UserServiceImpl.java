package com.demo.service.impl;

import com.demo.dao.UserDAO;
import com.demo.factory.DAOFactory;
import com.demo.service.UserService;
import com.demo.util.DBConnection;
import com.demo.vo.Muster;
import com.demo.vo.Task;
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
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return groupList;
    }

    @Override
    public int countGroupByAccount(String account) {
        int result = 0;
        Connection conn = dbc.getConnection();
        try {
            result = DAOFactory.getUserDAOImpl(conn).countGroupByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public boolean modifyPassword(String account, String password) {
        Connection conn = dbc.getConnection();
        boolean flag = false;
        try {
            flag = DAOFactory.getUserDAOImpl(conn).modifyPassword(account, password);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public String findTaskNameByAccount(String account) {
        String name = null;
        Connection conn = dbc.getConnection();
        try {
            name = DAOFactory.getUserDAOImpl(conn).findTaskNameByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return name;
    }

    @Override
    public int countMemberByID(String ID) {
        int count = 0;
        Connection conn = dbc.getConnection();
        try {
            count = DAOFactory.getUserDAOImpl(conn).countMemberByID(ID);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    @Override
    public int countTaskByAccount(String account) {
        int result = 0;
        Connection conn = dbc.getConnection();
        try {
            result = DAOFactory.getUserDAOImpl(conn).countTaskByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public ArrayList<Task> findTaskByMuster(String ID) {
        ArrayList<Task> tasks = null;
        Connection conn = dbc.getConnection();
        try {
            tasks = DAOFactory.getUserDAOImpl(conn).findTaskByMuster(ID);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return tasks;
    }

    @Override
    public ArrayList<User> findUsersByMusterID(String ID) {
        ArrayList<User> users = null;
        Connection conn = dbc.getConnection();
        try {
            users = DAOFactory.getUserDAOImpl(conn).findUsersByMusterID(ID);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    @Override
    public Task findTaskByTaskID(String ID) {
        Task task = null;
        Connection conn = dbc.getConnection();
        try {
            task = DAOFactory.getUserDAOImpl(conn).findTaskByTaskID(ID);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return task;
    }

    @Override
    public void addTaskTotal(String account, String ID) {
        Connection conn = dbc.getConnection();
        try {
            DAOFactory.getUserDAOImpl(conn).addTaskTotal(account, ID);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean checkTaskByID(String ID) {
        Connection conn = dbc.getConnection();
        boolean flag = false;
        try {
            flag = DAOFactory.getUserDAOImpl(conn).checkTaskByID(ID);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }
}
