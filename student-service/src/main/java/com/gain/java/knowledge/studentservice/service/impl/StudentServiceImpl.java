package com.gain.java.knowledge.studentservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gain.java.knowledge.api.model.Student;
import com.gain.java.knowledge.studentservice.entity.StudentEntity;
import com.gain.java.knowledge.studentservice.repository.StudentRepository;
import com.gain.java.knowledge.studentservice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public ResponseEntity<Void> addStudent(@Valid Student student) {
		StudentEntity entity = getStudentEntity(student);
		repository.save(entity);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudent() {
		List<StudentEntity> students = repository.findAll();
		List<Student> studentList = students.parallelStream().map(studentEntity -> getStudentModel(studentEntity))
				.collect(Collectors.toList());
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	private StudentEntity getStudentEntity(Student student) {
		StudentEntity entity = new StudentEntity();
		entity.setCity(student.getCity());
		entity.setFirst_name(student.getFirstName());
		entity.setLast_name(student.getLastName());
		entity.setName(student.getName());
		entity.setSection(student.getSection());
		return entity;
	}

	private Student getStudentModel(StudentEntity entity) {
		Student student = new Student();
		student.setCity(entity.getCity());
		student.setFirstName(entity.getFirst_name());
		student.setId(entity.getId());
		student.setLastName(entity.getLast_name());
		student.setName(entity.getName());
		student.setSection(entity.getSection());
		return student;
	}

}
