package com.ipartek.formacion.canciones.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.canciones.pojo.Cancion;

public interface ModeloCancion {

	ArrayList<Cancion> getAll();

	Cancion getByPosicion(int pos);

	boolean eliminar(int pos);

	boolean insert(Cancion c);

}
