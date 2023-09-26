package com.ipartek.formacion.poo.pojos;

public class Fraccion extends Number {
	private static final long serialVersionUID = 4083237087862101493L;

	private double a, b;

	public Fraccion(double a, double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int intValue() {
		return (int) (a / b);
	}

	@Override
	public long longValue() {
		return (long) (a / b);
	}

	@Override
	public float floatValue() {
		return (float) (a / b);
	}

	@Override
	public double doubleValue() {
		return a / b;
	}

	@Override
	public String toString() {
		return a + "/" + b;
	}

}
