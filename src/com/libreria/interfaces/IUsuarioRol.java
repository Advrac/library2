/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;

import com.libreria.dto.RolDTO;
import com.libreria.dto.UsuarioRolDTO;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IUsuarioRol {
	public boolean save(  UsuarioRolDTO usuarioRolDTO, RolDTO rolDTO);
	//READ 
	public Collection<UsuarioRolDTO> getALL();
	//UDATE
	public boolean update (UsuarioRolDTO usuarioRolDTO, RolDTO rolDTO) ;
	//DELET
	public boolean delete (UsuarioRolDTO usuarioRolDTO, RolDTO rolDTO);
	//findById
	public UsuarioRolDTO findByid(int rol_id);

}
