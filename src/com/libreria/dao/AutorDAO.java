/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.libreria.dto.AutorDTO;
import com.libreria.interfaces.IAutor;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class AutorDAO implements IAutor{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(String _nombre) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO autor(nombre) VALUES(?)";
			ps = con.prepareStatement(sql);
			
			ps. setString(1,_nombre);
			
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
	public Collection<AutorDTO> getALL() {		try {
		con = Conexion .getConnection();
		String sql = "SELECT * FROM autor";
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		Vector<AutorDTO> vector = new Vector <AutorDTO>();
		
		while(rs.next()){
			AutorDTO autorFind= new AutorDTO();
			
			autorFind.setId(rs.getInt("id"));
			autorFind.setNombre(rs.getString("nombre"));
			
			vector.add(autorFind);
			
		}
			return vector;	
		} catch (Exception e) { 
		e.printStackTrace();
		throw new RuntimeException (e);
		}
		finally
		{
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			
		}catch (Exception e2) {
			e2.printStackTrace();
			throw new RuntimeException (e2);
			}
		}
}

	
	
		
	@Override
	public boolean update(String _nombre, int _id) {
		try {
			con =Conexion.getConnection();
			String sql = "UPDATE autor SET nombre =? WHERE id = ?";
			
			ps= con.prepareStatement(sql);
			ps.setString(1,_nombre);
			ps.setInt(2,_id);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}else {
				return false;
				
			}
		}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			
			}
		
			
			finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
				}catch (Exception e2) {
					e2.printStackTrace();
					throw  new RuntimeException(e2);
					
				}
				
			}
		
	}

	@Override
	public boolean delete(int _id) {
		try {
			con = Conexion.getConnection();
			String sql = "DELETE FROM autor where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}

		finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch (Exception e2) {
				e2.printStackTrace();
				throw  new RuntimeException(e2);
				
			}
			
		}
		
	}

	@Override
	public AutorDTO findByid(int _id) {
		try{
			con = Conexion.getConnection();
		
		String sql = "SELECT * FROM autor WHERE id=?";
		ps= con.prepareStatement(sql);
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		
		AutorDTO autorFind = null;
		if(rs.next()) {
			autorFind= new AutorDTO();
			//Se pone el mismo nombre de la tabla en la BD
			autorFind.setId(rs.getInt("id"));
			autorFind.setNombre(rs.getString("nombre"));
			
		}
		return autorFind;
		
	} catch(Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
		finally {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
		}catch (Exception e2) {
			e2.printStackTrace();
			throw  new RuntimeException(e2);
			
		}
		
	}
		
	
	
	}

}
