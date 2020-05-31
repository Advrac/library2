/**
 * 
 */
package com.libreria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.libreria.dto.AutorDTO;
import com.libreria.dto.CategoriaDTO;
import com.libreria.dto.LIbroDTO;
import com.libreria.factory.Fabrica;
import com.libreria.interfaces.ICategoria;
import com.libreria.interfaces.ILibro;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class LibroDAO implements ILibro{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(String _lib_ISBN, String _lib_titulo, CategoriaDTO categoriaDTO, BigDecimal _lib_precio,
			int _lib_existencia) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO libro(lib_ISBN,lib_titulo, lib_fkcategoria,lib_precio, lib_existencia) VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps. setString(1,_lib_ISBN);
			ps. setString(2,_lib_titulo);
			ps. setInt(3,categoriaDTO.getId());
			ps. setBigDecimal(4,_lib_precio);
			ps. setInt(5,_lib_existencia);
			
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
	public Collection<LIbroDTO> getALL() {
		try {
		con = Conexion .getConnection();
		String sql = "SELECT * FROM libro";
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		Vector<LIbroDTO> vector = new Vector <LIbroDTO>();
		
		while(rs.next()){
			LIbroDTO autorFind= new LIbroDTO();
			ICategoria c = (ICategoria) Fabrica.getInstancia("CATEGORIA");
			
			autorFind.setIsbn(rs.getString("lib_ISBN"));
			autorFind.setTitulo(rs.getString("lib_titulo"));
			autorFind.setCategoriaDTO(c.findByid(rs.getInt("lib_fkcategoria")));
			autorFind.setPrecio(rs.getBigDecimal("lib_precio"));
			autorFind.setExistencia(rs.getInt("lib_existencia"));
			
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
	public boolean update(String _lib_ISBN, String _lib_titulo, CategoriaDTO categoriaDTO, BigDecimal _lib_precio,
			int _lib_existencia) {
		try {
			con =Conexion.getConnection();
			String sql = "UPDATE libro SET lib_titulo= ?, lib_fkcategoria=?,lib_precio=?, lib_existencia=? WHERE lib_ISBN =?";
			
			ps= con.prepareStatement(sql);
			ps.setString(1,_lib_titulo);
			ps.setInt(2, categoriaDTO.getId());
			ps.setBigDecimal(3, _lib_precio);
			ps.setInt(4, _lib_existencia);
			ps.setString(5, _lib_ISBN);
			
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
	public boolean delete(String _lib_ISBN) {
		try {
			con = Conexion.getConnection();
			String sql = "DELETE FROM libro where lib_ISBN=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, _lib_ISBN);
			
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
	public LIbroDTO findByid(String _lib_ISBN) {
		// TODO Auto-generated method stub
		return null;
	}

}
