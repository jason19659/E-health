/**
 * 
 */
package com.jason19659.ehealth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.ehealth.dao.OrderMapper;
import com.jason19659.ehealth.model.Order;
import com.jason19659.ehealth.model.User;
import com.jason19659.ehealth.service.OrderService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.service.impl
 *
 * 2015年4月20日
 */
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper mapper;
	
	

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Order record) {
		return mapper.insert(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Order record) {
		return mapper.insertSelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Order selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Order record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(Order record) {
		return mapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.OrderService#selectAll()
	 */
	@Override
	public List<Order> selectAll() {
		return mapper.selectAll();
	}
}
