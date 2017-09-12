package com.ipartek.formacion.canciones.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.canciones.pojo.Cancion;

/**
 * Clase para gestionar las Canciones en memoria mediante un ArrayList, mas
 * adelante aprenderemos a hacer lo mismo con un BBDD(Base de Datos).
 * 
 * Vamos a uesar un patron <b>singleton</b> para que exista una uncia instancia
 * de esta clase.
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * 
 * @author Administrador
 *
 */
public class ModeloCancionImpl implements ModeloCancion {

	private static ModeloCancionImpl INSTANCE = null;

	private static ArrayList<Cancion> canciones;

	// simula el indice de una tabla en bbdd

	private long indice = 1;

	// Constructor privado

	private ModeloCancionImpl() {
		super();
		this.canciones = new ArrayList<Cancion>();
		crearMocks();
	}

	// Crear un acceso para la clase

	public synchronized static ModeloCancionImpl getInstance() {

		if (INSTANCE == null) {

			INSTANCE = new ModeloCancionImpl();

		}

		return INSTANCE;

	}

	/**
	 * Crear juego de datos para probar
	 */
	private void crearMocks() {

		Cancion c = new Cancion("Dont speak", "No doubt", "4:23");
		c.setId(525);
		this.canciones.add(c);

		c = new Cancion("Fiesta", "Celtas Cortos", "4:15");
		c.setId(25);
		this.canciones.add(c);

		c = new Cancion("Hijos de Cain", "Baron Rojo", "5:18");
		c.setId(69);
		this.canciones.add(c);

		this.indice = 526;

		System.out.println(canciones.get(0).getId());

	}

	@Override
	public ArrayList<Cancion> getAll() {
		// TODO Auto-generated method stub
		return this.canciones;
	}

	/**
	 * Busca cancion por ID
	 * 
	 * @param id
	 *            long identificador de la cancion
	 * @return null si no encuentra,instancia de Cancion si encuentra
	 */
	@Override
	public Cancion getById(long id) {

		Cancion resul = null;
		Cancion cActual = null;

		for (int i = 0; i < canciones.size(); i++) {

			cActual = this.canciones.get(i);

			if (cActual.getId() == id) {

				resul = cActual;

			}
		}

		return resul;
	}

	@Override
	public boolean delete(long id) {

		boolean resul = false;
		Cancion cActual = null;

		for (int i = 0; i < canciones.size(); i++) {

			cActual = this.canciones.get(i);

			if (cActual.getId() == id) {

				resul = this.canciones.remove(cActual);
				break;
			}
		}

		return resul;

	}

	/**
	 * Al insertar no tenemos ID, buescar el ID mas alto de todas las canciones y le
	 * sumamos 1.
	 */
	@Override
	public boolean insert(Cancion c) {

		boolean resul = false;
		if(c!=null) {
			
			c.setId(indice);
			resul = this.canciones.add(c);
			if (resul) {

				indice++;
			}
		}
		

		return resul;

	}

	/**
	 * Modificamos una Cancion
	 * 
	 * @param c
	 *            Cancion a modificar
	 * @param id
	 *            long IDentificador de la cancion a modificar
	 * @return true si modifica,false en caso contrario
	 */
	@Override
	public boolean update(Cancion c, long id) {

		boolean resul = false;

		if (c != null) {

			for (int i = 0; i < canciones.size(); i++) {

				c = this.canciones.get(i);

				if (c.getId() == id) {

					this.canciones.set(i, c);
					// c=new Cancion("", "", "");
					resul = true;
					break;
				}
			}
		}

		return resul;
	}

}
