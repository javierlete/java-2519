package com.ipartek.formacion.poo.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	// Variables de instancia
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;

	// Constructores
	public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this(null, nombre, fechaNacimiento);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null);
	}

	public Persona() {
		this(null, "Anónimo", null);
	}

	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getFechaNacimiento());
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id != null && id < 0) {
			throw new RuntimeException("No se admiten ids negativos");
		}
		
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 3) {
			throw new RuntimeException("El nombre es obligatorio y debe tener al menos 3 caracteres");
		}
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
			throw new RuntimeException("La fecha de nacimiento debe ser la actual o anterior");
		}
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
