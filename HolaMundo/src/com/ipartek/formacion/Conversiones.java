package com.ipartek.formacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversiones {
	public static void main(String[] args) {
		double d = 5.6;
		int i = (int) d; // Entre tipos primitivos
		
		i = 5;
		String s = String.valueOf(i); // Primitivo numérico a String
		
		boolean b = true;
		s = b ? "VERDADERO" : "FALSO"; // boolean a String
		
		char c = 'A';
		s = Character.toString(c); // char a String
		
		LocalDate ld = LocalDate.now();
		
		s = ld.toString(); // Cualquier objeto a String
		
		s = "5";
		
		i = Integer.parseInt(s); // De String a primitivo

		s = "true";
		
		b = "true".equals(s); // De String a boolean

		s = "Z";
		
		c = s.trim().charAt(0); // De String a char
		
		s = ld.format(DateTimeFormatter.ISO_DATE);
		
		System.out.println(s);
		
		DateTimeFormatter formatoFechaEspana = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		
		s = ld.format(formatoFechaEspana); // De fecha a texto
		
		System.out.println(s);
		
		s = "02/septiembre/2023";
		
		ld = LocalDate.parse(s, formatoFechaEspana); // De texto a fecha
		
		System.out.println(ld);
	}
}
