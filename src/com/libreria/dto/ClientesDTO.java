package com.libreria.dto;

import java.io.Serializable;

public class ClientesDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rfc;
	private String nombre;
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
