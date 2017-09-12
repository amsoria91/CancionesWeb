package com.ipartek.formacion.canciones.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.canciones.pojo.Cancion;

public class ModeloCancionTest {

	@Test
	public void test() {

		ModeloCancionImpl model = ModeloCancionImpl.getInstance();

		assertEquals(3, model.getAll().size());
		
		//insertar nueva Cancion
		Cancion c = new Cancion("Corazon de mimbre", "Marea", "5:37");
		assertTrue("No ha podido insertar la cancion",model.insert(c));
		assertEquals("No ha generado bien el IDentificador",526, c.getId());
		assertEquals(4, model.getAll().size());

		//buscar por ID
		
		assertNull(model.getById(-1));
		assertEquals(c, model.getById(526));
		
					//eliminar
		
		
		assertFalse(model.delete(-1));
		assertTrue(model.delete(526));
		assertEquals(3, model.getAll().size());
		assertNull(model.getById(526));
		
		//update
		Cancion cModificar = model.getById(525);
		cModificar.setNombre("El conejo de la loles");
		cModificar.setArtista("Popular-anonima");
		assertTrue(model.update(cModificar, cModificar.getId()));
		assertFalse(model.update(cModificar,-1));
		assertFalse(model.update(null, -1));
		

		
	}

}
