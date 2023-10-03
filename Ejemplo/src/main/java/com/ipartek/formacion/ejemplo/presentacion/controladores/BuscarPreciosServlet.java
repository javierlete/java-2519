package com.ipartek.formacion.ejemplo.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.ejemplo.entidades.Producto;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocio;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscarprecios")
public class BuscarPreciosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicoNegocio negocio = new PublicoNegocioImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String minimoString = request.getParameter("minimo");
		String maximoString = request.getParameter("maximo");

		BigDecimal minimo = new BigDecimal(minimoString);
		BigDecimal maximo = new BigDecimal(maximoString);
		
		Iterable<Producto> productos = negocio.obtenerProductosPorPrecio(minimo, maximo);

		request.setAttribute("productos", productos);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}