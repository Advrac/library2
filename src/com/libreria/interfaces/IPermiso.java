/**
 * 
 */
package com.libreria.interfaces;


import java.util.Collection;

import com.libreria.dto.PermisoDTO;
import com.libreria.dto.RolDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IPermiso {
	public boolean save( RolDTO fk_Rol, String per_nombre, String per_permiso);
	//READ 
	public Collection<PermisoDTO> getALL();
	//UDATE
	public boolean update (RolDTO fk_Rol, String per_nombre, String per_permiso);
	//DELET
	public boolean delete (int per_id);
	//findById
	public PermisoDTO findByid(int per_id);

}
