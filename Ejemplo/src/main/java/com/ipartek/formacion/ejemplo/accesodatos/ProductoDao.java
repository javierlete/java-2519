package com.ipartek.formacion.ejemplo.accesodatos;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplo.entidades.Producto;

public interface ProductoDao extends Dao<Producto> {
	public Iterable<Producto> selectPorNombre(String nombre);
	public Iterable<Producto> selectPorRangoPrecio(BigDecimal precioMinimo, BigDecimal precioMaximo);
}
