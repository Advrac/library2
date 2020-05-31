/**
 * 
 */
package com.libreria.interfaces;

import java.util.Collection;

import com.libreria.dto.ClientesDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface ICliente {
	public ClientesDTO buscarClientePorRFC(String _rfc);
	public boolean guardarCliente(String _rfc,String _nom);
	public boolean actualizarCliente(String _nombre, String _rfc);
	public boolean eliminarCliente(String _rfc);
	public Collection<ClientesDTO> buscarTodosLosClientes();

}
