/**
 * 
 */
package com.libreria.dto;

import java.io.Serializable;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class UsuarioRolDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private UsuarioRolDTO usuarioRolDTO;
	private RolDTO rolDTO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UsuarioRolDTO getUsuarioRolDTO() {
		return usuarioRolDTO;
	}
	public void setUsuarioRolDTO(UsuarioRolDTO usuarioRolDTO) {
		this.usuarioRolDTO = usuarioRolDTO;
	}
	public RolDTO getRolDTO() {
		return rolDTO;
	}
	public void setRolDTO(RolDTO rolDTO) {
		this.rolDTO = rolDTO;
	}
	

}

