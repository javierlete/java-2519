package com.ipartek.formacion.ejemplo.logicanegocio;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplo.accesodatos.ProductoDao;
import com.ipartek.formacion.ejemplo.accesodatos.ProductoDaoSqlite;
import com.ipartek.formacion.ejemplo.entidades.Producto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.java.Log;

@Log
public class PublicoNegocioImpl implements PublicoNegocio {
	private ProductoDao daoProducto = new ProductoDaoSqlite(); 
	
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

	@Override
	public Iterable<Producto> obtenerProductos() {
		log.info("Se han pedido todos los productos");
		return daoProducto.selectTodos();
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		log.info("Se ha pedido el producto " + id);
		return daoProducto.selectPorId(id);
	}

	@Override
	public Iterable<Producto> obtenerProductosPorNombre(String nombre) {
		log.info("Se han pedido los producto con nombre " + nombre);
		return daoProducto.selectPorNombre(nombre);
	}

	@Override
	public Iterable<Producto> obtenerProductosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		log.info(String.format("Se han pedido los producto con precio entre %s y %s", minimo, maximo));
		return daoProducto.selectPorRangoPrecio(minimo, maximo);
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		log.info("Se va a insertar el producto " + producto);
		
		var errores = validator.validate(producto);
		if(errores.size() > 0) {
			throw new LogicaNegocioException("No se admiten productos sin validar");
		}
		
		return daoProducto.insertar(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		log.info("Se va a modificar el producto a " + producto);
		
		var errores = validator.validate(producto);
		if(errores.size() > 0) {
			throw new LogicaNegocioException("No se admiten productos sin validar");
		}
		
		return daoProducto.modificar(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		log.info("Se va a eliminar el producto " + id);
		daoProducto.borrar(id);
	}

}
