package com.demo.factory;

import com.demo.service.impl.AdminServiceImpl;
import com.demo.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static AdminServiceImpl getAdminServiceImple() {
        return new AdminServiceImpl();
    }

    public static UserServiceImpl getUserServiceImpl() {
        return new UserServiceImpl();
    }
}
