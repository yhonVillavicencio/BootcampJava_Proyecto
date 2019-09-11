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

	@Override
	public Mono<Student> findById(String id) {
	
		return resp.findById(id);
	}

	@Override
	public Mono<Void> delete(Student student) {
		
		return resp.delete(student);
	}

	@Override
	public Mono<Student> findBynumeroIdentificacion(String numeroIdentificacion) {
		
		return resp.findBynumeroIdentificacion(numeroIdentificacion);
	}

	@Override
	public Flux<Student> findBynombre(String nombre) {

		return resp.findBynombre(nombre);
	}

	
}
