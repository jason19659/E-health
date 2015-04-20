/**
 * 
 */
package com.jason19659.ehealth.service;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 *         com.jason19659.ehealth.service
 *
 *         2015年4月17日
 */
public interface BaseService<T> {
	int deleteByPrimaryKey(String id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);


}
