/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;


import com.libreria.dto.RolDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IRol {
	//CREATE 
			public boolean save(String _rol_name);
			//READ 
			public Collection<RolDTO> getALL();
			//UDATE
			public boolean update (String rol_name) ;
			//DELET
			public boolean delete (int rol_id);
			//findById
			public RolDTO findByid(int rol_id);

}
