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
					<th>${operacion.getNombre()}</th>
				</c:forEach>
			</tr>
		</thead>
	
		<c:forEach items="${listaModulos}" var="modulo">
			<tr>
				<td>${modulo.getNombre()}</td>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<c:forEach items="${tablaPermisos}" var="permiso">
						<c:if test="${permiso.getNombreModulo().equalsIgnoreCase(modulo.getNombre()) 
										&& permiso.getNombreOperacion().equalsIgnoreCase(operacion.getNombre())}">
							<c:set var="idPermiso" value="${permiso.getId()}"/>
						</c:if>					
					</c:forEach>				
					<c:choose>
						<c:when test="${((modulo.nombre == 'ventas' || modulo.nombre == 'movimientos') &&
								(operacion.nombre != 'Crear' && operacion.nombre != 'Listar')) || 
								(modulo.nombre == 'produccion' && operacion.nombre != 'Listar')}">
							<td><input name="${idPermiso}" id="${modulo.nombre} ${operacion.nombre}" type="checkbox"  disabled/></td>		
						</c:when>
						<c:otherwise>
							<td><input name="${idPermiso}" id="${modulo.nombre} ${operacion.nombre}" type="checkbox"/></td>					
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<input id="botonGuardar" type="submit" value="Modificar"/>
	</form:form>
	<script>
	var tablaPermisos = new Array();
	<c:forEach items="${tablaPermisosUsuario}" var="perm">
	    var permiso = '${perm.id}';
	    tablaPermisos.push(permiso);
	</c:forEach>
	for (var i = 0; i < tablaPermisos.length; i++) {
		document.getElementsByName(tablaPermisos[i])[0].checked = true;
	}
	$('#botonGuardar').on('click', function (e) {
		e.preventDefault();
		<c:forEach items="${tablaPermisos}" var="permiso">
			var checkbox = document.getElementsByName('${permiso.id}')[0];
			var permisoNombre = checkbox.id;
			var modulo = permisoNombre.split(" ")[0];
			var operacion = permisoNombre.split(" ")[1];
			if (checkbox.checked && operacion != 'Listar') {
				document.getElementById(modulo + " Listar").checked = true;
			}
		</c:forEach>
	    $('#formModificar').submit();
	});
	</script>
	
</body>
</html>