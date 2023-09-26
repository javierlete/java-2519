package com.ipartek.formacion.poo.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class EmpleadoIndefinido extends Empleado {

	private BigDecimal sueldoAnual;
	private int numeroPagas;
	
	public EmpleadoIndefinido(Long id, String nombre, LocalDate fechaNacimiento, String dni, BigDecimal sueldoAnual,
			int numeroPagas) {
		super(id, nombre, fechaNacimiento, dni);
		this.sueldoAnual = sueldoAnual;
		this.numeroPagas = numeroPagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return "EmpleadoIndefinido [sueldoAnual=" + sueldoAnual + ", numeroPagas=" + numeroPagas + "]";
	}
}
