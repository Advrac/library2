package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import com.libreria.dto.AutorDTO;
import com.libreria.dto.UsuarioDTO;
import com.libreria.interfaces.IUsuario;
import com.libreria.util.Conexion;

public class UsuarioDAO implements IUsuario{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public UsuarioDTO verificarUsuario(String _user, String _clave){
		UsuarioDTO usuarioEncontrado = null;
        try{
        	con = (Connection) Conexion.getConnection();
            String sql="SELECT * FROM usuario WHERE username=? AND clave=?";
             ps = (PreparedStatement) con.prepareStatement(sql);
	         ps.setString(1,_user);
	         ps.setString(2,_clave);
	         rs = ps.executeQuery();
	         
	         if(rs.next()){
	        	 usuarioEncontrado=new UsuarioDTO();
	        	 usuarioEncontrado.setID(rs.getInt("ID"));
	        	 usuarioEncontrado.setUsername(rs.getString("username"));
	        	 usuarioEncontrado.setClave(rs.getString("clave"));
	        	 usuarioEncontrado.setPrivilegio(rs.getInt("privilegio"));

	         }	         
        }catch(SQLException ex){
            ex.printStackTrace();
           
        }finally{
            try{
                rs.close();
                ps.close();
             }catch(SQLException ex){

            }
        }
        return usuarioEncontrado;
    }
	public boolean guardarUsuario(String _username, String _clave, int _privilegio)
	   {
	      try
	      {
	         con = (Connection) Conexion.getConnection();
	         
	         String sql = "INSERT INTO usuario(username, clave, privilegio) VALUES(?,?,?)";
	         
	         ps = (PreparedStatement) con.prepareStatement(sql);
	         
	         ps.setString(1,_username);
	         ps.setString(2,_clave);
	         ps.setInt(3,_privilegio);
	         	         
	         if(ps.executeUpdate()==1)
	         {
	              return true;
	         }else{
	            return false;
	         }
	      }
	      
	      catch(Exception e)
	      {
	         e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	      
	      finally
	      {
	         try
	         {
	            if(ps != null) ps.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
	   }
	
	@Override
	public boolean update(String _username, String _clave, int _privilegio, int _id) {
		try {
			con =Conexion.getConnection();
			String sql = "UPDATE usuario SET username =?, clave= ?, privilegio=?  WHERE id = ?";
			
			ps= con.prepareStatement(sql);
			ps.setString(1,_username);
			ps.setString(2,_clave);
			ps.setInt(3,_privilegio);
			ps.setInt(4,_id);
			
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
			String sql = "DELETE FROM usuario where id=?";
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
	public Collection<UsuarioDTO> getAll() {
		try {
			con = Conexion .getConnection();
			String sql = "SELECT * FROM usuario";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			Vector<UsuarioDTO> vector = new Vector <UsuarioDTO>();
			
			while(rs.next()){
				UsuarioDTO autorFind= new UsuarioDTO();
				
				autorFind.setID(rs.getInt("ID"));
				autorFind.setUsername(rs.getString("username"));
				autorFind.setClave(rs.getString("clave"));
				autorFind.setPrivilegio(rs.getInt("privilegio"));
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

	
	
		
}
