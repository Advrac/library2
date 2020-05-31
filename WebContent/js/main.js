function eliminar(ID,elimina){

	console.log(ID);
console.log(elimina);
	switch (elimina){
		case 1:
			$.post( 'SVerificaUsuario', {id: ID, action:"delete"}, 
					
					function (res,status) {
						
						
						console.log(status);
						
						if (status == "success" ){
						
							alert("Se Elimino el usuario ");
							
					location.reload();
							
							
						} else {
							
							alert("no se elimino");
						}
						});
		break;
			
			
		case 2:
			$.post('SLibro',{isbn:ID, action :"delete"},
					function (res,status) {
				
				
				console.log(status);
				
				if (status == "success" ){
				
					alert("Se Elimino el Libro ");
					
			location.reload();
					
					
				} else {
					
					alert("no se elimino");
				}
				});
			
			break;
	}}
	


function Agregar(agrega){
	 console.log(agrega);
	
	switch(agrega){
	
	case 1:
		var username= $('#username').val();
		var clave= $('#clave').val();
		var prioridad= $('#prioridad').val();
		console.log(username);
		
		$.post('SVerificaUsuario', 
				{
					username:username,
					clave:clave,
					privilegio:prioridad,
					action: "create"
				}, 
				function (res,status) {
					
					if (status == "success" ){
					
						alert("Se Agrego el usuario ");
						
						location.reload();
							
					} else {
						
						alert("no se Agrego");
					}
					});
		break;
	case 2:
		
		var isbn= $('#isbn').val();
		var tit= $('#titulo').val();
		var exist= $('#existencia').val();
		var cat= $('#categoria').val();
		var preci= $('#precio').val();
		console.log(isbn);
		
		$.post('SLibro', 
				{
				
					isbn: isbn,
					titulo:tit,
					existencia:exist,
					fkcategoria:cat,
					precio: preci,
					action:"create"
				}, 
				
					

				function (res,status) {
					
					if (status == "success" ){
					
						alert("Se Agrego el libro ");
						
				location.reload();
							
					} else {
						
						alert("no se Agrego");
					}
					});
	}


	
}




function openlibro(isbn,titulo,categoria,precio,exitencia){
	
	$('#isbn').val(isbn);
	$('#titulo').val(titulo);
	$('#categoria').val(categoria);
	$('#precio').val(precio);
	$('#existencia').val(exitencia);

}


function UpdateLibro() {
	
	var isbn= $('#isbn').val();
	var titulo = $('#titulo').val();
	var categoria= $('#categoria').val();
	var precio = $('#precio').val();
	var exist = $('#existencia').val();
	
	$.post('SLibro', 
			{
		isbn: isbn,
		titulo:titulo,
		existencia:exist,
		fkcategoria:categoria,
		precio: precio,
		action:"update"
			}, 
						
			function (res,status) {
				
				if (status == "success" ){
				
					alert("Se actualizo el libro ");
					
			location.reload();
						
				} else {
					
					alert("no se actualizo");
				}
				});

	
}


function openuser(id,username,clave,privilegio){
    
	var id= $('#id').val(id);
	var usernae= $('#username').val(username);
	var clave= $('#clave').val(clave);
	var prioridad= $('#prioridad').val(privilegio);
	//console.log(username);
	
}

function Update() {
	var id= $('#id').val();
	var username= $('#username').val();
	var clave= $('#clave').val();
	var prioridad= $('#prioridad').val();
	
	console.log(clave);
	
	$.post('SVerificaUsuario', 
			{
				id: id,
				name:username,
				clave:clave,
				privilegio:prioridad,
				action: "update"
			}, 
			function (res,status) {
				if (status == "success" ){				
					alert("Se actualizo el usuario ");	
			location.reload();
				}else{
					alert("no se actualizo");
				}
				});

}