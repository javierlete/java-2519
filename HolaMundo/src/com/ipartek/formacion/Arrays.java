package com.ipartek.formacion;

public class Arrays {
	public static void main(String[] args) {
		var arr = new int[3];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(int dato: arr) {
			System.out.println(dato);
		}
	}
}
