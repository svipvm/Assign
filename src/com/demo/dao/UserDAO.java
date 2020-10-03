package com.demo.dao;

import com.demo.vo.User;

public interface UserDAO {
    public abstract User findByAccount(String account) throws Exception;
}
