package com.zhong.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author zhong
 * @date 2019年7月11日 上午10:56:25
 * 
 */
public class SqlSessionFactoryUtil {

	/**
	 * 
	 */
	private static final String MYBATIS_CONFIG = "conf.xml";

	private static SqlSessionFactory factory;
	static {
		try {
			/* 获得配置文件的文件流 */
			InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
			// 初始化工厂
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得会话对象 指定是否自动提交
	 */
	public static SqlSession openSqlSession(boolean isAutoCommit) {
		return getFactory().openSession(isAutoCommit);
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SqlSessionFactory factory) {
		SqlSessionFactoryUtil.factory = factory;
	}

	/**
	 * 关闭会话
	 */
	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
