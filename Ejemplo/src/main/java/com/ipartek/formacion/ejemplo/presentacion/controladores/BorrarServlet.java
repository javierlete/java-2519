package com.ipartek.formacion.ejemplo.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocio;
import com.ipartek.formacion.ejemplo.logicanegocio.PublicoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicoNegocio negocio = new PublicoNegocioImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");

		Long id = Long.parseLong(idString);

		negocio.eliminarProducto(id);

		response.sendRedirect("listado");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}