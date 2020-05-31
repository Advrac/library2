/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import com.libreria.dto.PermisoDTO;
import com.libreria.dto.RolDTO;
import com.libreria.interfaces.IPermiso;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class PermisoDAO implements IPermiso {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(RolDTO fk_Rol, String per_nombre, String per_permiso) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO permiso(per_fkrol,per_nombre, per_permiso,) VALUES(?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps. setInt(1,fk_Rol.getRol_id());
			ps. setString(2,per_nombre);
			ps. setString(3,per_permiso);
			
			
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
			}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PermisoDTO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(RolDTO fk_Rol, String per_nombre, String per_permiso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int per_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PermisoDTO findByid(int per_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
