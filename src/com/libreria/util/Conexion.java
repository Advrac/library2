package com.libreria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion {
	private static Connection con=null;
	
	public static Connection getConnection( ) {

		try {
			if(con==null) {ResourceBundle rb = ResourceBundle.getBundle("com.libreria.util.jdbc");
			
			String driver = rb.getString("driver");
			String url =rb.getString("url");
			String usr =rb.getString("usr");
			String pwd = rb.getString("pwd");
			
			Class.forName(driver);
			
			
			con = DriverManager.getConnection(url,usr,pwd);
				
			}
		} 
		catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return con;


	}
	
	static class MishDwnHook extends Thread {
		//cerrar conexion;
		public void run() {

			try {
				Connection con = Conexion.getConnection();
				con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		
	
	 }
	}
			
}