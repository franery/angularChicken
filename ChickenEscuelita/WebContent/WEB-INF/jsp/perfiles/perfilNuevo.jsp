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

<h1 class="page-header"><spring:message code="perfilNuevo" /></h1>

<form:form class="form-horizontal maxwid" id="formCrear" method="POST" action="perfilesProcesarNuevo" commandName="perfil">
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
				<td style="width:10%">${modulo.getNombre()} </td>
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
	</table>
	</div>
</form:form>
	
<form:form id="formAtras" action="atras" method="post">
	<input id="url" type="hidden" name="url" />
</form:form>

<div class="form-group">
    <div >
		<input id="botonAtras" class="btn btn-default" type="button" value=<spring:message code="atras"/> />
		<input id="botonGuardar" class="btn btn-default" type="button" value=<spring:message code="guardar"/> />
	</div>
</div>

<c:set var="mensajeErrorPerfil">
	<spring:message code="mensajeErrorPerfil" />
</c:set>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<div id="errores" class="alert alert-warning fade in" style="display:none;"></div>

<div class="wait"></div>

<script>
var listaPermisos = [];

var mensajesError = {
		mensajeErrorPerfil: "${mensajeErrorPerfil}",
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}"
	};
	
$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");},
    ready: function() {$("#errores").style.display("none");}
});

function obtenerListaPermisos(){
	<c:forEach items="${tablaPermisos}" var="permiso">
		var checkbox = document.getElementsByName('${permiso.id}')[0];
		if (checkbox.checked) {
			var permiso = {
				id: '${permiso.id}',	
			};
			listaPermisos.push(permiso);
		}
	</c:forEach>
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
	obtenerListaPermisos();
	var json = {
			"nombre" : document.getElementById("nombre").value,
			"listaPermisos" : listaPermisos,
		};
	$.ajax({
		url : "perfilesNuevoJson",
		type : "POST",
		data : JSON.stringify(json),
		dataType : "json",
		contentType : "application/json",
		processData : false,
		success: function(errores){
			var mensaje = "";
			for(var i = 0; i < errores.length; i++) {
				mensaje += mensajesError[errores[i].code] + "<br>";
			}
			document.getElementById("errores").innerHTML = mensaje;
			document.getElementById("errores").style.display = "block";
		},
		error: function(){
			window.location = "perfiles";
		}
	});
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