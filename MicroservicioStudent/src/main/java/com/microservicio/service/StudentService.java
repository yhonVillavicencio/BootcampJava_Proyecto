package com.microservicio.service;

import com.microservicio.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
	
	public Flux<Student> findAll();
	
	public Mono<Student> save(Student student);
	
	public Mono<Student> findById(String id);
	
	public Mono<Void> delete(Student student);
	
	public Mono<Student> findBynumeroIdentificacion(String numeroIdentificacion);
	
	public Flux<Student> findBynombre(String nombre);
}
