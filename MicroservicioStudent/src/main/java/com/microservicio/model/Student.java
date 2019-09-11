package com.microservicio.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //lombok

@Document(collection="Student")
public class Student {
	
	@Id
	private String codigoStudent;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	private String genero;
	private int numeroPadres;
	
	
	
	public Student(String tipoIdentificacion, String numeroIdentificacion, String nombre, String genero,
			int numeroPadres) {
	
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.genero = genero;
		this.numeroPadres = numeroPadres;
	}

	public Student() {
	
	}
	

}
