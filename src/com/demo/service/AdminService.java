package com.demo.service;

import com.demo.vo.Admin;

public interface AdminService {
    public abstract String loginAdmin(Admin admin);
    public abstract Admin findAdminByAccount(String account);
}
