package com.ipartek.formacion;

import java.util.HashMap;

public class Diccionarios {
	public static void main(String[] args) {
		var diccionario = new HashMap<String, Integer>();
		
		diccionario.put("uno", 1);
		diccionario.put("dos", 2);
		
		System.out.println(diccionario.get("dos"));
		
		for(String clave: diccionario.keySet()) {
			System.out.println(clave);
		}
		
		for(Integer valores: diccionario.values()) {
			System.out.println(valores);
		}
	}
}
