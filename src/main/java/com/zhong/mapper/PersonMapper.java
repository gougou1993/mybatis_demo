package com.zhong.mapper;

import java.util.List;

import com.zhong.entity.Person;

/**
 * @author zhong
 * @date 2019年6月26日 下午4:06:24
 * 
 */
public interface PersonMapper {
	Person selectPerson(int id);
	Person selectPersonWithConverter(int id);
	List<Person> queryAll();
	void addPerson(Person person);
	void addPersonWithConverter(Person person);
	void deleteById(int id);
}
