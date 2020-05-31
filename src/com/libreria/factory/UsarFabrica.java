/**
 * 
 */
package com.libreria.factory;

import com.libreria.interfaces.ICliente;

/**
 * @author Aldo Adrian Vargas Acu�a
 *
 */
public class UsarFabrica {
	public static void main(String[] args) {
		ICliente d=(ICliente) Fabrica.getInstancia("CLIENTES");
		Boolean resultado= d.guardarCliente("GOZM768594","Silvia Elena");
		if(resultado==true){
			System.out.println("Datos grabados");
			
		}else{
			System.out.println("Datos no grabados");
		}

	}
}
