/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;

import com.libreria.dto.AutorDTO;
import com.libreria.dto.AutorlibroDTO;
import com.libreria.dto.LIbroDTO;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IAutorlibro {
		//CREATE 
		public boolean save(AutorDTO aut_id, LIbroDTO  lib_isbn);
		//READ 
		public Collection<AutorlibroDTO> getALL();
		//UDATE
		public boolean update (AutorDTO aut_id, LIbroDTO  lib_isbn);
		//DELET
		public boolean delete (AutorDTO aut_id, LIbroDTO  lib_isbn);
		//findById
		public AutorlibroDTO findByid(AutorDTO aut_id, LIbroDTO  lib_isbn);

}
