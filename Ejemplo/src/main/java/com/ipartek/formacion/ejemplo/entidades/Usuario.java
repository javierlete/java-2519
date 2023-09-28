package com.ipartek.formacion.ejemplo.entidades;

import lombok.Data;

@Data
public class Usuario {
	private Long id;
	private String email;
	private String password;
}
