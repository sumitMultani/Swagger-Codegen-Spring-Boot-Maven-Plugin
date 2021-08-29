package com.gain.java.knowledge.studentservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gain.java.knowledge.api.StudentApi;
import com.gain.java.knowledge.api.model.Student;
import com.gain.java.knowledge.studentservice.service.StudentService;

@RestController
public class StudentController implements StudentApi{

	@Autowired
	private StudentService service;
	
	@Override
	public ResponseEntity<Void> addStudent(String correlationId, @Valid Student student) {
		return service.addStudent(student);
	}
	
	@Override
	public ResponseEntity<List<Student>> getAllStudent(String correlationId) {
		return service.getAllStudent();
	}
}
