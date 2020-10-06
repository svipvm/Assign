package com.demo.dao;

import com.demo.vo.Muster;
import com.demo.vo.User;

import java.util.ArrayList;

public interface UserDAO {
    public abstract User findByAccount(String account) throws Exception;
    public abstract ArrayList<Muster> findGroupListByAccount(String account) throws Exception;
}
