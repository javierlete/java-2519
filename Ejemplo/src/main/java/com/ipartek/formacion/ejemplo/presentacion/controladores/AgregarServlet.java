package com.ipartek.formacion.ejemplo.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ipartek.formacion.ejemplo.entidades.Producto;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocio;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@WebServlet("/agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicoNegocio negocio = new PublicoNegocioImpl();

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recopilar información de la petición
		String idString = request.getParameter("id"); 
		String nombre = request.getParameter("nombre");
		String precioString = request.getParameter("precio");
		String fechaCaducidadString = request.getParameter("fecha-caducidad");

		// Convertimos la información
		Long id = idString != null && idString.trim().length() != 0 ? Long.parseLong(idString) : null;
		BigDecimal precio = precioString.trim().length() == 0 ? null : new BigDecimal(precioString);
		LocalDate fechaCaducidad = fechaCaducidadString.isBlank() ? null : LocalDate.parse(fechaCaducidadString);

		// Empaquetamos la información en un objeto del modelo (en nuestro caso entidad)
		Producto producto = Producto.builder().id(id).nombre(nombre).precio(precio).fechaCaducidad(fechaCaducidad).build();

		// Validar el modelo
		Set<ConstraintViolation<Producto>> constraintViolations = validator.validate(producto);

		Map<String, String> errores = new HashMap<>();

		for (ConstraintViolation<Producto> constraintViolation : constraintViolations) {
			String propiedad = constraintViolation.getPropertyPath().toString();
			String mensaje = constraintViolation.getMessage();

			if (errores.containsKey(propiedad)) {
				mensaje = errores.get(propiedad) + ", " + mensaje;
			}

			errores.put(propiedad, mensaje);
		}

		if (errores.size() > 0) {
			// Empaquetamos información para la siguiente vista
			request.setAttribute("errores", errores);
			request.setAttribute("producto", producto);
			// Pasamos a la siguiente vista
			request.getRequestDispatcher("listado").forward(request, response);
		} else {
			// Llamamos a la lógica de negocio
			if(id == null) {
				negocio.agregarProducto(producto);
			} else {
				negocio.modificarProducto(producto);
			}
			
			// Pasamos a la siguiente vista
			response.sendRedirect("listado");
		}

	}

}
