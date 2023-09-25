package com.ipartek.formacion.poo.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Adulto extends Persona {
	private String dni;

	public Adulto(Long id, String nombre, LocalDate fechaNacimiento, String dni) {
		super(id, nombre, fechaNacimiento);
		setDni(dni);
	}
	
	public Adulto(String nombre, LocalDate fechaNacimiento, String dni) {
		this(null, nombre, fechaNacimiento, dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null || fechaNacimiento.plusYears(18).isAfter(LocalDate.now())) {
			throw new RuntimeException("Debes dar la fecha de nacimiento y ser mayor de edad para ser adulto");
		}
		
		super.setFechaNacimiento(fechaNacimiento);
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dni);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adulto other = (Adulto) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Adulto [id=" + getId() + ", nombre=" + getNombre()
				+ ", fechaNacimiento=" + getFechaNacimiento() + ", dni=" + dni + "]";
	}
	
	
}
