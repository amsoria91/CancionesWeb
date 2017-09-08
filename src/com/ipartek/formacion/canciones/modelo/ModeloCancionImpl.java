package com.ipartek.formacion.canciones.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.canciones.pojo.Cancion;

public class ModeloCancionImpl implements ModeloCancion{
	
	ArrayList<Cancion> canciones = new ArrayList<Cancion>();

	@Override
	public ArrayList<Cancion> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancion getByPosicion(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(int pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Cancion c) {
		// TODO Auto-generated method stub
		return false;
	}

}
