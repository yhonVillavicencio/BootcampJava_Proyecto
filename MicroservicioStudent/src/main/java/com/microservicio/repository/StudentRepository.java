package com.microservicio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservicio.model.Student;

public interface StudentRepository  extends MongoRepository<Student, String>{

}
