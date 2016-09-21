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
<title><spring:message code="proveedoresNuevo"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="proveedoresNuevo"/></h1>

<form:form action="proveedoresProcesarNuevo" method="post" commandName="proveedor">
	<form:input id="id" path="id" type="hidden" value="${proveedor.getId()}"/>
	<form:input id="borrado" path="borrado" type="hidden" value="${proveedor.getBorrado()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre"/>:</form:label></td>
			<td><form:input id="nombre" path="nombre" value="${proveedor.getNombre()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="direccion"><spring:message code="direccion"/>:</form:label></td>
			<td><form:input id="direccion" path="direccion" value="${proveedor.getDireccion()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="mail"><spring:message code="mail"/>:</form:label></td>
			<td><form:input id="mail" path="mail" value="${proveedor.getMail()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="telefono"><spring:message code="telefono"/>:</form:label></td>
			<td><form:input id="telefono" path="telefono" value="${proveedor.getTelefono()}" required="required"/></td>
		</tr>
	</table>
	<input id="botonNuevo" type="button" value=<spring:message code="guardar"/> />
</form:form>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<c:set var="mensajeErrorNombreUnico">
	<spring:message code="mensajeErrorNombreUnico" />
</c:set>

<c:set var="mensajeErrorMailVacio">
	<spring:message code="mensajeErrorMailVacio" />
</c:set>

<c:set var="mensajeErrorDireccionVacio">
	<spring:message code="mensajeErrorDireccionVacio" />
</c:set>

<c:set var="mensajeErrorTelefonoVacio">
	<spring:message code="mensajeErrorTelefonoVacio" />
</c:set>

<p id="errores"></p>

<script>

var mensajesError = {
	mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}",
	mensajeErrorNombreUnico: "${mensajeErrorNombreUnico}",
	mensajeErrorDireccionVacio: "${mensajeErrorDireccionVacio}",
	mensajeErrorMailVacio: "${mensajeErrorMailVacio}",
	mensajeErrorTelefonoVacio: "${mensajeErrorTelefonoVacio}",
};

$('#botonNuevo').on('click', function (e) {
	e.preventDefault();
	var json = {
			"nombre" : document.getElementById("nombre").value,
			"direccion" : document.getElementById("direccion").value,
			"mail" : document.getElementById("mail").value,
			"telefono" : document.getElementById("telefono").value
		};
	$.ajax({
		url : "proveedoresNuevoJson",
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
			window.location = "proveedores";
		}
	});
});

</script>

</body>
</html>