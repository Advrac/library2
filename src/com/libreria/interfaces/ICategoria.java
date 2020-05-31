/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;


import com.libreria.dto.CategoriaDTO;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface ICategoria {
	//CREATE 
		public boolean save(String _cat_titulo);
		//READ 
		public Collection<CategoriaDTO> getALL();
		//UDATE
		public boolean update (String _cat_titulo, int _cat_id);
		//DELET
		public boolean delete (int _cat_id);
		//findById
		public CategoriaDTO findByid(int _cat_id);

}
