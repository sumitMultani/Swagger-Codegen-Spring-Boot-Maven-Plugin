package com.gain.java.knowledge.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gain.java.knowledge.studentservice.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}
