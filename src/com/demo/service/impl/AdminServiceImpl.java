package com.demo.service.impl;

import com.demo.dao.AdminDAO;
import com.demo.dao.impl.AdminDAOImpl;
import com.demo.factory.DAOFactory;
import com.demo.service.AdminService;
import com.demo.util.DBConnection;
import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;
import com.demo.vo.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminServiceImpl implements AdminService {
    private final DBConnection dbc = new DBConnection();

    @Override
    public boolean addTaskDownloadByID(String ID) {
        boolean flag = false;
        Connection conn = dbc.getConnection();
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl(conn);
        try {
            flag = adminDAO.addTaskDownloadByID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public boolean modifyPassword(String account, String password) {
        boolean flag = false;
        Connection conn = dbc.getConnection();
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl(conn);
        try {
            flag = adminDAO.modifyPassword(account, password);
        } catch (Exception e) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public int countAcceptionByID(String ID) {
        int count = 0;
        Connection conn = dbc.getConnection();
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl(conn);
        try {
            count = adminDAO.countAcceptionByID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    @Override
    public boolean haltTaskByID(String ID) {
        Connection conn = dbc.getConnection();
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl(conn);
        boolean flag = false;
        try {
            flag = adminDAO.haltTaskByID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public int countTaskDownloadByID(String ID) {
        int count = 0;
        Connection conn = dbc.getConnection();
        try {
            count = DAOFactory.getAdminDAOImpl(conn).countTaskDownloadByID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    @Override
    public int countMemberByID(String ID) {
        int count = 0;
        Connection conn = dbc.getConnection();
        try {
            count = DAOFactory.getAdminDAOImpl(conn).countMemberByID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    @Override
    public ArrayList<Task> findTaskByMuster(String ID) {
        ArrayList<Task> tasks = null;
        Connection conn = dbc.getConnection();
        try {
            tasks = DAOFactory.getAdminDAOImpl(conn).findTaskByMuster(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return tasks;
    }

    @Override
    public ArrayList<User> findUsersByMusterID(String ID) {
        ArrayList<User> users = null;
        Connection conn = dbc.getConnection();
        try {
            users = DAOFactory.getAdminDAOImpl(conn).findUsersByMusterID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    @Override
    public String findTaskNameByAccount(String account) {
        String name = null;
        Connection conn = dbc.getConnection();
        try {
            name = DAOFactory.getAdminDAOImpl(conn).findTaskNameByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return name;
    }

    @Override
    public Task findTaskByTaskID(String ID) {
        Task task = null;
        Connection conn = dbc.getConnection();
        try {
            task = DAOFactory.getAdminDAOImpl(conn).findTaskByTaskID(ID);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return task;
    }

    @Override
    public ArrayList<Muster> findGroupListByAccount(String account) {
        ArrayList<Muster> groupList = null;
        Connection conn = dbc.getConnection();
        try {
            groupList = DAOFactory.getAdminDAOImpl(conn).findGroupListByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return groupList;
    }

    @Override
    public Admin findAdminByAccount(String account) {
        Admin admin = null;
        Connection conn = dbc.getConnection();
        try {
            admin = DAOFactory.getAdminDAOImpl(conn).findByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return admin;
    }

    @Override
    public String loginAdmin(Admin admin) {
        String messge = "error";
        if(admin == null) return messge;
        Connection conn = dbc.getConnection();
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl(conn);
        try {
            Admin admin1 = adminDAO.findByAccount(admin.getAccount());
            if(admin1 != null && admin1.getPassword().equals(admin.getPassword())) {
                messge = "success";
            }
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return messge;
    }

}
