/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;

/**
 * @author Aldo Adrian Vargas Acu�a
 *
 */
public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}
