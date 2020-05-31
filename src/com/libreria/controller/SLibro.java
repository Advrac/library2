package com.libreria.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libreria.dto.UsuarioDTO;
import com.libreria.factory.Fabrica;
import com.libreria.interfaces.ICategoria;
import com.libreria.interfaces.ILibro;
import com.libreria.interfaces.IUsuario;

/**
 * Servlet implementation class SLibro
 */
@WebServlet("/SLibro")
public class SLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLibro() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String operacion=request.getParameter("action");
			   if(operacion.equals("create")){
				   
				   String isbn= request.getParameter("isbn");
				   String titulo= request.getParameter("titulo");
				   int  fkCategoria=Integer.parseInt( request.getParameter("fkcategoria"));
				   BigDecimal precio = new BigDecimal( request.getParameter("precio"));
				   int existencia= Integer.parseInt( request.getParameter("existencia"));
				   
				   ICategoria c = (ICategoria) Fabrica.getInstancia("CATEGORIA");
				   
				   
				   ILibro d=(ILibro) Fabrica.getInstancia("LIBRO");
				   if(d.save(isbn, titulo, c.findByid(fkCategoria), precio, existencia)) {
					  response.setStatus(HttpServletResponse.SC_OK);
				   }else {
					   //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
				   }
					 
			   }else if(operacion.equals("delete")){
				   String isbn=request.getParameter("isbn");
				   ILibro d=(ILibro) Fabrica.getInstancia("LIBRO");
				   if(d.delete(isbn)) {
					  response.setStatus(HttpServletResponse.SC_OK);
				   }else {
					   //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
				   }
				   				   
			   }else if(operacion.equals("update")){
				   String isbn= request.getParameter("isbn");
				   String titulo= request.getParameter("titulo");
				   int  fkCategoria=Integer.parseInt( request.getParameter("fkcategoria"));
				   BigDecimal precio = new BigDecimal( request.getParameter("precio"));
				   int existencia= Integer.parseInt( request.getParameter("existencia"));
				   
				   ICategoria c = (ICategoria) Fabrica.getInstancia("CATEGORIA");
				   
				   
				   ILibro d=(ILibro) Fabrica.getInstancia("LIBRO");
				   if(d.update(isbn, titulo, c.findByid(fkCategoria), precio, existencia)) {
					  response.setStatus(HttpServletResponse.SC_OK);
				   }else {
					   //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
				   }
			   }else if(operacion.equals("search")){
				   
				   
			   }else if(operacion.equals("getAll")){
				  // IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
				   
				   
			   }
			   
    	    } 
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud(request, response);
	}

}
