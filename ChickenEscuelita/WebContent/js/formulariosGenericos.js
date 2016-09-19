/**
 * 
 */
function crearMessage(arrayHidden,arrayShown) {
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
	alert(message);
}


function formularioModificar(arrayHidden,arrayShown) {
	message: crearMessage(arrayHidden,arrayShown),
	bootbox.dialog({
		title: "Modificar",
        buttons: {
            success: {
                label: "Save",
                className: "btn-success",
//                callback: function (e) {
//	                var json = { "id" : $('#id').val(), "nombre" :  $('#nombre').val(), "stockHuevos":  $('#stockHuevos').val(),
//        				 	"stockMaximo": $('#stockMaximo').val(), "borrado": $('#borrado').val()};
//    	    		var mensaje = document.getElementById("mensajeModificar").value;
//        		    e.preventDefault();
//        		    bootbox.confirm(mensaje, function (response) {        
//	        	        if(response) {
//	        				table =  $('#tablita').DataTable( {
//	        					ajax: {
//	        						url: "depositosModificarJson",
//	        						type: "POST",
//	        						data: function(){
//	        							return JSON.stringify(json);
//	        						},
//	        						dataType: "json",
//	        						contentType: "application/json",
//	        						processData:false
//	        					},
//	        					bDestroy: true,
//	        					serverside: true,
//	        					columns: [
//	        				              { data: "nombre" },
//	        				              { data: "stockHuevos" },
//	        				              { data: "stockMaximo" },
//	        				              {defaultContent:'<button id="borrar">${borrar}</button>'},
//	        				              {defaultContent:'<button id="modificar">${modificar}</button>'}
//	        				              ]
//				        	});
//				        }
//			        }); 
//		        }
//   	        }
//		}
//	});
});
}