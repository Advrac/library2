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
import com.libreria.dto.CategoriaDTO;
import com.libreria.interfaces.ICategoria;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class CategoriaDAO implements ICategoria {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
		@Override
		public boolean save(String _cat_titulo) {
			try {
				con = Conexion .getConnection();
				String sql = "INSERT INTO categoria(cat_titulo) VALUES(?)";
				ps = con.prepareStatement(sql);
				
				ps. setString(1,_cat_titulo);
				
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
	}

	@Override
	public Collection<CategoriaDTO> getALL() {
		try {
			con = Conexion .getConnection();
			String sql = "SELECT * FROM categoria";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			Vector<CategoriaDTO> vector = new Vector <CategoriaDTO>();
			
			while(rs.next()){
				CategoriaDTO autorFind= new CategoriaDTO();
				
				autorFind.setId(rs.getInt("cat_id"));
				autorFind.setTitulo(rs.getString("cat_titulo"));
				
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
	public boolean update(String _cat_titulo, int _cat_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int _cat_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CategoriaDTO findByid(int _cat_id) {
		try{
			con = Conexion.getConnection();
		
		String sql = "SELECT * FROM categoria WHERE cat_id=?";
		ps= con.prepareStatement(sql);
		ps.setInt(1, _cat_id);
		rs = ps.executeQuery();
		
		CategoriaDTO autorFind = null;
		if(rs.next()) {
			autorFind= new CategoriaDTO();
			//Se pone el mismo nombre de la tabla en la BD
			autorFind.setId(rs.getInt("cat_id"));
			autorFind.setTitulo(rs.getString("cat_titulo"));
			
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
