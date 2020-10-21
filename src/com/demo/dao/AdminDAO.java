package com.demo.dao;

import com.demo.vo.Admin;
import com.demo.vo.Muster;
import com.demo.vo.Task;
import com.demo.vo.User;

import java.sql.Connection;
import java.util.ArrayList;

public interface AdminDAO {
    public abstract Admin findByAccount(String account) throws Exception;
    public abstract ArrayList<Muster> findGroupListByAccount(String account) throws Exception;
    public abstract int countMemberByID(String ID) throws Exception;
    public abstract ArrayList<Task> findTaskByMuster(String ID) throws Exception;
    public abstract Task findTaskByTaskID(String ID) throws Exception;
    public abstract String findTaskNameByAccount(String account) throws Exception;
    public abstract ArrayList<User> findUsersByMusterID(String ID) throws Exception;
    public abstract boolean haltTaskByID(String ID) throws Exception;
    public abstract int countAcceptionByID(String ID) throws Exception;
    public abstract int countTaskDownloadByID(String ID) throws Exception;
    public abstract boolean addTaskDownloadByID(String ID) throws Exception;
    public abstract  boolean modifyPassword(String account, String password) throws Exception;
    public abstract boolean addMuster(String ID, String name) throws Exception;
    public abstract boolean adminLinkMuster(String account, String ID) throws Exception;
    public abstract String getTaskLastID() throws Exception;
    public abstract boolean addTask(Task task) throws Exception;
}
