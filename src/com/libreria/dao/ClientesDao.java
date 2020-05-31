package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.libreria.dto.ClientesDTO;
import com.libreria.interfaces.ICliente;
import com.libreria.util.Conexion;




public class ClientesDao implements ICliente{
	Connection con =null;
	PreparedStatement pstm =null;
	ResultSet rs = null;
	
	public boolean guardarCliente(String _rfc, String _nombre) {
		try { 
			con = Conexion.getConnection();
			String sql = "INSERT INTO CLIENTES(rfc,nombre) VALUES(?,?)";
			pstm= con.prepareStatement(sql);
			pstm.setString(1, _rfc);
			pstm.setString(1, _nombre);
			
			if(pstm.executeUpdate() == 1) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			try {
				if(pstm != null) pstm.close();
							
			}catch (Exception e ) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
				{
			}
		}
	}
	
	public Collection<ClientesDTO> buscarTodosLosClientes() {
		try
	      {
	         con = Conexion.getConnection();
	         
	         String sql = "SELECT * FROM CLIENTES";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         rs = pstm.executeQuery();
	         
	         Vector<ClientesDTO> vector = new Vector<ClientesDTO>();
	        		         
	         while(rs.next())
	         {
	        	 ClientesDTO autorEncontrado = new ClientesDTO();
	            
	        	 autorEncontrado.setRfc(rs.getString("rfc"));
	        	 autorEncontrado.setNombre(rs.getString("nombre"));

	            vector.add(autorEncontrado);
	         }
	         
	         return vector;
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
	            if(rs != null) rs.close();
	            if(pstm != null) pstm.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
		
	}
	
	public ClientesDTO buscarClientePorRFC(String _rfc) {
		try
	      {
	         con = Conexion.getConnection();
	         
	         String sql = "SELECT * FROM CLIENTES WHERE rfc = ?";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         pstm.setString(1, _rfc);
	         rs = pstm.executeQuery();
	         
	         ClientesDTO clienteEncontrado = null;
	         
	         if(rs.next()){
	        	 clienteEncontrado=new ClientesDTO();
	        	 clienteEncontrado.setRfc(rs.getString("rfc"));
	        	 clienteEncontrado.setNombre(rs.getString("nombre"));
	        
	         }	         
	         	         
	         return clienteEncontrado;
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
	            if(rs != null) rs.close();
	            if(pstm != null) pstm.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
		
	}
	public boolean actualizarCliente(String _nombre, String _rfc) {
		try
	      {
			con = Conexion.getConnection();
	         
	         String sql = "UPDATE CLIENTES SET nombre = ? WHERE rfc = ?";
	         
	         pstm = (PreparedStatement) con.prepareStatement(sql);
	         
	         pstm.setString(1,_nombre);
	         pstm.setString(2,_rfc);
	         
	         if(pstm.executeUpdate()==1)
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
	            if(rs != null) rs.close();
	            if(pstm != null) pstm.close();
	         }
	         
	         catch(Exception e)
	         {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	         }
	      }
		
	}
	public boolean eliminarCliente (String _rfc) {
		try{
			con = Conexion.getConnection();
            String sql="DELETE FROM CLIENTES where rfc=?";
            pstm=(PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1,_rfc);  
            
            if(pstm.executeUpdate()==1){
            	return true;
            	
            }else{
            	return false;
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
         }
         
         finally
         {
            try
            {
	               if(pstm != null) pstm.close();
            }
            
            catch(Exception e)
            {
               e.printStackTrace();
               throw new RuntimeException(e);
            }
         }
		
	}
}