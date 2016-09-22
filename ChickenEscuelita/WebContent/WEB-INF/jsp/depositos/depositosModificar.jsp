<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="depositoModificar"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="depositoModificar"/></h1>

<form:form class="form-horizontal maxwid" id="formModificar" method="post" commandName="deposito">
	<form:input id="id" path="id" type="hidden" value="${deposito.getId()}"/>
	<form:input id="stockHuevos" path="stockHuevos" type="hidden" value="${deposito.getStockHuevos()}"/>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="nombre"><spring:message code="nombre" text="Nombre"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="nombre" path="nombre" value="${deposito.getNombre()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="stockMaximo"><spring:message code="stockMaximo" text="Stock Maximo"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="stockMaximo" path="stockMaximo" value="${deposito.getStockMaximo()}" />
		</div>
	</div>
	<div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
			<input class="btn btn-default" id="botonGuardar" type="button" value=<spring:message code="guardar"/> />
		</div>
	</div>
</form:form>
	
<c:set var="value">
	<spring:message code="mensajeModificar" />
</c:set>
	
<input id="mensajeModificar" type="hidden" value="${value}" />
	
<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<c:set var="mensajeErrorNombreUnico">
	<spring:message code="mensajeErrorNombreUnico" />
</c:set>

<c:set var="mensajeErrorStockMinimo">
	<spring:message code="mensajeErrorStockMinimo" />
</c:set>

<c:set var="mensajeErrorStockMaximoMenorActual">
	<spring:message code="mensajeErrorStockMaximoMenorActual" />
</c:set>

<c:set var="mensajeErrorStockMaximoNumero">
	<spring:message code="mensajeErrorStockMaximoNumero" />
</c:set>

<p id="errores"></p>

<div class="wait"></div>
	
<script>

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");}
});

var mensajesError = {
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}",
		mensajeErrorNombreUnico: "${mensajeErrorNombreUnico}",
		mensajeErrorStockMinimo: "${mensajeErrorStockMinimo}",
		mensajeErrorStockMaximoMenorActual: "${mensajeErrorStockMaximoMenorActual}",
		mensajeErrorStockMaximoNumero: "${mensajeErrorStockMaximoNumero}",
	};

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	var json = {
        			"id" : document.getElementById("id").value,
        			"nombre" : document.getElementById("nombre").value,
        			"stockHuevos" : document.getElementById("stockHuevos").value,
        			"stockMaximo" : document.getElementById("stockMaximo").value
        		};
        	$.ajax({
        		url : "depositosModificarJson",
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
        		},
        		error: function(){
        			window.location = "depositos";
        		}
        	});
        }
    });
});

</script>

</body>
</html>