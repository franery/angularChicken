<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="perfiles"/></title>

</head>
<body>

<h1 class="page-header"><spring:message code="perfiles"/></h1>

	<!-- Tabla Perfiles -->
	<table id="tablita" class="display order-column" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th><spring:message code="nombre"/></th>
				<th><spring:message code="permisos"/></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
	</table>
			

	<form:form id="formModificar" action="perfilesModificar" method="post" commandName="perfil">
		<form:input id="id" path="id" type="hidden"/>
		<form:input id="nombre" path="nombre" type="hidden"/>
	</form:form>
	
	<c:set var="value">
		<spring:message code="mensajeBorrar" />
	</c:set>
	<input id="mensajeBorrar" type="hidden" value="${value}" />
	
	<c:set var="borrar">
		<spring:message code="borrar" />
	</c:set>

	<c:set var="modificar">
		<spring:message code="modificar" />
	</c:set>

<div class="wait"></div>

<script>
$.fn.dataTable.render.asd = function ( ) {
    return function (data, type, row) {
	   	var modulo;
	    var mensaje = "";
	    var listaPermisos = row.listaPermisos;
	    for (var i = 0; i < listaPermisos.length; i++) {
	    	if(modulo != listaPermisos[i].nombreModulo){
	    		mensaje = mensaje.substring(0,mensaje.length-2);
	    		mensaje += "<br>" + listaPermisos[i].nombreModulo + ": ";
	    		modulo = listaPermisos[i].nombreModulo;
	    	}
	    	mensaje += listaPermisos[i].nombreOperacion + " | ";               	
	    }
		mensaje = mensaje.substring(0,mensaje.length-2);
		return mensaje;
    };
};

$(document).ready(function() {
	var table = $('#tablita').DataTable({
		language: i18n(),
		ajax: "perfilesJson",
	    columns: [
	        {data: "nombre" },
	        {
	            data: null,
	            render: $.fn.dataTable.render.asd()
	        },
	        {defaultContent:'<button class="btn btn-danger" id="borrar">${borrar}</button>'},
	        {defaultContent:'<button class="btn btn-warning" id="modificar">${modificar}</button>'}
	        ],
	    select:true,
	    paging:true,
	    pageLength:50,
	    ordering:true,
	    dom: 'Bfrtip',
	    buttons: [
	              {
	                  text: '<button class="btn btn-success pull-left" id="nuevo"><spring:message code="nuevo"/></button>',
	                  action: function ( e, dt, node, config ) {
	                      window.location = "perfilesNuevo";
	                  }
	              }
	          ]
	});
	
	$(document).on({
	    ajaxStart: function() {$("body").addClass("loading");},
	    ajaxStop: function() {$("body").removeClass("loading");}
	});

	$('#tablita tbody').on('click', '#borrar', function (e) {
		var data = table.row(this.closest("tr")).data();
		var json = {
			"id" : data["id"],
			"nombre" : data["nombre"]
		};
		var mensaje = document.getElementById("mensajeBorrar").value;
		e.preventDefault();
		bootbox.confirm(mensaje, function (response) {
			if (response) {
				$.ajax({
					url : "perfilesBorrarJson",
					type : "DELETE",
					data : JSON.stringify(json),
					dataType : "json",
					contentType : "application/json",
					processData : false,
					complete : function () {
						table.ajax.reload();
					}
				});
			}
		});
	});

	$('#tablita tbody').on('click', '#modificar', function (e) {
		var data = table.row(this.closest("tr")).data();
		e.preventDefault();
		document.getElementById("id").value = data["id"];
		document.getElementById("nombre").value = data["nombre"];
		document.getElementById("formModificar").submit();
	});
});
</script>

</body>
</html>