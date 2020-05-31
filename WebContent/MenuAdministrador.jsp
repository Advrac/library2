<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.libreria.dao.*" %>
<%@page import="com.libreria.dto.*" %>
<%@page import="com.libreria.factory.*" %>
<%@page import="com.libreria.interfaces.*" %>
<%@page session="true" %>

<%-- Validar inicio de sesion --%>
<%
HttpSession sesion = request.getSession();
if (sesion.getAttribute("usuario") == null) {
    response.sendRedirect("login.html");
} 
%>

<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
       		ICliente d=(ICliente) Fabrica.getInstancia("CLIENTES");
			Collection<ClientesDTO> resultado= d.buscarTodosLosClientes();
			
    %>

<%-- Finalizar --%>
<html>
<head>
<title>.:PAW-Consultar Clientes</title>
<style type="text/css">

<!--
body {
	background-color: #FFFF99;
}
body,td,th {
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="84" bgcolor="#FF0000"><img src="includes/img/porrin.png" alt="libro" width="140" height="65"></td>
    <td width="716" bgcolor="#993300"><h1 style="color:#FFFFFF">Carrito de Compras con JSP y Sesiones</h1></td>
  </tr>
  <tr align="center">
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr align="center">
  	<td colspan="2">
  		<div class="d-flex" style="flex-direction: row-reverse">
  			<div >
         	<a type="button" class="btn btn-secondary" href="SCerrarSesion">Cerrar Sesion</a>
        </div>
  			<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle mr-1" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Usuarios
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
		  	<a class="dropdown-item" type="button" href="AgregarUsers.jsp">Agregar</a>
		    <a class="dropdown-item" type="button" href="ConsultarUsers.jsp">Consultar</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle mr-1" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Libros
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
		   <a class="dropdown-item" type="button" href="Agregarbooks.jsp">Agregar</a>
		    <a class="dropdown-item" type="button" href="Consultarbooks.jsp">Consultar</a>
		  </div>
		</div>

  		</div>
  	</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">

      <table width="100%" border="0">
  <tr bgcolor="#FF6600" style="color: #FFFFFF">
            <td width="68%" bgcolor="#993300"><h4>RFC</h4></td>
            <td width="16%" align="right" valign="top" bgcolor="#993300"><h4><span class="Estilo3">Nombre</span></h4></td>
            
        </tr>

          <%
           if(resultado==null){
				out.println("No hay Registros");
			}else{
            for(ClientesDTO registro:resultado){
          %>
          <tr>
            <td align="right" valign="top"><%=registro.getRfc() %></td>
            <td align="right" valign="top"><%=registro.getNombre() %></td>
          </tr>
          <%}
             } %>

        </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
</body>
</html>
