<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="parametroModificar" /></title>

</head>
<body>
	<h1 class="page-header"><spring:message code="parametroModificar" /></h1>

<form:form class="form-horizontal maxwid" id="formModificar" method="post" commandName="parametro">
	<form:input id="id" path="id" type="hidden" value="${parametro.getId()}"/>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="descripcion"><spring:message code="descripcion" text="descripcion"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="descripcion" path="descripcion" value="${parametro.getDescripcion()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="valor"><spring:message code="valor" text="valor"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="valor" path="valor" value="${parametro.getValor()}" />
		</div>
	</div>
</form:form>
	
<c:set var="value">
		<spring:message code="mensajeModificar" />
	</c:set>

<input id="mensajeModificar" type="hidden" value="${value}" />
	
<c:set var="mensajeErrorParametro">
	<spring:message code="mensajeErrorParametro" />
</c:set>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
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

var mensajesError = {
		mensajeErrorParametro: "${mensajeErrorParametro}",
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}"
	};

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
ajaxStop: function() {$("body").removeClass("loading");},ready: function() {$("#errores").style.display("none");}});

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	var json = {
        			"id" : document.getElementById("id").value,
        			"descripcion" : document.getElementById("descripcion").value,
        			"valor" : document.getElementById("valor").value
        		};
        	$.ajax({
        		url : "parametrosModificarJson",
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
document.getElementById("errores").innerHTML = mensaje; document.getElementById("errores").style.display = "block";        		},
        		error: function(){
        			window.location = "parametros";
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