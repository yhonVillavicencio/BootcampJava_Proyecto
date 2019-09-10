package com.microservicio.service;

import com.microservicio.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
	
	
	public Flux<Student> findAll();
	
	
	public Mono<Student> save(Student student);
	
}
