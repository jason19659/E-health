package com.jason19659.ehealth.dao;

import java.util.List;

import com.jason19659.ehealth.model.OrderDetail;
import com.jason19659.ehealth.model.User;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    List<OrderDetail> selectAll();
}