package com.ipartek.formacion.canciones.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.canciones.modelo.ModeloCancionImpl;
import com.ipartek.formacion.canciones.pojo.Cancion;

/**
 * Servlet implementation class CrearController
 */
@WebServlet("/crear")
public class CrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger PARAMETROS del formulario

		ModeloCancionImpl model = ModeloCancionImpl.getInstance();

		String nombre = request.getParameter("nombre");
		String artista = request.getParameter("artista");
		String duracion = request.getParameter("duracion");

		// creamos la cancion

		Cancion c = new Cancion(nombre, artista, duracion);

		//guardamos la cancion
		String mensajeUsuario="";
		if(model.insert(c)) {
			mensajeUsuario="Tenemos nueva cancion";
		}else {
			
			System.out.println("Ha surgido un problema");
			
		}
		//model.insert(c);
		
		// enviamos cancion como ATRIBUTO en la request
		
		request.setAttribute("listado", model.getAll());
	//	request.setAttribute("cancion", c);
		request.setAttribute("mensaje", mensajeUsuario);

		// vamos a la listado.JSP

		RequestDispatcher dispatch = request.getRequestDispatcher("listado.jsp");
		dispatch.forward(request, response);

	}

}
