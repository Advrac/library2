<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="js/main.js" > </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>Insertar Libro</title>
</head>
<body>
	<div class="container">
		<form>
		  <div class="form-group row">
		    <label for="username" class="col-sm-2 col-form-label">ISBN</label>
		    <div class="col-sm-10">
		      <input type="text"  class="form-control-plaintext" id="isbn" placeholder="isbn">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="clave" class="col-sm-2 col-form-label">Titulo</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="titulo" placeholder="titulo">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="clave" class="col-sm-2 col-form-label">Categoria</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="categoria" placeholder="categoria">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="clave" class="col-sm-2 col-form-label">Precio</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="precio" placeholder="precio">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="privilegio" class="col-sm-2 col-form-label">Existencia</label>
		    <div class="col-sm-10">
		      <input type="text"  class="form-control-plaintext" id="existencia" placeholder="existencia">
		    </div>
		  </div>
		   <button type="button" class="btn btn-primary mb-2" onclick="Agregar(2)">Enviar</button>
		</form>
	</div>
</body>
</html>