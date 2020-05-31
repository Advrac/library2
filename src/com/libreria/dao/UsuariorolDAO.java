/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import com.libreria.dto.RolDTO;
import com.libreria.dto.UsuarioRolDTO;
import com.libreria.interfaces.IUsuarioRol;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class UsuariorolDAO implements IUsuarioRol  {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(UsuarioRolDTO _usuarioRolDTO, RolDTO _rolDTO) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO usuario1(usr_fkusuario,usr_fkrol) VALUES(?,?)";
			ps = con.prepareStatement(sql);
			
			ps. setInt(1,_usuarioRolDTO.getId());
			ps. setInt(2,_rolDTO.getRol_id());
			
			
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
	public Collection<UsuarioRolDTO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UsuarioRolDTO usuarioRolDTO, RolDTO rolDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UsuarioRolDTO usuarioRolDTO, RolDTO rolDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioRolDTO findByid(int rol_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
