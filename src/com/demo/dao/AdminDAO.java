package com.demo.dao;

import com.demo.vo.Admin;

import java.sql.Connection;

public interface AdminDAO {
    public abstract Admin findByAccount(String account) throws Exception;
}
