/**
 * 
 */
package com.jason19659.ehealth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.ehealth.dao.UserMapper;
import com.jason19659.ehealth.model.User;
import com.jason19659.ehealth.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.service.impl
 *
 * 2015年4月19日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	
	@Override
	public User selectByUsername(String username) {
		return  mapper.selectByUsername(username);
	}

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
	public int insert(User record) {
		return mapper.insert(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(User record) {
		return mapper.insertSelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(User record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(User record) {
		return mapper.updateByPrimaryKey(record);
	}

}
