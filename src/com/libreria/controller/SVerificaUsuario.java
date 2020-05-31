package com.libreria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.libreria.dto.UsuarioDTO;
import com.libreria.factory.Fabrica;

import com.libreria.interfaces.IUsuario;


/**
 * Servlet implementation class SVerificaUsuario
 */
@WebServlet("/SVerificaUsuario")
public class SVerificaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVerificaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String operacion=request.getParameter("action");
			   if(operacion.equals("create")){
				   
				   String name= request.getParameter("username");
				   String clave= request.getParameter("clave");
				   int privilegio =Integer.parseInt( request.getParameter("privilegio"));
				   
				   IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
				   if(d.guardarUsuario(name, clave, privilegio)) {
					  response.setStatus(HttpServletResponse.SC_OK);
				   }else {
					   //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
				   }
					 
			   }else if(operacion.equals("delete")){
				   int id=Integer.parseInt(request.getParameter("id"));
				   IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
				   if(d.delete(id)) {
					  response.setStatus(HttpServletResponse.SC_OK);
				   }else {
					   //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
				   }
				   				   
			   }else if(operacion.equals("update")){
				   int id=Integer.parseInt(request.getParameter("id"));
				   String name= request.getParameter("name");
				   String clave= request.getParameter("clave");
				   int privilegio =Integer.parseInt( request.getParameter("privilegio"));
				   
				   IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
				   if(d.update(name, clave, privilegio, id)) {
					  response.setStatus(HttpServletResponse.SC_OK);
				   }else {
					   //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
				   }
				   
			   }else if(operacion.equals("search")){
				   
				   
			   }else if(operacion.equals("getAll")){
				  // IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
				   
				   
			   }else if(operacion.equals("login")) {
				    String user=request.getParameter("txtUsuario");
	    	        String clave=request.getParameter("txtClave");
	    	        UsuarioDTO u=new UsuarioDTO();
	    	        
	    	        IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
	    	        	u= d.verificarUsuario(user, clave);
	    	        if(u!=null){
	    	            //El usuario existe en la base de datos y clave correcta
	    	            //Creamos la sesion
	    	            HttpSession sesion=request.getSession(true);
	    	            sesion.setAttribute("usuario", u);
	    	            //El usuario tiene el privilegio de administrador de la empresa
	    	            response.sendRedirect("MenuAdministrador.jsp");
	    	            
	    	        }else{
	    	            //El usuario no existe o clave incorrecta
	    	            response.sendRedirect("error.html");
	    	        } 
			   }
			     
    	    } 

    	    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    	  
    	    @Override
    	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    	procesaSolicitud(request, response);
    	    } 

    	    
    	    @Override
    	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    	procesaSolicitud(request, response);
    	    }

}
