package com.microservicio.coontroller;

import java.security.Provider.Service;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.model.Student;
import com.microservicio.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/student") // asignar una ruta principal
public class StudentController {
	
	@Autowired
	private StudentService servicio;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Student>>> lista(){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(servicio.findAll())
				);
		
	}
	


}
