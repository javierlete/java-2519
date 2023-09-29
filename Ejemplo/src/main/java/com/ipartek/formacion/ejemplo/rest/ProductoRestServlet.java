package com.ipartek.formacion.ejemplo.rest;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ipartek.formacion.ejemplo.entidades.Producto;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocio;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos")
public class ProductoRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicoNegocio negocio = new PublicoNegocioImpl();

	private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		Iterable<Producto> productos = negocio.obtenerProductos();

		mapper.writeValue(out, productos);
	}
}
