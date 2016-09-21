<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="usuarioNuevo" /></title>
</head>
<body>
	<h1  class="page-header"><spring:message code="usuarioNuevo" /></h1>

	<form:form method="POST"  id="formNuevo" action="usuariosProcesarNuevo" commandName="usuarioNM">
		<form:input path="id" type="hidden" value="${usuarioNM.getId()}"/>
		<div class="form-group">
					<spring:message code="nombreUsuario" />
					<form:input path="nombreUsuario" required="required"/>
					<spring:message code="nombre" />
					<form:input path="nombre" required="required"/>
					<spring:message code="apellido" />
					<form:input path="apellido" required="required"/>
					<spring:message code="contrasenia" />
					<form:input path="contrasenia" type="password" required="required"/>
					<spring:message code="perfil" />:
				
				<c:forEach var="perfil" items="${perfiles}">
				        	<input type="checkbox" id="${perfil.getId()}" name="${perfil.getId()}" value="${perfil.getId()}"/>${perfil.getNombre()}
				</c:forEach>
					<input id="botonGuardar" type="submit" value="<spring:message code="guardar"/>" /> 
					<form:errors path="nombreUsuario" cssClass="error" />  
		</div>
	</form:form>
	<script>
	$('#botonGuardar').on('click', function (e) {
		e.preventDefault();
	    $('#formNuevo').submit();
	});
	</script>
</body>
</html>