<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="parametros" text="Parametros" /></title>

</head>
<body>
<h1 class="page-header" align="center"><spring:message code="parametros"/></h1>

	<button class="btn btn-success" id="nuevo"><spring:message code="nuevo"/></button>

	<table id="tablita" class="display order-column" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th><spring:message code="descripcion" /></th>
				<th><spring:message code="valor" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<form:form id="formModificar" action="parametrosModificar" method="post" commandName="parametro">
		<form:input id="id" path="id" type="hidden"/>
		<form:input id="descripcion" path="descripcion" type="hidden"/>
		<form:input id="valor" path="valor" type="hidden"/>
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

<script>

$(document).ready(function(){

	var table = $('#tablita').DataTable( {
		ajax: "parametrosJson",
	    columns: [
	        {data: "descripcion" },
	        {data: "valor" },
	        {defaultContent:'<button class="btn btn-danger" id="borrar">${borrar}</button>'},
	        {defaultContent:'<button class="btn btn-warning" id="modificar">${modificar}</button>'}
	        ],
	    select:true,
	    paging:true,
	    pageLength:50,
	    ordering:true
	});
	
	
	$('#nuevo').on('click', function (e) {
		window.location = "parametrosNuevo";
	});
	
	
	$('#tablita tbody').on('click', '#borrar', function (e) {
		var data = table.row(this.closest("tr")).data();
		var json = {
			"id" : data["id"],
			"descripcion" : data["descripcion"],
			"valor" : data["valor"],
			"borrado" : data["borrado"]
		};
		var mensaje = document.getElementById("mensajeBorrar").value;
		e.preventDefault();
		bootbox.confirm(mensaje, function (response) {
			if (response) {
				$.ajax({
					url : "parametrosBorrarJson",
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
		document.getElementById("descripcion").value = data["descripcion"];
		document.getElementById("valor").value = data["valor"];
		document.getElementById("borrado").value = data["borrado"];
		document.getElementById("formModificar").submit();
	});
});

</script>
</body>
</html>