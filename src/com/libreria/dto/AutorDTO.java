/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class AutorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String nombre;

}
