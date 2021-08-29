package com.gain.java.knowledge.studentservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.gain.java.knowledge.api.model.Student;

public interface StudentService {

	ResponseEntity<Void> addStudent(@Valid Student student);

	ResponseEntity<List<Student>> getAllStudent();

}
