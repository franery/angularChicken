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

	<form:form class="form-horizontal maxwid" method="POST"  id="formNuevo" autocomplete="off" action="usuariosProcesarNuevo" commandName="usuarioNM">
		<form:input class="form-control" path="id" type="hidden" value="${usuarioNM.getId()}"/>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="nombreUsuario"><spring:message code="nombreUsuario" />:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="nombreUsuario" required="required"/>
			</div>
		</div>
		<div class="form-group">			
			<form:label class="control-label col-sm-2" path="nombre"><spring:message code="nombre" />:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="nombre" required="required"/>
			</div>
		</div>
		<div class="form-group">		
			<form:label class="control-label col-sm-2" path="apellido"><spring:message code="apellido" />:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="apellido" required="required"/>
			</div>
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="nombreUsuario"><spring:message code="contrasenia" />:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="contrasenia" type="password" required="required"/>
			</div>
		</div>
			<div  class="form-group">
				<div class="radio">
				<form:label class="control-label col-sm-2" path="nombreUsuario"><spring:message code="perfil" />:</form:label>
					<c:forEach var="perfil" items="${perfiles}">
					        	<input type="checkbox" id="${perfil.getId()}" name="${perfil.getId()}" value="${perfil.getId()}"/>${perfil.getNombre()}
					</c:forEach>
				</div>
			</div>	
			<div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-default" id="botonGuardar" type="submit" value="<spring:message code="guardar"/>" /> 
					<form:errors path="nombreUsuario" cssClass="error" />  
				</div>
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