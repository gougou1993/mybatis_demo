package com.zhong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhong.entity.Student;

/**
 * @author zhong
 * @date 2019年7月12日 上午11:19:20
 * 
 */
public interface AnnotationStudentMapper {

	/**
     * 根据学生编号获得学生对象
     */
    @Select("select id,name,sex from student where id=#{id}")
    Student selectStudentById(int id);

    /**
     * 根据学生姓名获得学生集合
     */
    @Select("SELECT id,name,sex from student where name like '%${value}%'")
    List<Student> selectStudentsByName(String name);

    /**
     * 添加学生
     */
    @Insert("insert into student(name,sex) values(#{name},#{sex})")
    int insertStudent(Student entity);

    /**
     * 更新学生
     */
    @Update("update student set name=#{name},sex=#{sex} where id=#{id}")
    int updateStudent(Student entity);

    /**
     * 删除学生
     */
    @Delete("delete from student where id=#{id}")
    int deleteStudent(int id);
}
