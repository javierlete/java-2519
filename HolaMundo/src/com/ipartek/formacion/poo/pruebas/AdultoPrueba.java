package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.pojos.Adulto;
import com.ipartek.formacion.poo.pojos.Local;
import com.ipartek.formacion.poo.pojos.Persona;

// java com.ipartek.formacion.poo.pruebas.AdultoPrueba 1 2 3
// AdultoPrueba.main(new String[]{ 1, 2, 3 })

public class AdultoPrueba {
	public static void main(String[] args) {
		
		Adulto adulto = new Adulto("Uno", LocalDate.of(2000, 1, 2), "    12341235a      ");

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
		
		Local local = new Local(1L, "Ipartek");
		
		otraPersona.setFechaNacimiento(LocalDate.of(2000, 2, 1));
		
		local.entrar(otraPersona);
		local.entrar(adulto);
		
		Adulto.setMayoriaDeEdad(20);
		Adulto nuevoAdulto = new Adulto(otraPersona, "12345678a");
		
		local.salir(otraPersona);
		local.entrar(nuevoAdulto);
		
		local.getPersonas().forEach(p -> System.out.println(p));
	}
}
