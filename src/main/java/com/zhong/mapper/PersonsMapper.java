package com.zhong.mapper;

import com.zhong.entity.Persons;

public interface PersonsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Persons record);

    int insertSelective(Persons record);

    Persons selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Persons record);

    int updateByPrimaryKey(Persons record);
}