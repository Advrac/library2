/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;

import com.libreria.dto.AutorDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IAutor {
	//CREATE 
	public boolean save(String _nombre);
	//READ 
	public Collection<AutorDTO> getALL();
	//UDATE
	public boolean update (String _nombre, int _id);
	//DELET
	public boolean delete (int _id);
	//findById
	public AutorDTO findByid(int _id);
	

}
