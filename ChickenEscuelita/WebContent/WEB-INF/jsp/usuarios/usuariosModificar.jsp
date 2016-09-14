<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="usuarioModificar" /></title>
<style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
	<h1><spring:message code="usuarioModificar" /></h1>

	<form:form method="POST" id="formModificar" action="usuariosProcesarModificar" commandName="usuarioNM">
		<form:input path="id" type="hidden" value="${usuarioNM.getId()}"/>
	
		<table>
			<tr>
				<td><spring:message code="nombreUsuario" /></td>
				<td><form:input path="nombreUsuario" required="required"/></td>
			</tr>
			<tr>
				<td><spring:message code="nombre" /></td>
				<td><form:input path="nombre" required="required"/></td>
				<td><spring:message code="apellido" /></td>
				<td><form:input path="apellido" required="required"/></td>
			</tr>
			<tr>
				<td><spring:message code="contrasenia" /></td>
				<td><form:input path="contrasenia" type="password" required="required"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="perfil" />:</td>
			
			<c:forEach var="perfil" items="${perfiles}">
				</td>
					<td>
			        	<input type="checkbox" name="perfilFeo" value="${perfil.getId()}"/>${perfil.getNombre()}
	                </td>
				</tr>
				<td>
			</c:forEach>
				<td>
			</tr>
			
			<tr>
				<input id="stringConcatenado" name="perfiles" type="hidden"/>
				<td colspan="4" style="text-align: center;">
				<input id="botonGuardar" type="submit" value="<spring:message code="guardar"/>" /> </td>
			</tr>
			<tr>
				<td colspan="2"> <form:errors path="nombreUsuario" cssClass="error" /> </td> 
			</tr>
			<tr>
				<td colspan="2"> <form:errors path="id" cssClass="error" /> </td> 
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
    
    checkboxes = document.getElementsByName("perfilFeo"); 
	var perfiles = "";
	for (var i = 0; i < checkboxes.length; i++) {
	    var checkbox = checkboxes[i];
		if (checkbox.checked) {
			perfiles += checkbox.value + ";";    
		}
	}
	e.preventDefault();
    document.getElementById("stringConcatenado").value = perfiles;
    
    
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
            $('#formModificar').submit();
        }
    });
});
</script>

</body>
</html>