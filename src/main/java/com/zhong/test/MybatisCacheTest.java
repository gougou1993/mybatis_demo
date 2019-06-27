package com.zhong.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhong.entity.Person;
import com.zhong.mapper.PersonMapper;

/**
 * @author zhong
 * @date 2019年6月27日 上午10:21:35
 * 
 */
public class MybatisCacheTest {

	public static void main(String[] args) throws IOException {
		// 加载配置信息
		Reader reader = Resources.getResourceAsReader("conf.xml");

		// SqlSession+
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();
		//firstLevelCache(session);
		
		SqlSession session2 = sqlSessionFactory.openSession();
		secondLevelCache(session,session2);
		
	}
	/**
	 * 一级缓存 默认开启 同一session 对象
	 * @param session
	 */
	public static void firstLevelCache(SqlSession session) {
		PersonMapper mapper = session.getMapper(PersonMapper.class );
		Person person1 = mapper.selectPerson(1); //将查询结果放在session中
		Person Person2 = mapper.selectPerson(1);
		// 会清理缓存
		//session.commit();
		//session.close();
	}
	
	/**
	 * 二级缓存 同一mapper对象 默认关闭  实体类需要序列化，父类也要，级联属性也需要序列化
	 * @param session
	 */
	public static void secondLevelCache(SqlSession session,SqlSession session2) {
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		PersonMapper mapper2 = session2.getMapper(PersonMapper.class);
		Person person1 = mapper.selectPerson(1); //将查询结果放在session中
		
		session.close(); //触发二级进行缓存的时刻，session 关闭
		
		Person Person2 = mapper2.selectPerson(1);
		
		session2.commit(); //清楚缓存，一般增删改 避免脏数据
		//session.close();
	}
	
}
