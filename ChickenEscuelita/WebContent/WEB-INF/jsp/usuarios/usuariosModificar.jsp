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
	<h1 class="page-header"><spring:message code="usuarioModificar" /></h1>

	<form:form class="form-horizontal maxwid" method="POST" id="formModificar" action="usuariosProcesarModificar" commandName="usuarioNM">
		<form:input path="id" type="hidden" value="${usuarioNM.getId()}"/>
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
					<input class="btn btn-default" id="botonGuardar" type="submit" value="<spring:message code="modificar"/>" /> 
					<form:errors path="nombreUsuario" cssClass="error" />  
					 <form:errors path="id" cssClass="error" />  
				</div>
			</div>
	</form:form>				
	
	<c:set var="value">
		<spring:message code="mensajeModificar" />
	</c:set>
	<input id="mensajeModificar" type="hidden" value="${value}" />
	
<script>

$('#botonGuardar').on('click', function (e) {
	$('#botonGuardar').on('click', function (e) {
		e.preventDefault();
	    $('#formModificar').submit();
	});
</script>

</body>
</html>