package com.ipartek.formacion.poo.pojos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Local {
	private Long id;
	private String nombre;
	private ArrayList<Persona> personas = new ArrayList<>();

	public Local(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getPersona(Long idPersona) {
		return personas.stream().filter(persona -> persona.getId() == idPersona).findFirst().orElse(null);

//		Stream<Persona> stream = personas.stream();
//		Stream<Persona> filtrados = stream.filter(persona -> persona.getId() == idPersona);
//		Optional<Persona> primero = filtrados.findFirst();
//		Persona persona = primero.orElse(null);
//		
//		return persona;
	}

	public Iterable<Persona> getPersonas(String nombre) {
		return personas.stream().filter(persona -> persona.getNombre().contains(nombre)).toList();
	}

	public Iterable<Persona> getPersonas() {
		return new ArrayList<Persona>(personas);

//		var al = new ArrayList<Persona>();
//		
//		for(Persona persona: personas) {
//			al.add(new Persona(persona));
//		}
//		
//		return al;
	}

	public int getCuantasPersonas() {
		return personas.size();
	}

	public void entrar(Persona persona) {
		if (persona == null) {
			throw new RuntimeException("Es obligatorio dar un objeto de tipo persona");
		}

		if (persona.getFechaNacimiento().plusYears(18).isAfter(LocalDate.now())) {
			throw new RuntimeException("Debe ser mayor de edad para entrar");
		}

		personas.add(persona);
	}

	public void salir(Persona persona) {
		personas.remove(persona);
	}

	public void salir(Long idPersona) {
		personas.removeIf(persona -> persona.getId() == idPersona);

//		personas.removeIf(new Predicate<Persona>() {
//			public boolean test(Persona persona) {
//				return persona.getId() == idPersona;
//			}
//		});

//		ComparacionPersona comparador = new ComparacionPersona(idPersona);
//		personas.removeIf(comparador);
	}

//	static class ComparacionPersona implements Predicate<Persona> {
//		private Long idPersona;
//		
//		public ComparacionPersona(Long idPersona) {
//			this.idPersona = idPersona;
//		}
//		
//		public boolean test(Persona persona) {
//			return persona.getId() == idPersona;
//		}
//	}
}
