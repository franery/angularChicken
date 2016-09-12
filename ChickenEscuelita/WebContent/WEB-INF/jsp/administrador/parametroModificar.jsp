<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="parametroNuevo" /></title>

</head>
<body>
	<h1><spring:message code="parametroNuevo" /></h1>

	<form:form id="formModificar" method="POST" action="parametrosModificar"	commandName="parametro">
		<form:input path="id" type="hidden" value="${parametro.getId()}"/>
	
		<table>
			<tr>
				<td><spring:message code="descripcion" /></td>
				<td><form:input path="descripcion" required="required"/></td>
			</tr>
			<tr>
				<td><spring:message code="valor" /></td>
				<td><form:input path="valor" required="required"/></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center;">
				<input id="botonGuardar" type="submit" value="<spring:message code="guardar"/>" /> </td>
			</tr>
		</table>
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