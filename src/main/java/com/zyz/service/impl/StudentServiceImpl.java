package com.zyz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zyz.entity.Student;
import com.zyz.mapper.StudentMapper;
import com.zyz.service.IStudentService;

@Service
@CacheConfig(cacheNames="students")
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentMapper dao;

	@Override
	public void add(Student student) {
		dao.add(student);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void update(Student student) {
		dao.update(student);
	}

	@Override
	@Cacheable(key="'student:'+#id")//@Cacheble做用：先从缓存中查询是否有数据，如果有直接取出返回，否则查询数据库返回值保存在缓存
	public Student queryById(int id) {
		return dao.queryById(id);
	}

	@Override
	public List<Student> queryByPage(int currentPage, int pageSize) {
		return dao.queryByPage(currentPage, pageSize);
	}

}
