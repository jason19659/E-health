package com.jason19659.ehealth.dao;

import java.util.List;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.model.User;

public interface MedicinalMapper {
	int deleteByPrimaryKey(String id);

	int insert(Medicinal record);

	int insertSelective(Medicinal record);

	Medicinal selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Medicinal record);

	int updateByPrimaryKey(Medicinal record);

	List<Medicinal> selectTop10();

	List<Medicinal> selectAll();

	List<Medicinal> selectMost4();

	List<Medicinal> selectTop5();
	
}