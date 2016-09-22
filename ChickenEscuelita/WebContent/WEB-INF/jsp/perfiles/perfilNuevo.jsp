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
	<h1 class="page-header">
		<spring:message code="perfilNuevo" />
	</h1>

	<form:form class="form-horizontal maxwid" id="formCrear" method="POST" action="perfilesProcesarNuevo" commandName="perfil">
	<div class="form-group">
		<div class="form-inline">
			<form:label class="control-label" path="nombre"><spring:message code="nombre" />: </form:label>
			<form:input class="form-control" path="nombre" name="nombre" type="text" value="${perfil.getNombre()}"/>
		</div>
	</div>
			<form:errors path="nombre" cssClass="error" /> 

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
	<input class="btn btn-default" id="botonGuardar" type="button" value="Crear"/>
	</form:form>
	
	<script>
	
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
	    $('#formCrear').submit();
	});
	</script>
	
</body>
</html>