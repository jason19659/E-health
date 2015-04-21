package com.jason19659.ehealth.dao;

import java.util.List;

import com.jason19659.ehealth.model.Order;
import com.jason19659.ehealth.model.User;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> selectAll();
}