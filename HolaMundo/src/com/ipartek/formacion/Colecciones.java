package com.ipartek.formacion;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		var lista = new ArrayList<String>();
		
		lista.add("Prueba");
		lista.add("Otro");
		lista.add("Lalaralalaaa");
		
		for(String dato: lista) {
			System.out.println(dato);
		}
		
		System.out.println(lista.get(1));
		
		ArrayList<Integer> enteros = new ArrayList<>();
		
		enteros.add(5);
		enteros.add(6);
		
		for(Integer entero: enteros) {
			System.out.println(entero);
		}
	}
}
