package com.demo.service;

import com.demo.vo.Muster;
import com.demo.vo.Task;
import com.demo.vo.User;

import java.util.ArrayList;

public interface UserService {
    public abstract String loginUser(User user);
    public abstract User findUserByAccount(String Name);
    public abstract ArrayList<Muster> findGroupListByAccount(String account);
    public abstract int countGroupByAccount(String account);
    public abstract int countTaskByAccount(String account);
    public abstract ArrayList<Task> findTaskByMuster(String ID);
}
