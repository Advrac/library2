/**
 * 
 */
package com.libreria.facade;

import java.util.Collection;

import com.libreria.dao.ClientesDao;
import com.libreria.dto.ClientesDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class ClienteFacade {
	   
	   public ClientesDTO obtenerClienteporRFC(String rfc)
	   {
	      ClientesDao clientesDAO = new ClientesDao();
	      
	      return clientesDAO.buscarClientePorRFC(rfc);
	   }
	   
	   public Collection<ClientesDTO> obtenerClientes()
	   {
	      ClientesDao clientesDAO = new ClientesDao();
	      
	      return clientesDAO.buscarTodosLosClientes();
	   }
	  
	   public boolean grabarCliente(String rfc, String nom)
	   {
	      ClientesDao clienteGrabaDAO = new ClientesDao();
	      
	      return clienteGrabaDAO.guardarCliente(rfc, nom);
	   }

}
