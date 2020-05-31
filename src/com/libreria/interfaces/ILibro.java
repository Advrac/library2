/**
 * 
 */
package com.libreria.interfaces;

import java.math.BigDecimal;
import java.util.Collection;

import com.libreria.dto.CategoriaDTO;
import com.libreria.dto.LIbroDTO;
;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface ILibro {
	public boolean save(String _lib_ISBN, String _lib_titulo, CategoriaDTO categoriaDTO, BigDecimal _lib_precio, int _lib_existencia);
	//READ 
	public Collection<LIbroDTO> getALL();
	//UDATE
	public boolean update (String _lib_ISBN, String _lib_titulo, CategoriaDTO categoriaDTO, BigDecimal _lib_precio, int _lib_existencia );
	//DELET
	public boolean delete (String _lib_ISBN);
	//findById
	public LIbroDTO findByid(String _lib_ISBN);

}
