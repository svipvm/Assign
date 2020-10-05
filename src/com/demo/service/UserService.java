package com.demo.service;

import com.demo.vo.User;

public interface UserService {
    public abstract String loginUser(User user);
    public abstract User findByAccount(String Name);
}
