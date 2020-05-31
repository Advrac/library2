/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;

import com.libreria.dto.Usuario1DTO;



/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IUsuario1 {
	public boolean save(String _Username, String _clave, String _privilegio);
	//READ 
	public Collection<Usuario1DTO> getALL();
	//UDATE
	public boolean update (String _Username, String _clave, String _privilegio) ;
	//DELET
	public boolean delete (String _Username, String _clave, String _privilegio);
	//findById
	public Usuario1DTO findByid(int rol_id);

}
