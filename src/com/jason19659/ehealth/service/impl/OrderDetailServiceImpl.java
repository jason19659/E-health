/**
 * 
 */
package com.jason19659.ehealth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.ehealth.dao.OrderDetailMapper;
import com.jason19659.ehealth.model.OrderDetail;
import com.jason19659.ehealth.service.OrderDetailService;
/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.service.impl
 *
 * 2015年4月20日
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
			
	@Autowired
	private OrderDetailMapper mapper;
	
	

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
	public int insert(OrderDetail record) {
		return mapper.insert(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(OrderDetail record) {
		return mapper.insertSelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public OrderDetail selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(OrderDetail record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(OrderDetail record) {
		return mapper.updateByPrimaryKey(record);
	}

}
