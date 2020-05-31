/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class RolDTO implements Serializable  {
	private int rol_id;
	private String rol_name;
	

	public int getRol_id() {
		return rol_id;
	}


	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}


	public String getRol_name() {
		return rol_name;
	}


	public void setRol_name(String rol_name) {
		this.rol_name = rol_name;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
