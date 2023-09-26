package com.ipartek.formacion.poo.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Empleado extends Adulto {

	public Empleado(Long id, String nombre, LocalDate fechaNacimiento, String dni) {
		super(id, nombre, fechaNacimiento, dni);
	}
	
	public abstract BigDecimal getSueldoMensual();
}
