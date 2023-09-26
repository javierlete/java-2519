package com.ipartek.formacion.poo.pruebas;

import com.ipartek.formacion.poo.pojos.Fraccion;

public class EjemploClasesAbstractas {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Number[] numeros = new Number[3];
		
		numeros[0] = new Integer(5);
		numeros[1] = new Double(1.2);
		numeros[2] = new Fraccion(2, 3);
		
		for(Number numero: numeros) {
			System.out.println(numero.doubleValue());
		}
	}

}
