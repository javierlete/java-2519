package com.ipartek.formacion.poo.pojos.interfaces;

public class Naranja extends Fruto implements Comestible, Esferico {
	private boolean porElSuelo = false;
	
	@Override
	public void rodar() {
		porElSuelo = true;
		System.out.println("Naranja rodando");
	}

	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("¡PUAJ, QUE ASCO!");
		} else {
			System.out.println("Ñam, que rica");
		}
	}

}
