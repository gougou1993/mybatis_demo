package com.zhong.plugins;

import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author zhong
 * @date 2019年6月28日 上午10:56:53
 * 
 */
@Intercepts(value = { @Signature(args = {PreparedStatement.class }, method = "setParameters", type = ParameterHandler.class) })
public class ParameterHandlerPlugin implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		ParameterHandler parameterHandler = (ParameterHandler)invocation.getTarget();
		Object[] args = invocation.getArgs();
		
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}

}
