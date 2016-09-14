<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="perfilModificar" /></title>
<style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
	<h1><spring:message code="perfilModificar" /></h1>

	<form:form id="formModificar" method="POST" action="perfilesProcesarModificar">
	<spring:message code="nombre" /> <input name="nombre" type="text"/>
	<table>
		<thead>
			<tr>
				<th></th>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<th>${operacion.getName()}</th>
				</c:forEach>
			</tr>
		</thead>
		<c:set var="iterator" value="1"/>
		<c:forEach items="${listaModulos}" var="modulo">
			<tr>
				<td>${modulo.getName()}</td>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<c:choose>
						<c:when test="${modulo.getName().equals('ventas') || modulo.getName().equals('movimientos')}">
        					<c:choose>
        				    	<c:when test="${operacion.getName().equals('Crear') || operacion.getName().equals('Listar')}">
        				    		<td><input name="checkbox" type="checkbox" value="${iterator}" id="${iterator}"></input></td>
        				    	</c:when>
        				    	<c:otherwise>
        				    		<td><input type="checkbox" disabled/></td>
        				    	</c:otherwise>    					
        					</c:choose>
						</c:when>
						<c:when test="${modulo.getName().equals('produccion')}">
        					<c:choose>
        				    	<c:when test="${operacion.getName().equals('Listar')}">
        				    		<td><input name="checkbox" type="checkbox" value="${iterator} id="${iterator}""></input></td>
        				    	</c:when>
        				    	<c:otherwise>
        				    		<td><input type="checkbox" disabled/></td>
        				    	</c:otherwise>    					
        					</c:choose>
						</c:when>
						<c:otherwise>
       						<td><input name="checkbox" type="checkbox" value="${iterator} id="${iterator}""></input></td>
						</c:otherwise>
					</c:choose>
				<c:set var="iterator" value="${iterator+1}"/>
				</c:forEach>
			</tr>
			
		</c:forEach>
		

	</table>
	<input id="stringConcatenado" name="permisos" type="hidden"/>
	<input id="botonGuardar" type="submit" value="Crear"/>
	</form:form>
	<p id="demo"/>
	<script>
	var tablaPermisos = new Array();
	<c:forEach items="${tablaPermisos}" var="permiso">
	    var permiso = new Object();
	    permiso.id = '${permiso.id}';
	    tablaPermisos.push(people);
	</c:forEach>
	var text = "";
	for (var i = 0; i < tablaPermisos.length; i++) {
	    text += tablaPermisos[i] + "<br>";
	}
	document.getElementById("demo").innerHTML = text;
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
	    $('#formModificar').submit();
	});
	</script>
	
</body>
</html>