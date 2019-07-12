package com.zhong.mapper;

import java.util.List;

import com.zhong.entity.Student;

/**
 * @author zhong
 * @date 2019年7月12日 上午10:34:59
 * 
 */
public interface StudentMapper {

	/**
     * 根据学生编号获得学生对象
     */
    Student selectStudentById(int id);

    /**
     * 根据学生姓名获得学生集合
     */
    List<Student> selectStudentsByName(String name);
    
    /**
     * 
     * @param entity
     * @return
     */
    List<Student> selectStudents(Student entity);

   /**
    * 
    * @param entity
    * @return
    */
    int selectCount(Student entity);

    /**
     * 添加学生
     */
    int insertStudent(Student entity);

    /**
     * 更新学生
     */
    int updateStudent(Student entity);

    /**
     * 删除学生
     */
    int deleteStudent(int id);
}
