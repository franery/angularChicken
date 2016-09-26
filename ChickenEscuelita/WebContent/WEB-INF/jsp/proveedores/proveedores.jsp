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

<title><spring:message code="proveedor" /></title>

</head>
<body>

<h1 class="page-header"><spring:message code="proveedores"/></h1>

	<table id="tablita" class="display order-column" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th><spring:message code="nombre" /></th>
				<th><spring:message code="direccion" /></th>
				<th><spring:message code="mail" /></th>
				<th><spring:message code="telefono" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<form:form id="formModificar" action="proveedoresModificar" method="post" commandName="proveedor">
		<form:input id="id" path="id" type="hidden"/>
		<form:input id="nombre" path="nombre" type="hidden"/>
		<form:input id="direccion" path="direccion" type="hidden"/>
		<form:input id="mail" path="mail" type="hidden"/>
		<form:input id="telefono" path="telefono" type="hidden"/>
		<form:input id="borrado" path="borrado" type="hidden"/>
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

$(document).ready(function(){

	var table = $('#tablita').DataTable( {
		language: i18n(),
		ajax: "proveedoresJson",
	    columns: [
	        {data: "nombre" },
	        {data: "direccion" },
	        {data: "mail" },
	        {data: "telefono" },
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
	                      window.location = "proveedoresNuevo";
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
			"nombre" : data["nombre"],
			"direccion" : data["direccion"],
			"mail" : data["mail"],
			"telefono" : data["telefono"],
			"borrado" : data["borrado"]
		};
		var mensaje = document.getElementById("mensajeBorrar").value;
		e.preventDefault();
		bootbox.confirm(mensaje, function (response) {
			if (response) {
				$.ajax({
					url : "proveedoresBorrarJson",
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
		document.getElementById("direccion").value = data["direccion"];
		document.getElementById("mail").value = data["mail"];
		document.getElementById("telefono").value = data["telefono"];
		document.getElementById("borrado").value = data["borrado"];
		document.getElementById("formModificar").submit();
	});
});

</script>
</body>
</html>