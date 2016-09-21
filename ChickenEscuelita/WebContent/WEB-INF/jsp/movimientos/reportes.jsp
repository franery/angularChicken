<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="movimientos"/></title>
</head>
<body>
<h1 class="page-header"><spring:message code="movimientos"/></h1>

	<button id="nuevo"><spring:message code="nuevo"/></button>

		<form:form method="POST" commandName="filtro">
		<table>
			<tr>
				<td> <form:label path="fechaDesde"><spring:message code="fechaDesde"/></form:label> </td>
				<td> <form:input id="fechaDesde" path="fechaDesde" type="date" /> </td>
			</tr>
			<tr>
				<td> <form:label path="fechaHasta"><spring:message code="fechaHasta"/></form:label> </td>
				<td> <form:input id="fechaHasta" path="fechaHasta" type="date" /> </td>
			</tr>
			<tr> 
				<td> <form:label path="cantidadDesde"><spring:message code="cantidadDesde"/></form:label> </td>
				<td> <form:input id="cantidadDesde" path="cantidadDesde" type="text" /> </td>
			</tr>
			<tr> 
				<td> <form:label path="cantidadHasta"><spring:message code="cantidadHasta"/></form:label> </td>
				<td> <form:input id="cantidadHasta" path="cantidadHasta" type="text" /> </td>
			</tr>
			<tr> <td> <input type="button" onclick="filtrar()" value=<spring:message code="filtrar"/> /> </td> </tr>
		</table>
	</form:form>
	
	<table id="tablita" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th><spring:message code="fecha"/></th>
				<th><spring:message code="cantidad"/></th>
				<th><spring:message code="gallinero"/></th>
				<th><spring:message code="deposito"/></th>
            </tr>
        </thead>
    </table>

<script>
$(document).ready(function(){
	listar();
});

$('#nuevo').on('click', function (e) {
	window.location = "movimientosNuevo";
});

function listar() {
	$('#tablita').DataTable( {
		ajax: "movimientosJson",
	    columns: [
	              { data: "fecha" },
	              { data: "cantidad" },
	              { data: "gallineroNombre" },
	              { data: "depositoNombre" }
	              ]
	});
}

function filtrar() {
	var fechaDesde = $('#fechaDesde').val();
    var fechaHasta = $('#fechaHasta').val();
    var cantidadDesde = $('#cantidadDesde').val();
    var cantidadHasta= $('#cantidadHasta').val();
    var json = {"fechaDesde" : fechaDesde,
    			"fechaHasta" : fechaHasta, 
    			"cantidadDesde": cantidadDesde,
    			"cantidadHasta": cantidadHasta
    			};
	$('#tablita').DataTable( {
		ajax: {
			url: "filtrando",
			type: "POST",
			data: function() {
				return JSON.stringify(json);
			},
			dataType: "json",
			contentType: "application/json",
			processData:false
		},
		bDestroy: true,
		serverside: true,
		columns: [
	              { data: "fecha" },
	              { data: "cantidad" },
	              { data: "gallineroNombre" },
	              { data: "depositoNombre" }
	              ]
	});
}
</script>
</body>
</html>