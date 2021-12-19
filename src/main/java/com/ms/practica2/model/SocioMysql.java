package com.ms.practica2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Socio", catalog = "cine")
public class SocioMysql {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "Secuencia", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "dni", nullable = false)
	private String dni;

	@Column(name = "estado",  nullable = false)
	private String estado;

	@Column(name = "fecha",  nullable = false)
	private String fecha;

}
