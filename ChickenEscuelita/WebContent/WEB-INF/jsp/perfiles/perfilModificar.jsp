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

<h1 class="page-header"><spring:message code="perfilModificar" /></h1>

<form:form class="form-horizontal maxwid" id="formModificar" method="POST" action="perfilesProcesarModificar" commandName="perfil">
	<form:input path="id" type="hidden" value="${perfil.getId()}"/>
	<div class="form-group">
		<div class="form-inline">
			<form:label class="control-label" path="nombre"><spring:message code="nombre" />: </form:label>
			<form:input class="form-control" path="nombre" name="nombre" type="text" value="${perfil.getNombre()}"/>
		</div>
	</div>
	<div class="form-group">
		<table class="table-bordered">
		<thead>
			<tr>
				<th></th>
				<c:forEach items="${listaOperaciones}" var="operacion">
					<th class="text-center">${operacion.getNombre()}</th>
				</c:forEach>
			</tr>
		</thead>
	
		<c:forEach items="${listaModulos}" var="modulo">
			<tr>
				<td style="width:10%">${modulo.getNombre()}</td>
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
							<td style="width:10%"><input name="${idPermiso}" id="${modulo.nombre} ${operacion.nombre}" type="checkbox"  disabled/></td>		
						</c:when>
						<c:otherwise>
							<td style="width:10%"><input name="${idPermiso}" id="${modulo.nombre} ${operacion.nombre}" type="checkbox"/></td>					
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4"> <form:errors path="nombre" cssClass="error" /> </td> 
			</tr>
		</table>
	</div>
	<input class="btn btn-default" id="botonGuardar" type="submit" value="Modificar"/>
	</form:form>
	
	<form:form id="formAtras" action="atras" method="post">
	<input id="url" type="hidden" name="url" />

	<div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
			<input id="botonAtras" type="button" value=<spring:message code="atras"/> />
		</div>
	</div>
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
	
	$('#botonAtras').on('click', function(e) {
		e.preventDefault();
		var url = document.URL;
		document.getElementById("url").value = url;
		document.getElementById("formAtras").submit();
	});
	
	</script>
	
</body>
</html>