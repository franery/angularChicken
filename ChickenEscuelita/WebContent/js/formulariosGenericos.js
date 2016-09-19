/**
 * 
 */
function crearMensajeModificar(arrayHidden,arrayShown) {
	var message = '<div class="row">  ' +
    		'<div class="col-md-12"> ' +
    		'<form class="form-horizontal"> ';
	for (var i = 0; i < arrayHidden.length; i++) {
		message += '<input id="' + arrayHidden[i].nombre + '" type="hidden" value="' + arrayHidden[i].valor + '" class="form-control input-md"> ';
	}
	for (var i = 0; i < arrayShown.length; i++) {
		message += '<div class="form-group"> ' +
        	'<label class="col-md-5 control-label" for="' + arrayShown[i].nombre + '">' +arrayShown[i].mensaje + '</label> ' +
        	'<div class="col-md-5"> ' +
        	'<input id="'+arrayShown[i].nombre+'" name="'+arrayShown[i].nombre+'" type="text" value="'+arrayShown[i].valor+'" class="form-control input-md"> ' +
        	'</div> ';
	}
	message += '</form> </div>  </div>';
	return message;
}


function formularioModificar(arrayHidden,arrayShown) {
	return crearMensajeModificar(arrayHidden,arrayShown);
}