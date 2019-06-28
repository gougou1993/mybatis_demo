package com.zhong.plugins;

import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * @author zhong
 * @date 2019年6月28日 上午10:44:30
 * 
 */
@Intercepts({
	@Signature(args = {MappedStatement.class,Object.class }, method = "update", type = Executor.class)
})
public class ExecutorPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Executor executor = (Executor)invocation.getTarget();
		Object[] args = invocation.getArgs();
		
		MappedStatement mappedStatement = null;
		for (Object arg : args) {
			if(arg instanceof MappedStatement ) {
				mappedStatement = (MappedStatement)arg;
			}
		}
		Method method = invocation.getMethod();
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		properties.getProperty("someProperty");
	}

}
