package com.ipartek.formacion.ejemplo.logicanegocio;

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
	public Producto agregarProducto(Producto producto) {
		log.info("Se va a insertar el producto " + producto);
		
		var errores = validator.validate(producto);
		if(errores.size() > 0) {
			throw new LogicaNegocioException("No se admiten productos sin validar");
		}
		
		return daoProducto.insertar(producto);
	}

}
