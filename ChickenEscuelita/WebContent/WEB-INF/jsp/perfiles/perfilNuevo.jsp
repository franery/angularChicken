<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="perfilNuevo" /></title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>
		<spring:message code="perfilNuevo" />
	</h1>

	<form:form id="formCrear" method="POST" action="perfilesProcesarNuevo">
	<table>
		<thead>
			<tr>
				<th></th>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<th>${operacion.getName()}</th>
				</c:forEach>
		</thead>

		<c:forEach items="${listaModulos}" var="modulo">
			<tr>
				<td>${modulo.getName()}</td>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<c:choose>
						<c:when test="${modulo.getName().equals('ventas') || modulo.getName().equals('movimientos')}">
        					<c:choose>
        				    	<c:when test="${operacion.getName().equals('Crear') || operacion.getName().equals('Listar')}">
        				    		<td><input name="checkbox" type="checkbox" value="${modulo.getName()}${operacion.getName()}"></input></td>
        				    	</c:when>
        				    	<c:otherwise>
        				    		<td></td>
        				    	</c:otherwise>    					
        					</c:choose>
						</c:when>
						<c:when test="${modulo.getName().equals('produccion')}">
        					<c:choose>
        				    	<c:when test="${operacion.getName().equals('Listar')}">
        				    		<td><input name="checkbox" type="checkbox" value="${modulo.getName()}${operacion.getName()}"></input></td>
        				    	</c:when>
        				    	<c:otherwise>
        				    		<td></td>
        				    	</c:otherwise>    					
        					</c:choose>
						</c:when>
						<c:otherwise>
       						<td><input name="checkbox" type="checkbox" value="${modulo.getName()}${operacion.getName()}"></input></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>

	</table>
	<input id="stringConcatenado" name="permisos" type="hidden"/>
	<input id="botonGuardar" type="submit" value="Crear"/>
	</form:form>
	
	<script>
	
	$('#botonGuardar').on('click', function (e) {
		checkboxes = document.getElementsByName("checkbox"); 
		var permisos = "";
		for (var i = 0; i < checkboxes.length; i++) {
		    var checkbox = checkboxes[i];
			if (checkbox.checked) {
				permisos += checkbox.value + ";";    
			}
		}
		e.preventDefault();
	    document.getElementById("stringConcatenado").value = permisos;
	    $('#formCrear').submit();
	});
	</script>
	
</body>
</html>