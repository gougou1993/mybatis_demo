package com.zhong.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhong.entity.Person;
import com.zhong.mapper.PersonMapper;

/**
 * @author zhong
 * @date 2019年6月26日 下午3:11:04
 * 
 */
public class TestMybatis {

	public static void main(String[] args) throws IOException {
		// 加载配置信息
		Reader reader = Resources.getResourceAsReader("conf.xml");

		// SqlSession+
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		String statement = "com.zhong.mapper.PersonMapper.selectPerson";
		String statementAll = "com.zhong.mapper.PersonMapper.queryAll";
		String statementAdd = "com.zhong.mapper.PersonMapper.addPerson";
		
		Person person = session.selectOne(statement, 1);

		List<Person> persons = session.selectList(statementAll);
		System.out.println(persons);

		// 基于代理 就是接口方式
		PersonMapper personMapper = session.getMapper(PersonMapper.class);
		Person selectPerson = personMapper.selectPerson(1);
		
		Person selectPersonWithConverter = personMapper.selectPersonWithConverter(1);
		
		selectPerson.setId(3);
		selectPerson.setSex(true);
		personMapper.addPersonWithConverter(selectPerson);
		//person.setId(2);session.insert(statementAdd, person);
		session.commit(); // jdbc 方式 需要提交事务

		session.close();
		
		

		System.out.println(person);

	}
}
