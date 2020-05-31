/**
 * 
 */
package com.libreria.factory;

import java.util.ResourceBundle;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class Fabrica {
	public static Object getInstancia(String objName){
	try{
		
		ResourceBundle rb = ResourceBundle.getBundle("com.libreria.factory.factory");
		String nombreClase=rb.getString(objName);
		Object retorna=Class.forName(nombreClase).newInstance();
		//Object retorna=Class.forName(nombreClase).getDeclaredConstructor().newInstance();
		return retorna;
	}catch(Exception ex){
		ex.printStackTrace();
		throw new RuntimeException();
		
	}
	
}

}
