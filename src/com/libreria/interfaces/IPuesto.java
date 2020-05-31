/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;


import com.libreria.dto.PuestoDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IPuesto {
	//CREATE 
		public boolean save(String _nombre);
		//READ 
		public Collection<PuestoDTO> getALL();
		//UDATE
		public boolean update (String _nombre, int _ID);
		//DELET
		public boolean delete (int _ID);
		//findById
		public PuestoDTO findByid(int _ID);
}
