package com.ipartek.formacion.canciones.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.canciones.pojo.Cancion;

public interface ModeloCancion {

	ArrayList<Cancion> getAll();

	Cancion getById(long id);

	boolean delete(long id);

	boolean insert(Cancion c);
	
	boolean update(Cancion c,long id);

}
