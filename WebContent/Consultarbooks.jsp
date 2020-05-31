<%@page import="com.libreria.dto.LIbroDTO"%>
<%@page import="com.libreria.interfaces.ILibro"%>
<%@page import="com.libreria.dto.UsuarioDTO"%>
<%@page import="java.util.Collection"%>
<%@page import="com.libreria.factory.Fabrica"%>
<%@page import="com.libreria.interfaces.IUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 <%
       		ILibro d=(ILibro) Fabrica.getInstancia("LIBRO");
			Collection<LIbroDTO> resultado= d.getALL();
			
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
		      <th scope="col">ISBN</th>
		      <th scope="col">Titulo</th>
		      <th scope="col">Categoria</th>
		      <th scope="col">Precio</th>
		      <th scope="col">Existencia</th>
		      <th scope="col">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		   <%
		   int i=1;
           if(resultado==null){
				out.println("No hay Registros");
			}else{
            for(LIbroDTO registro:resultado){
          %>
		    <tr>
		      <th scope="row"><%=i%></th>
		      <th ><%=registro.getIsbn()%></th>
		      <td><%=registro.getTitulo() %></td>
		      <td><%=registro.getCategoriaDTO().getTitulo()%></td>
		      <td><%=registro.getPrecio() %></td>
		      <td><%=registro.getExistencia() %></td>
		      <td>
		      	<button class="btn btn-secondary  mr-1" 
		      			type="button" 
		      			data-toggle="modal"
		      			data-target="#exampleModal" 
		      			onclick="openlibro('<%=registro.getIsbn()%>', '<%=registro.getTitulo() %>','<%=registro.getCategoriaDTO().getId() %>', '<%=registro.getPrecio() %>', '<%=registro.getExistencia()%>')">Editar</button>
		      	<button class="btn btn-secondary  mr-1" type="button" onclick="eliminar(<%=registro.getIsbn()%>, 2)">Eliminar</button>
		      </td>
		    </tr>
		    
		    <%
		    i++;
            }
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
			    <label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
			    <div class="col-sm-10">
			      <input type="text" readonly class="form-control-plaintext" id="isbn" value="" disabled>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="titulo" class="col-sm-2 col-form-label">Titulo</label>
			    <div class="col-sm-10">
			      <input type="text"  class="form-control-plaintext" id="titulo" placeholder="titulo">
			    </div>
			  </div>
			  
			  <div class="form-group row">
			    <label for="categoria" class="col-sm-2 col-form-label">Categoria</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="categoria" placeholder="categoria">
			    </div>
			  </div>
			  
			  <div class="form-group row">
			    <label for="precio" class="col-sm-2 col-form-label">Precio</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="precio" placeholder="precio">
			    </div>
			  </div>
			  
			  
			  <div class="form-group row">
			    <label for="existencia" class="col-sm-2 col-form-label">Existencia</label>
			    <div class="col-sm-10">
			      <input type="text"  class="form-control-plaintext" id="existencia" placeholder="existencia">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button"  class="btn btn-primary" onclick="UpdateLibro()"> Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>