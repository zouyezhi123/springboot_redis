package com.zyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyz.entity.Student;
import com.zyz.service.impl.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl ssi;
	
	public void add(Student s) {
		ssi.add(s);
	}
	
	public void delete(int id) {
		ssi.deleteById(id);
	}
	
	public void Update(Student s) {
		ssi.update(s);
	}
	
	@RequestMapping("/queryById")
	public Student queryById(int id) {
		return ssi.queryById(id);
	}
	
	
	
}
