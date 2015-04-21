package com.jason19659.ehealth.dao;

import java.util.List;

import com.jason19659.ehealth.model.User;

public interface UserMapper  {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUsername(String username);
    
    List<User> selectAll();
}