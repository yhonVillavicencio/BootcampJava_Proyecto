package com.microservicio.coontroller;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public Mono<ResponseEntity<Student>> crear(@RequestBody Student student){
		
		if(student.getFechaNacimiento()==null) {
			student.setFechaNacimiento(new Date());
		}
		
		return servicio.save(student).map(s-> ResponseEntity
				.created(URI.create("/api/student/".concat(s.getCodigoStudent())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(s)
				);
	}
	
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Student>> editar(@RequestBody Student student, @PathVariable String id){
		return servicio.findById(id).flatMap(s -> {
			s.setTipoIdentificacion(student.getTipoIdentificacion());
			s.setNumeroIdentificacion(student.getNumeroIdentificacion());
			s.setFechaNacimiento(student.getFechaNacimiento());
			s.setGenero(student.getGenero());
			s.setNumeroPadres(student.getNumeroPadres());
			
			return servicio.save(s);
		}).map(s->ResponseEntity.created(URI.create("/api/students/".concat(s.getCodigoStudent())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(s))
		.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id){
		return servicio.findById(id).flatMap(s ->{
			return servicio.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}


}


