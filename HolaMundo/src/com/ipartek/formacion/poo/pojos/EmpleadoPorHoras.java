package com.ipartek.formacion.poo.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoPorHoras extends Empleado {
	private BigDecimal sueldoPorHora;
	private int numeroHoras;
	
	public EmpleadoPorHoras(Long id, String nombre, LocalDate fechaNacimiento, String dni, BigDecimal sueldoPorHora,
			int numeroHoras) {
		super(id, nombre, fechaNacimiento, dni);
		this.sueldoPorHora = sueldoPorHora;
		this.numeroHoras = numeroHoras;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoPorHora.multiply(new BigDecimal(numeroHoras));
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras [sueldoPorHora=" + sueldoPorHora + ", numeroHoras=" + numeroHoras + "]";
	}
}
