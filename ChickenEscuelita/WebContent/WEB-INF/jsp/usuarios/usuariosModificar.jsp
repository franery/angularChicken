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

	<form:form class="form-horizontal maxwid" method="POST" id="formModificar" commandName="usuarioNM">
		<form:input id="id" path="id" type="hidden" value="${usuarioNM.getId()}"/>
		<form:input id="borrado" path="borrado" type="hidden" value="${usuarioNM.getBorrado()}"/>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="nombreUsuario"><spring:message code="nombreUsuario" />:</form:label>
			<div class="col-sm-10">
				<form:input id="nombreUsuario" class="form-control" path="nombreUsuario" value="${usuarioNM.getNombreUsuario()}" required="required"/>
			</div>
		</div>
		<div class="form-group">			
			<form:label class="control-label col-sm-2" path="nombre"><spring:message code="nombre" />:</form:label>
			<div class="col-sm-10">
				<form:input id="nombre" class="form-control" path="nombre" value="${usuarioNM.getNombre()}" required="required"/>
			</div>
		</div>
		<div class="form-group">		
			<form:label class="control-label col-sm-2" path="apellido"><spring:message code="apellido" />:</form:label>
			<div class="col-sm-10">
				<form:input id="apellido" class="form-control" path="apellido" value="${usuarioNM.getApellido()}" required="required"/>
			</div>
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="contrasenia"><spring:message code="contrasenia" />:</form:label>
			<div class="col-sm-10">
				<form:input id="contrasenia" class="form-control" path="contrasenia" type="password" value="${usuarioNM.getContrasenia()}" required="required"/>
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

<c:set var="value">
	<spring:message code="mensajeModificar" />
</c:set>
	
<input id="mensajeModificar" type="hidden" value="${value}" />

<c:set var="mensajeErrorUsuario">
	<spring:message code="mensajeErrorUsuario" />
</c:set>

<c:set var="mensajeErrorUsuarioRoot">
	<spring:message code="mensajeErrorUsuarioRoot" />
</c:set>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<c:set var="mensajeErrorContraseniaVacia">
	<spring:message code="mensajeErrorContraseniaVacia" />
</c:set>

<div id="errores" class="alert alert-warning fade in" style="display:none;"></div>

<form:form id="formAtras" action="atras" method="post">
	<input id="url" type="hidden" name="url" />
	
</form:form>
<div class="form-group">
    <div >
		<input id="botonAtras" class="btn btn-default" type="button" value=<spring:message code="atras"/> />
		<input id="botonGuardar" class="btn btn-default" type="button" value=<spring:message code="guardar"/> />
	</div>
</div>

<div class="wait"></div>
	
<script>

var listaPerfiles = [];

var mensajesError = {
		mensajeErrorUsuario: "${mensajeErrorUsuario}",
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}",
		mensajeErrorUsuarioRoot: "${mensajeErrorUsuarioRoot}",
		mensajeErrorContraseniaVacia: "${mensajeErrorContraseniaVacia}"
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

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    obtenerListaPerfiles();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	var json = {
        			"id" : document.getElementById("id").value,
        			"nombreUsuario" : document.getElementById("nombreUsuario").value,
        			"nombre" : document.getElementById("nombre").value,
        			"apellido" : document.getElementById("apellido").value,
        			"listaPerfiles" : listaPerfiles,
        			"contrasenia" : document.getElementById("contrasenia").value
        		};
        	$.ajax({
        		url : "usuariosModificarJson",
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