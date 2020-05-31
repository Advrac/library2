/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class PermisoDTO implements Serializable {
	private int per_id;
	private RolDTO fk_Rol;
	private String per_nombre;
	private String per_permiso;
	

	public int getPer_id() {
		return per_id;
	}


	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}


	public RolDTO getFk_Rol() {
		return fk_Rol;
	}


	public void setFk_Rol(RolDTO fk_Rol) {
		this.fk_Rol = fk_Rol;
	}


	public String getPer_nombre() {
		return per_nombre;
	}


	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}


	public String getPer_permiso() {
		return per_permiso;
	}


	public void setPer_permiso(String per_permiso) {
		this.per_permiso = per_permiso;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
