package com.demo.service;

import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;
import com.demo.vo.User;

import java.util.ArrayList;

public interface AdminService {
    public abstract String loginAdmin(Admin admin);
    public abstract Admin findAdminByAccount(String account);
    public abstract ArrayList<Muster> findGroupListByAccount(String account);
    public abstract int countMemberByID(String ID);
    public abstract ArrayList<Task> findTaskByMuster(String ID);
    public abstract Task findTaskByTaskID(String ID);
    public abstract String findTaskNameByAccount(String account);
    public abstract ArrayList<User> findUsersByMusterID(String ID);
}
