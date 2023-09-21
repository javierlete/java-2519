package com.ipartek.formacion;

import java.io.Console;
import java.util.Scanner;

public class EjemploConsola {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean esNumero = false;

		do {
			try {
				System.out.print("Dime un número: ");
				int numero = Integer.parseInt(sc.nextLine());
				System.out.println(numero);

				esNumero = true;
			} catch (NumberFormatException e) {
				// e.printStackTrace();
				System.out.println("El texto introducido no tiene el formato de un número");
			}
		} while (!esNumero);

		System.out.print("Dime tu nombre: ");

		String nombre = sc.nextLine();

		System.out.println("Hola " + nombre);

		// Eclipse no soporta la System.console() y da un NullPointerException
		Console console = System.console();

		if (console == null) {
			System.out.println("No tenemos acceso a la consola");
		} else {
			String prueba = console.readLine();

			System.out.println(prueba);
		}
		
		sc.close();
	}
}