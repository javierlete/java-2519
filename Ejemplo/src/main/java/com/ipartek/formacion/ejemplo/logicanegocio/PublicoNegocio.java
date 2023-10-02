package com.ipartek.formacion.ejemplo.logicanegocio;

import com.ipartek.formacion.ejemplo.entidades.Producto;

public interface PublicoNegocio {
	public Iterable<Producto> obtenerProductos();
	public Producto agregarProducto(Producto producto);
}
