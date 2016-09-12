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
<title><spring:message code="proveedoresModificar"/></title>
</head>
<body>

<h1><spring:message code="proveedoresModificar"/></h1>

<form:form id="formModificar" action="proveedoresProcesarModificarContable" method="post" commandName="proveedor">
	<form:input path="id" type="hidden" value="${proveedor.getId()}"/>
	<form:input path="borrado" type="hidden" value="${proveedor.getBorrado()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre"/>:</form:label></td>
			<td><form:input path="nombre" value="${proveedor.getNombre()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="direccion"><spring:message code="direccion"/>:</form:label></td>
			<td><form:input path="direccion" value="${proveedor.getDireccion()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="mail"><spring:message code="mail"/>:</form:label></td>
			<td><form:input path="mail" value="${proveedor.getMail()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="telefono"><spring:message code="telefono"/>:</form:label></td>
			<td><form:input path="telefono" value="${proveedor.getTelefono()}" required="required"/></td>
		</tr>
	</table>
	<input id="botonGuardar" type="submit" value=<spring:message code="guardar"/> />
</form:form>
	
	<c:set var="value">
		<spring:message code="mensajeModificar" />
	</c:set>
	<input id="mensajeModificar" type="hidden" value="${value}" />
	
<script>

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
            $('#formModificar').submit();
        }
    });
});

</script>

</body>
</html>