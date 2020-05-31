/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import com.libreria.dto.Usuario1DTO;
import com.libreria.interfaces.IUsuario1;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class Usuario1DAO implements IUsuario1{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(String _Username, String _clave, String _privilegio) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO usuario1(usuUSERNAME,usuCLAVE,usuPRIVILEGIO) VALUES(?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps. setString(1,_Username);
			ps. setString(2,_clave);
			ps. setString(3,_privilegio);
			
			if(ps.executeUpdate() ==1) {
				return true;
			}else {
				return false;
			
			
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException (e);
			} finally {
				try {
				if(ps != null) ps.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
			throw new RuntimeException(e2);
			}
		// TODO Auto-generated method stub
		
	}
		
	
		
	}

	@Override
	public Collection<Usuario1DTO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String _Username, String _clave, String _privilegio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String _Username, String _clave, String _privilegio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario1DTO findByid(int rol_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
