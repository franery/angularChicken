<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="gallineros" /></title>

</head>
<body>
	<h1 class="page-header">
		<spring:message code="gallineros" />
	</h1>
	<table id="tablita" class="display order-column" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th><spring:message code="nombre" /></th>
				<th><spring:message code="usuario" /></th>
				<th><spring:message code="stockGallinas" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody class="bod">
		</tbody>
	</table>
	
	<form:form id="formModificar" action="gallinerosModificar" method="post" commandName="gallinero">
		<form:input id="id" path="id" type="hidden"/>
		<form:input id="nombre" path="nombre" type="hidden"/>
		<form:input id="usuarioId" path="usuarioId" type="hidden"/>
		<form:input id="usuarioNombre" path="usuarioNombre" type="hidden"/>
		<form:input id="stockGallinas" path="stockGallinas" type="hidden"/>
		<form:input id="borrado" path="borrado" type="hidden"/>
	</form:form>

	<c:set var="value">
		<spring:message code="mensajeBorrar" />
	</c:set>
	
	<c:set var="borrar">
		<spring:message code="borrar" />
	</c:set>

	<c:set var="modificar">
		<spring:message code="modificar" />
	</c:set>
	
	<input id="mensajeBorrar" type="hidden" value="${value}" />

<div class="wait"></div>
	
<script>

$(document).ready(function(){

	var table = $('#tablita').DataTable( {
		language: i18n(),
		ajax: "gallinerosJson",
		dom: 'Bfrtip',
	    columns: [
	        {data: "nombre" },
	        {data: "usuarioNombre" },
	        {data: "stockGallinas" },
	        {defaultContent:'<button class="btn btn-danger" id="borrar">${borrar}</button>'},
	        {defaultContent:'<button class="btn btn-warning" id="modificar">${modificar}</button>'}
	        ],
	    select:true,
	    paging:true,
	    pageLength:50,
	    ordering:true,
	    buttons: [
	              {
	                  text: '<button class="btn btn-success pull-left"><spring:message code="nuevo"/></button>',
	                  action: function ( e, dt, node, config ) {
	                      window.location = "gallinerosNuevo";
	                  }
	              }
	          ]
	});
	
	$('#tablita tbody').on('click', '#borrar', function (e) {
		var data = table.row(this.closest("tr")).data();
		var json = {
			"id" : data["id"],
			"nombre" : data["nombre"],
			"usuarioId" : data["usuarioId"],
			"usuarioNombre" : data["usuarioNombre"],
			"stockGallinas" : data["stockGallinas"],
			"borrado" : data["borrado"]
		};
		var mensaje = document.getElementById("mensajeBorrar").value;
		e.preventDefault();
		bootbox.confirm(mensaje, function (response) {
			if (response) {
				$.ajax({
					url : "gallinerosBorrarJson",
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
		document.getElementById("usuarioNombre").value = data["usuarioNombre"];
		document.getElementById("usuarioId").value = data["usuarioId"];
		document.getElementById("stockGallinas").value = data["stockGallinas"];
		document.getElementById("borrado").value = data["borrado"];
		document.getElementById("formModificar").submit();
	});
});

</script>

</body>
</html>