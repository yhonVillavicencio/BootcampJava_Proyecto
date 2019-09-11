package com.microservicio;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.microservicio.model.Student;
import com.microservicio.service.StudentService;

import reactor.core.publisher.Flux;

import java.util.Date;

import org.slf4j.Logger;

@SpringBootApplication
public class MicroservicioStudentApplication {
	
	//@Autowired
	//private StudentService servicio;
	
	/*@Autowired
	private ReactiveMongoTemplate mongoTemplate;	

	private static final Logger log = LoggerFactory.getLogger(MicroservicioStudentApplication.class);*/


	public static void main(String[] args) {
		SpringApplication.run(MicroservicioStudentApplication.class, args);
	}

	
	/*public void run(String...args) throws Exception {
		mongoTemplate.dropCollection("Student").subscribe();

				Flux.just(new Student("DNI", "73226940", "YHON", "MASCULINO", 2),
						  new Student("DNI", "73226941", "MANUEL", "MASCULINO", 2)
						
						)
				.flatMap(student -> {
					student.setFechaNacimiento(new Date());
					return servicio.save(student);
					})
		
		.subscribe(student -> log.info("Insert: " + student.getCodigoStudent() + " " + student.getTipoIdentificacion()+ ""+
		student.getNumeroIdentificacion()+""+student.getNombre()+""+student.getFechaNacimiento()+""+student.getGenero()+""+
				student.getNumeroPadres()));
		
	}*/
	
	
	

}
