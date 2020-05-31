<%@page import="com.libreria.dto.UsuarioDTO"%>
<%@page import="java.util.Collection"%>
<%@page import="com.libreria.factory.Fabrica"%>
<%@page import="com.libreria.interfaces.IUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 <%
       		IUsuario d=(IUsuario) Fabrica.getInstancia("USUARIO");
			Collection<UsuarioDTO> resultado= d.getAll();
			
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="js/main.js" > </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">username</th>
		      <th scope="col">clave</th>
		      <th scope="col">privilegio</th>
		      <th scope="col">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		   <%
           if(resultado==null){
				out.println("No hay Registros");
			}else{
            for(UsuarioDTO registro:resultado){
          %>
		    <tr>
		      <th scope="row"><%=registro.getID() %></th>
		      <td><%=registro.getUsername() %></td>
		      <td><%=registro.getClave() %></td>
		      <td><%=registro.getPrivilegio() %></td>
		      <td>
		      	<button class="btn btn-secondary  mr-1" 
		      			type="button" 
		      			data-toggle="modal"
		      			data-target="#exampleModal" 
		      			onclick="openuser('<%=registro.getID() %>', '<%=registro.getUsername() %>', '<%=registro.getClave() %>', '<%=registro.getPrivilegio() %>'  )">Editar</button>
		      	<button class="btn btn-secondary  mr-1" type="button" onclick="eliminar(<%=registro.getID() %>, 1)">Eliminar</button>
		      </td>
		    </tr>
		    
		    <%}
             } %>
		  </tbody>
		</table>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       <form>
	       	<div class="form-group row">
			    <label for="id" class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" readonly class="form-control-plaintext" id="id" value="" disabled>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="username" class="col-sm-2 col-form-label">Username</label>
			    <div class="col-sm-10">
			      <input type="text"  class="form-control-plaintext" id="username" placeholder="Username">
			    </div>
			  </div>
			  
			  <div class="form-group row">
			    <label for="clave" class="col-sm-2 col-form-label">Clave</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="clave" placeholder="Password">
			    </div>
			  </div>
			  
			  <div class="form-group row">
			    <label for="privilegio" class="col-sm-2 col-form-label">Privilegio</label>
			    <div class="col-sm-10">
			      <input type="text"  class="form-control-plaintext" id="prioridad" placeholder="Privilegio">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button"  class="btn btn-primary" onclick="Update()"> Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>