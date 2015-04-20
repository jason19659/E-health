/**
 * 
 */
package com.jason19659.ehealth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.ehealth.dao.MedicinalMapper;
import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.service.MedicinalService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.service.impl
 *
 * 2015年4月20日
 */
@Service
public class MedicinalServiceImpl implements  MedicinalService {

	@Autowired
	private MedicinalMapper mapper;
	
	

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
	public int insert(Medicinal record) {
		return mapper.insert(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Medicinal record) {
		return mapper.insertSelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Medicinal selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Medicinal record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(Medicinal record) {
		return mapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see com.jason19659.ehealth.service.MedicinalService#selectTop10()
	 */
	@Override
	public List<Medicinal> selectTop10() {
		return mapper.selectTop10();
	}

}
