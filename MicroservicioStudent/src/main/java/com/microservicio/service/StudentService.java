package com.microservicio.service;

import com.microservicio.model.Student;

import reactor.core.publisher.Flux;

public interface StudentService {
	
	
	public Flux<Student> findAll();
	
	public Flux<Student> findAllForNumeroIdentificacion();
	
}
