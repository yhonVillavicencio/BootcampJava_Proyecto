package com.microservicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.model.Student;
import com.microservicio.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository resp;
	
	@Override
	public Flux<Student> findAll(){
		
		return resp.findAll();
	}

	@Override
	public Mono<Student> save(Student student) {
	
		return resp.save(student);
	}
	
}
