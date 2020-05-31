/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import com.libreria.dto.AutorDTO;
import com.libreria.dto.AutorlibroDTO;
import com.libreria.dto.LIbroDTO;
import com.libreria.interfaces.IAutorlibro;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class AutorlibroDAO implements IAutorlibro  {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;


	@Override
	public boolean save(AutorDTO aut_id, LIbroDTO lib_isbn) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO autorlibro(lib_ISBN,aut_id) VALUES(?,?)";
			ps = con.prepareStatement(sql);
			
			ps. setString(1, lib_isbn.getIsbn());
			ps. setInt(2,aut_id.getId());
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
	public Collection<AutorlibroDTO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(AutorDTO aut_id, LIbroDTO lib_isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(AutorDTO aut_id, LIbroDTO lib_isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AutorlibroDTO findByid(AutorDTO aut_id, LIbroDTO lib_isbn) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
