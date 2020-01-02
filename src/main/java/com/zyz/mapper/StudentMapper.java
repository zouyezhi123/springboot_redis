package com.zyz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zyz.entity.Student;

public interface StudentMapper {
	
	@Insert("insert into student(name,username,password,sex,age,birthday,createTime) values(#{name},#{username},#{password},#{sex},#{age},#{birthday},now())")
	public void add(Student student);
	
	@Delete("delete * from student where id='#{id}'")
	public void deleteById(int id);
	
	@Update("update student set(name=#{name},username=#{username},password=#{password},sex=#{sex},age=#{age},birthday=#{birthday})")
	public void update(Student student);
	
	@Select("select * from student where id=#{id}")
	public Student queryById(int id);
	
	@Select("select * from student limit #{p},#{s}")
	public List<Student> queryByPage(@Param("p") int currentPage, @Param("s") int pageSize);
	
	public void aa();
}
