package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.pojos.Persona;

public class PersonaPrueba {
	public static void main(String[] args) {
		Persona persona;
		
		persona = new Persona();
		
		System.out.println(persona.getNombre());
		
		try {
			persona.setNombre("    ");
		} catch (Exception e) {
			System.out.println("No se ha podido cambiar el nombre");
		}
		
		System.out.println(persona.getNombre());
		
		System.out.println(persona);
		
		persona = new Persona(2L, "Javier Lete", LocalDate.of(2000, 1, 2));
		
		System.out.println(persona.getId());
		System.out.println(persona.getNombre());
		System.out.println(persona.getFechaNacimiento());
		
		persona = new Persona(3L, "asdf", null);
		
		System.out.println(persona.getId());
		
		persona.setId(7L);
		
		Persona p1 = new Persona(1L, "Javi", LocalDate.of(2001, 10, 11)); // p1 = 0x100
		Persona p2 = new Persona(p1); // p2 = 0x100
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		p1.setFechaNacimiento(LocalDate.of(2000, 1, 2));
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
