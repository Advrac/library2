/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class AutorlibroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AutorDTO aut_id;
	private LIbroDTO  lib_isbn;
	public AutorDTO getAut_id() {
		return aut_id;
	}
	public void setAut_id(AutorDTO aut_id) {
		this.aut_id = aut_id;
	}
	public LIbroDTO getLib_isbn() {
		return lib_isbn;
	}
	public void setLib_isbn(LIbroDTO lib_isbn) {
		this.lib_isbn = lib_isbn;
	}
	

}
