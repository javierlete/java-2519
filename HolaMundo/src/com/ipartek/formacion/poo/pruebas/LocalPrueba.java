package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.pojos.Local;
import com.ipartek.formacion.poo.pojos.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		Local local = new Local(1L, "Ipartek");
		
		Persona persona1 = new Persona(1L, "Javier Lete", LocalDate.of(2000, 1, 2));
		
		local.entrar(persona1);
		// local.entrar(null);
//		local.entrar(new Persona(2L, "Pepe Pérez", LocalDate.of(2010, 1, 2)));
		
		// local.salir(persona1);
		// local.salir(new Persona(2L, "Pepe Pérez", LocalDate.of(2005, 1, 2)));

		local.salir(1L);
		local.entrar(new Persona(3L, "Otro Otrez", LocalDate.of(2000, 1, 2)));
		local.entrar(new Persona(4L, "Uno Masez", LocalDate.of(2000, 1, 2)));
		
		for(Persona persona: local.getPersonas()) {
			persona.setNombre("Modificado Modificadez");
			System.out.println(persona.getNombre());
		}
		
		for(Persona persona: local.getPersonas()) {
			System.out.println(persona.getNombre());
		}
		
//		System.out.println(local.getPersona(2L));
	}
}
