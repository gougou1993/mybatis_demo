package com.zhong.plugins;

import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.mysql.jdbc.Statement;

/**
 * @author zhong
 * @date 2019年6月28日 上午11:05:39
 * 
 */
@Intercepts(value = { @Signature(args = { Statement.class }, method = "handleResultSets", type = ResultSetHandler.class) })
public class ResultSetHandlerPlugin  implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		ResultSetHandler resultSetHandler  = (ResultSetHandler) invocation.getTarget();
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
