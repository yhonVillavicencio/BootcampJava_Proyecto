package com.microservicio.coontroller;

import java.net.URI;
import java.security.Provider.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;

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
	public Mono<ResponseEntity<Map<String, Object>>> crear(@Valid @RequestBody Mono<Student> monoStudent){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		return monoStudent.flatMap(student -> {
			if(student.getFechaNacimiento()==null) {
				student.setFechaNacimiento(new Date());
			}
			
			return servicio.save(student).map(p-> {
				respuesta.put("student", p);
				respuesta.put("mensaje", "Estudiante creado con éxito");
				respuesta.put("timestamp", new Date());
				return ResponseEntity
					.created(URI.create("/api/student/".concat(p.getCodigoStudent())))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(respuesta);
				});
			
		}).onErrorResume(t -> {
			return Mono.just(t).cast(WebExchangeBindException.class)
					.flatMap(e -> Mono.just(e.getFieldErrors()))
					.flatMapMany(Flux::fromIterable)
					.map(fieldError -> "El campo "+fieldError.getField() + " " + fieldError.getDefaultMessage())
					.collectList()
					.flatMap(list -> {
						respuesta.put("errors", list);
						respuesta.put("timestamp", new Date());
						respuesta.put("status", HttpStatus.BAD_REQUEST.value());
						return Mono.just(ResponseEntity.badRequest().body(respuesta));
					});
							
		});
		

	}
		

}


