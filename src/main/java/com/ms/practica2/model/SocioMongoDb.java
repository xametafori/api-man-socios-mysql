package com.ms.practica2.model;


import lombok.Data;

@Data
public class SocioMongoDb {

	private String dni;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String telefono;
	private Integer estado;
	private String tipoMembresia;
	private Integer port;


}
