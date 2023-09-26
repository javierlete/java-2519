package com.ipartek.formacion.poo.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.poo.pojos.Adulto;
import com.ipartek.formacion.poo.pojos.Empleado;
import com.ipartek.formacion.poo.pojos.EmpleadoIndefinido;
import com.ipartek.formacion.poo.pojos.EmpleadoPorHoras;
import com.ipartek.formacion.poo.pojos.Local;
import com.ipartek.formacion.poo.pojos.Persona;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		Local local = new Local(1L, "Ipartek");
		
		local.entrar(new Adulto(0L, "Pepe", LocalDate.of(1990, 1, 2), "12345678A"));
		local.entrar(new EmpleadoIndefinido(1L, "Javier", LocalDate.of(2000,  2, 3), "12345678A", new BigDecimal("12345.67"), 14));
		local.entrar(new EmpleadoPorHoras(2L, "Pepe", LocalDate.of(2000,  2, 3), "12345678A", new BigDecimal("45.67"), 40));
		
		BigDecimal total = BigDecimal.ZERO;
		
		BigDecimal sueldo;
		
		for(Persona persona: local.getPersonas()) {
			System.out.println(persona);
			
			if(persona instanceof Empleado empleado) {
				sueldo = empleado.getSueldoMensual();
				total = total.add(sueldo);
				
				System.out.println(sueldo);
			}
		}
		
		System.out.println(total);
	}
}
