package com.ipartek.formacion.canciones.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.canciones.pojo.Cancion;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/listar")
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Crear array con "x" canciones

		ArrayList<Cancion> canciones = new ArrayList<Cancion>();

		canciones.add(new Cancion("cancion1", "artista1", "duracion1"));
		canciones.add(new Cancion("cancion2", "artista2", "duracion2"));
		canciones.add(new Cancion("cancion3", "artista3", "duracion3"));
		canciones.add(new Cancion("cancion4", "artista4", "duracion4"));

		// pasar ATRIBUTO listado en la request para la JSP

		request.setAttribute("listado", canciones);

		// ir a la listar.JSP

		RequestDispatcher dispatch = request.getRequestDispatcher("listado.jsp");
		dispatch.forward(request, response);

	}

}
