/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;


import com.libreria.dto.EmpleadosDTO;
import com.libreria.dto.PuestoDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface IEmpleados {
	public boolean save(String _nombre, PuestoDTO _fkpuesto);
	//READ 
	public Collection<EmpleadosDTO> getALL();
	//UDATE
	public boolean update (String _nombre, PuestoDTO _fkpuesto, int ID );
	//DELET
	public boolean delete (int _ID);
	//findById
	public EmpleadosDTO findByid(int ID);

}
