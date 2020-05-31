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

<title>Insertar usuario</title>
</head>
<body>
	<div class="container">
		<form>
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
		   <button type="button" class="btn btn-primary mb-2" onclick="Agregar(1)">Enviar</button>
		</form>
	</div>
</body>
</html>