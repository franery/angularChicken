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

	<form:form id="formModificar" method="POST" action="perfilesProcesarModificar" commandName="perfil">
	<form:input path="id" type="hidden" value="${perfil.getId()}"/>
	<spring:message code="nombre" /> <input name="nombre" type="text" value="${perfil.nombre}"/>
		<table>
		<thead>
			<tr>
				<th></th>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<th>${operacion.getName()}</th>
				</c:forEach>
			</tr>
		</thead>
	
		<c:forEach items="${listaModulos}" var="modulo">
			<tr>
				<td>${modulo.getName()}</td>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<c:forEach items="${tablaPermisos}" var="permiso">
						<c:if test="${permiso.getNombreModulo().equalsIgnoreCase(modulo.getName()) 
										&& permiso.getNombreOperacion().equalsIgnoreCase(operacion.getName())}">
							<c:set var="idPermiso" value="${permiso.getId()}"/>
						</c:if>					
					</c:forEach>				
				
					<c:choose>
						<c:when test="${modulo.getName().equals('ventas') || modulo.getName().equals('movimientos')}">
        					<c:choose>
        				    	<c:when test="${operacion.getName().equals('Crear') || operacion.getName().equals('Listar')}">
        				    		 <td><input id="${idPermiso}" name="${idPermiso}" type="checkbox" /></td>
        				    	</c:when>
        				    	<c:otherwise>
        				    		<td><input id="${idPermiso}" name="${idPermiso}" type="checkbox"  disabled/></td>
        				    	</c:otherwise>    					
        					</c:choose>
						</c:when>
						<c:when test="${modulo.getName().equals('produccion')}">
        					<c:choose>
        				    	<c:when test="${operacion.getName().equals('Listar')}">
        				    		 <td><input id="${idPermiso}" name="${idPermiso}" type="checkbox" /></td>
        				    	</c:when>
        				    	<c:otherwise>
        				    		<td><input id="${idPermiso}" name="${idPermiso}" type="checkbox"  disabled/></td>
        				    	</c:otherwise>    					
        					</c:choose>
						</c:when>
						<c:otherwise>
       						<td><input id="${idPermiso}" name="${idPermiso}" type="checkbox"/></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>

	</table>
	<input id="stringConcatenado" name="permisos" type="hidden"/>
	<form:input path="id" id="stringConcatenado" name="permisos" type="hidden"/>
	<input id="botonGuardar" type="submit" value="Modificar"/>
	</form:form>
	<script>
	var tablaPermisos = new Array();
	<c:forEach items="${tablaPermisosUsuario}" var="perm">
	    var permiso = '${perm.id}';
	    tablaPermisos.push(permiso);
	</c:forEach>
	for (var i = 0; i < tablaPermisos.length; i++) {
	    document.getElementById(tablaPermisos[i]).checked = true;
	}
	$('#botonGuardar').on('click', function (e) {
		e.preventDefault();
	    $('#formModificar').submit();
	});
	</script>
	
</body>
</html>