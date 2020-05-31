/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import com.libreria.dto.RolDTO;
import com.libreria.interfaces.IRol;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class RolDAO implements IRol{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(String _rol_name) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO rol(rol_name) VALUES(?)";
			ps = con.prepareStatement(sql);
			
			ps. setString(1,_rol_name);
			
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
		// TODO Auto-generated method stub
	
	

	@Override
	public Collection<RolDTO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String _nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int _ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RolDTO findByid(int _ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
