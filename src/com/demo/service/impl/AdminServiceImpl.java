package com.demo.service.impl;

import com.demo.dao.AdminDAO;
import com.demo.dao.impl.AdminDAOImpl;
import com.demo.factory.DAOFactory;
import com.demo.service.AdminService;
import com.demo.util.DBConnection;
import com.demo.vo.Admin;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminServiceImpl implements AdminService {
    private final DBConnection dbc = new DBConnection();

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
