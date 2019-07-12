package com.zhong.mapper;

import com.zhong.entity.Emp;

/**
 * @author zhong
 * @date 2019年7月12日 上午11:57:39
 * 
 */
public interface EmpMapper {

	 /**获得员工通过员工编号*/
	 Emp getEmpById_1(int id);
	 
	 /**
	  * 
	  * @param id
	  * @return
	  */
	 Emp getEmpById_2(int id);
}
