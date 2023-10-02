package com.ipartek.formacion.ejemplo.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.ejemplo.entidades.Producto;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocio;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PublicoNegocio negocio = new PublicoNegocioImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recopilar información de la petición
		String nombre = request.getParameter("nombre");
		String precioString = request.getParameter("precio");
		String fechaCaducidadString = request.getParameter("fecha-caducidad");
		
		// Convertimos la información
		BigDecimal precio = new BigDecimal(precioString);
		LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadString);
		
		// Empaquetamos la información en un objeto del modelo (en nuestro caso entidad)
		Producto producto = Producto.builder().nombre(nombre).precio(precio).fechaCaducidad(fechaCaducidad).build();
		
		// Llamamos a la lógica de negocio
		negocio.agregarProducto(producto);
		
		// Empaquetamos información para la siguiente vista
		
		// Pasamos a la siguiente vista
		response.sendRedirect("listado");
	}

}
