package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.pojos.Adulto;
import com.ipartek.formacion.poo.pojos.Persona;

public class AdultoPrueba {
	public static void main(String[] args) {
		Adulto adulto = new Adulto("Uno", LocalDate.of(2000, 1, 2), "12341235");

		System.out.println(adulto);
		
		System.out.println("adulto = " + adulto);

		Persona persona = adulto;

//		persona.setFechaNacimiento(null);
		
//		System.out.println(persona.getDni());

		System.out.println("persona = " + persona);

		if (persona instanceof Adulto otroAdulto) {
//			Adulto otroAdulto = (Adulto) persona;

			System.out.println(otroAdulto.getDni());
		}
		
		Persona otraPersona = new Persona();

		if (otraPersona instanceof Adulto) {
			Adulto nuevoAdulto = (Adulto) otraPersona;
			System.out.println(nuevoAdulto.getDni());
		} else {
			System.out.println("No es adulto");
		}
	}
}
