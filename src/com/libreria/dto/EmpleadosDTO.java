/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class EmpleadosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String nombre;
	private PuestoDTO puestoDTO;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public PuestoDTO getPuestoDTO() {
		return puestoDTO;
	}
	public void setPuestoDTO(PuestoDTO puestoDTO) {
		this.puestoDTO = puestoDTO;
	}
	

}
