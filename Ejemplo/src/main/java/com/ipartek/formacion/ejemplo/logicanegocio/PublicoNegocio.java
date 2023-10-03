package com.ipartek.formacion.ejemplo.logicanegocio;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplo.entidades.Producto;

public interface PublicoNegocio {
	public Iterable<Producto> obtenerProductos();
	public Producto obtenerProductoPorId(Long id);
	public Iterable<Producto> obtenerProductosPorNombre(String nombre);
	public Iterable<Producto> obtenerProductosPorPrecio(BigDecimal minimo, BigDecimal maximo);
	
	public Producto agregarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public void eliminarProducto(Long id);
}
