package com.libreria.interfaces;

import java.util.Collection;

import com.libreria.dto.UsuarioDTO;

public interface IUsuario{
	public UsuarioDTO verificarUsuario(String _user, String _clave);
	public boolean guardarUsuario(String _username, String _clave, int _privilegio);
	public Collection<UsuarioDTO> getAll();
	public boolean update(String _username, String _clave, int _privilegio, int _id);
	public boolean delete(int _id);
	
	
	
	 

}


