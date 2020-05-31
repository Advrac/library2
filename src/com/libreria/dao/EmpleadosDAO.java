/**
 * 
 */
package com.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import com.libreria.dto.EmpleadosDTO;
import com.libreria.dto.PuestoDTO;
import com.libreria.interfaces.IEmpleados;
import com.libreria.util.Conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class EmpleadosDAO implements IEmpleados {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean save(String _nombre, PuestoDTO _fkpuesto) {
		try {
			con = Conexion .getConnection();
			String sql = "INSERT INTO empleados(nombre,fk_puesto) VALUES(?,?)";
			ps = con.prepareStatement(sql);
			
			ps. setString(1,_nombre);
			ps. setInt(2,_fkpuesto.getID());
			
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
	public Collection<EmpleadosDTO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String _nombre, PuestoDTO _fkpuesto, int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int _ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmpleadosDTO findByid(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
