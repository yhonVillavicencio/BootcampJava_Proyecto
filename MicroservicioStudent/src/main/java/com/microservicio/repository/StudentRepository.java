package com.microservicio.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservicio.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository  extends ReactiveMongoRepository<Student, String>{

		Mono<Student> findBynumeroIdentificacion(String numeroIdentificacion);
		Flux<Student> findBynombre(String nombre);
		

}
