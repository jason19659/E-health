package com.jason19659.ehealth.dao;

import com.jason19659.ehealth.model.Medicinal;

public interface MedicinalMapper {
    int deleteByPrimaryKey(String id);

    int insert(Medicinal record);

    int insertSelective(Medicinal record);

    Medicinal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Medicinal record);

    int updateByPrimaryKey(Medicinal record);
}