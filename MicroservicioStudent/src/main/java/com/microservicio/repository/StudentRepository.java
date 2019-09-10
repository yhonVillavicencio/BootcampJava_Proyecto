package com.microservicio.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservicio.model.Student;

public interface StudentRepository  extends ReactiveMongoRepository<Student, String>{

}
