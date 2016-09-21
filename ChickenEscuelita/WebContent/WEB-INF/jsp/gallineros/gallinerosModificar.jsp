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
<title><spring:message code="gallinerosModificar"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="gallinerosModificar"/></h1>

<form:form id="formModificar" action="gallinerosProcesarModificar" method="post" commandName="gallinero">
	<form:input id="id" path="id" type="hidden" value="${gallinero.getId()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre"/>:</form:label></td>
			<td><form:input id="nombre" path="nombre" value="${gallinero.getNombre()}" /></td>
		</tr>
		<tr>
			<td><form:label path="usuarioId"><spring:message code="usuario"/>:</form:label></td>
			<td>
				<form:select id="usuarioId" path="usuarioId" required="required">
					<form:option value=""><spring:message code="seleccionar" /></form:option>
						<c:forEach items="${listaUsuarios}" var="usuario">
							<form:option value="${usuario.getId()}">
								<c:out value="${usuario.getNombre()}"></c:out>
							</form:option>
						</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label path="stockGallinas"><spring:message code="stock"/>:</form:label></td>
			<td><form:input id="stockGallinas" path="stockGallinas"  value="${gallinero.getStockGallinas()}" required="required"/></td>
		</tr>
	</table>
	<input id="botonGuardar" type="button" value=<spring:message code="guardar"/> />
</form:form>
	
<c:set var="value">
	<spring:message code="mensajeModificar" />
</c:set>
<input id="mensajeModificar" type="hidden" value="${value}" />
	
<p id="errores"></p>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<c:set var="mensajeErrorNombreUnico">
	<spring:message code="mensajeErrorNombreUnico" />
</c:set>

<c:set var="mensajeErrorStockMinimo">
	<spring:message code="mensajeErrorStockMinimo" />
</c:set>

<c:set var="mensajeErrorUsuarioInvalido">
	<spring:message code="mensajeErrorUsuarioInvalido" />
</c:set>
	
	
<script>

var mensajesError = {
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}",
		mensajeErrorNombreUnico: "${mensajeErrorNombreUnico}",
		mensajeErrorStockMinimo: "${mensajeErrorStockMinimo}",
		mensajeErrorUsuarioInvalido: "${mensajeErrorUsuarioInvalido}",
};

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	var json = {
        			"id" : document.getElementById("id").value,
        			"nombre" : document.getElementById("nombre").value,
        			"usuarioId" : document.getElementById("usuarioId").value,
        			"stockGallinas" : document.getElementById("stockGallinas").value
        		};
        	$.ajax({
        		url : "gallinerosModificarJson",
        		type : "POST",
        		data : JSON.stringify(json),
        		dataType : "json",
        		contentType : "application/json",
        		processData : false,
        		success: function(errores){
        			var mensaje = "";
        			for(var i = 0; i < errores.length; i++) {
        				mensaje += mensajesError[errores[i].code] + "<br>";
        			}
        			document.getElementById("errores").innerHTML = mensaje;
        		},
        		error: function(){
        			window.location = "gallineros";
        		}
        	});
        }
    });
});

</script>

</body>
</html>