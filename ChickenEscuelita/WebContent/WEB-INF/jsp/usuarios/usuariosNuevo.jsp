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

	<form:form id="formNuevo" class="form-horizontal maxwid" method="POST" autocomplete="off" commandName="usuarioNM">
		<form:input id="id" class="form-control" path="id" type="hidden" value="${usuarioNM.getId()}"/>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="nombreUsuario"><spring:message code="nombreUsuario" />:</form:label>
			<div class="col-sm-10">
				<form:input id="nombreUsuario" class="form-control" path="nombreUsuario" required="required"/>
			</div>
		</div>
		<div class="form-group">			
			<form:label class="control-label col-sm-2" path="nombre"><spring:message code="nombre" />:</form:label>
			<div class="col-sm-10">
				<form:input id="nombre" class="form-control" path="nombre" required="required"/>
			</div>
		</div>
		<div class="form-group">		
			<form:label class="control-label col-sm-2" path="apellido"><spring:message code="apellido" />:</form:label>
			<div class="col-sm-10">
				<form:input id="apellido" class="form-control" path="apellido" required="required"/>
			</div>
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="contrasenia"><spring:message code="contrasenia" />:</form:label>
			<div class="col-sm-10">
				<form:input id="contrasenia" class="form-control" path="contrasenia" type="password" required="required"/>
			</div>
		</div>
			<div  class="form-group">
				<div class="radio">
				<form:label class="control-label col-sm-2" path="listaPerfiles"><spring:message code="perfil" />:</form:label>
					<c:forEach var="perfil" items="${perfiles}">
					        	<input id="${perfil.getId()}" type="checkbox" name="listaPerfiles" value="${perfil}"/>${perfil.getNombre()}
					</c:forEach>
				</div>
			</div>	
	</form:form>

<c:set var="mensajeErrorUsuario">
	<spring:message code="mensajeErrorUsuario" />
</c:set>

<c:set var="mensajeErrorUsuarioRoot">
	<spring:message code="mensajeErrorUsuarioRoot" />
</c:set>

<div id="errores" class="alert alert-warning fade in" style="display:none;"></div>

<form:form id="formAtras" action="atras" method="post">
	<input id="url" type="hidden" name="url" />
	
</form:form>
<div class="form-group">
    <div >
		<input id="botonAtras" class="btn btn-default" type="button" value=<spring:message code="atras"/> />
		<input id="botonNuevo" class="btn btn-default" type="button" value=<spring:message code="guardar"/> />
	</div>
</div>
<div class="wait"></div>

<script>

var listaPerfiles = [];

var mensajesError = {
		mensajeErrorUsuario: "${mensajeErrorUsuario}",
		mensajeErrorUsuarioRoot: "${mensajeErrorUsuarioRoot}"
	};

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");},
    ready: function() {$("#errores").style.display("none");}
});

function obtenerListaPerfiles(){
	var lista = document.getElementsByName("listaPerfiles");
	for(var i = 0; i < lista.length; i++) {
		if(document.getElementById(lista[i].id).checked) {
			var perfil = {
					id: lista[i].id,
			};
			listaPerfiles.push(perfil);
		}
	}
};

$('#botonNuevo').on('click', function (e) {
	e.preventDefault();
	obtenerListaPerfiles();
	var json = {
			"nombreUsuario" : document.getElementById("nombreUsuario").value,
			"nombre" : document.getElementById("nombre").value,
			"apellido" : document.getElementById("apellido").value,
			"listaPerfiles" : listaPerfiles,
			"contrasenia" : document.getElementById("contrasenia").value
		};
	$.ajax({
		url : "usuariosNuevoJson",
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
			window.location = "usuarios";
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