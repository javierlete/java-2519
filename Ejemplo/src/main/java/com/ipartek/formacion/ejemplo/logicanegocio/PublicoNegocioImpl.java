package com.ipartek.formacion.ejemplo.logicanegocio;

import com.ipartek.formacion.ejemplo.accesodatos.ProductoDao;
import com.ipartek.formacion.ejemplo.accesodatos.ProductoDaoSqlite;
import com.ipartek.formacion.ejemplo.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class PublicoNegocioImpl implements PublicoNegocio {
	private ProductoDao daoProducto = new ProductoDaoSqlite(); 
	
	@Override
	public Iterable<Producto> obtenerProductos() {
		log.info("Se han pedido todos los productos");
		return daoProducto.selectTodos();
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		log.info("Se va a insertar el producto " + producto);
		return daoProducto.insertar(producto);
	}

}
