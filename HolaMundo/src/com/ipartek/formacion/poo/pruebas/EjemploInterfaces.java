package com.ipartek.formacion.poo.pruebas;

import java.util.ArrayList;

import com.ipartek.formacion.poo.pojos.interfaces.Balon;
import com.ipartek.formacion.poo.pojos.interfaces.Comestible;
import com.ipartek.formacion.poo.pojos.interfaces.Esferico;
import com.ipartek.formacion.poo.pojos.interfaces.Naranja;

public class EjemploInterfaces {
	public static void main(String[] args) {
		var saco = new ArrayList<Esferico>();

		saco.add(new Naranja());
		saco.add(new Balon());

		for (Esferico esferico : saco) {
			if (esferico instanceof Comestible comestible) {
				comestible.comer();
			}
			
			esferico.rodar();
	
			if (esferico instanceof Comestible comestible) {
				comestible.comer();
			}
		}
	}
}
