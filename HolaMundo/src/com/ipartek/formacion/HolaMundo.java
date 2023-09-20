package com.ipartek.formacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase de demostración de Java
 */
public class HolaMundo {
	/**
	 * Punto de entrada de la máquina virtual
	 * 
	 * @param args argumentos de línea de comando
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		/*
		 * Ejemplo básico de Java Características básicas
		 */

		System.out.println("Hola a todos"); // Muestra una línea

		Date hoy = new Date();

		System.out.println(hoy);

		Date d = new Date(2023 - 1900, 9 - 1, 20, 10, 59, 00);

		System.out.println(d);
		System.out.println(d.getYear() + 1900);
		System.out.println(d.getMonth() + 1);
		System.out.println(d.getDate());

		GregorianCalendar gc = new GregorianCalendar(2023, 8, 20);

		System.out.println(gc);

		System.out.println(gc.get(Calendar.YEAR));
		System.out.println(gc.get(Calendar.MONTH) + 1);
		System.out.println(gc.get(Calendar.DATE));

		LocalDateTime ldt = LocalDateTime.of(2023, 9, 20, 11, 10);

		System.out.println(ldt);

		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());

		LocalDate ld = LocalDate.of(2024, 1, 31);

		System.out.println(ld.plusMonths(1));

		int x = 5;
		int y = x;
		x = 9;

		System.out.println(x);
		System.out.println(y);
		
		System.out.println(x == y);

//		String s1 = "Javier"; // String s1 = 0x100;
//		String s2 = "Javier"; // String s2 = 0x100;

		String s1 = new String("Javier"); // String s1 = 0x100;
		String s2 = new String("Javier"); // String s2 = 0x200;
		
		System.out.println(s1 == s2); // ¿Son el mismo objeto? No
		System.out.println(s1.equals(s2)); // ¿Son iguales? Sí
		
		System.out.println(s1.charAt(1) == s2.charAt(1));
		
		String saludo = "Hola " + s1;
		
		System.out.println(saludo);
		
		String saludo2 = new StringBuffer().append("Hola ").append(s1).toString();
		
		System.out.println(saludo2);
		
		String log = "Primera línea\n";
		
		log += "Segunda línea\n";
		log += "Tercera línea\n";
		
		System.out.println(log);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("Primera línea\n");
		sb.append("Segunda línea\n");
		sb.append("Tercera línea\n");
		
		log = sb.toString();
		
		System.out.println(log);
		
		Long l = 1123123123123123123l; // Autoboxing
		
		System.out.println(l);
	}
}
