package com.zhong.mybatishandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author zhong
 * @date 2019年6月26日 下午4:31:14
 * 
 */
public class MyTypeHandler extends BaseTypeHandler<Boolean> {

	
	//java -- db
	@Override
	/**
	 * parameter java值
	 * jdbcType 数据库值
	 */
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter) {
			ps.setInt(i, 1);
		}else {
			ps.setInt(i, 0);
		}
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int sexNum  = rs.getInt(columnName);
		return sexNum == 1 ?true:false;
	}

	/**
	 * 
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int sexNum  = rs.getInt(columnIndex);
		return sexNum == 1 ?true:false;
	}

	/**
	 * 存储过程
	 */
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int sexNum = cs.getInt(columnIndex);
		return sexNum == 1 ?true:false;
	}

}
