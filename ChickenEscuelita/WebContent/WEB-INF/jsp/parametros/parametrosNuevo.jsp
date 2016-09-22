<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="parametroNuevo" /></title>

</head>
<body>
	<h1 class="page-header"><spring:message code="parametroNuevo" /></h1>

<form:form  class="form-horizontal maxwid" method="post" commandName="parametro">
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="descripcion"><spring:message code="descripcion" text="descripcion"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="descripcion" path="descripcion" value="${parametro.getDescripcion()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="valor"><spring:message code="valor" text="valor"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="valor" path="valor" value="${parametro.getValor()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
			<input class="btn btn-default" id="botonNuevo" type="button" value=<spring:message code="guardar"/> />
		</div>
	</div>
</form:form>

<c:set var="mensajeErrorParametro">
	<spring:message code="mensajeErrorParametro" />
</c:set>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<p id="errores"></p>

<div class="wait"></div>

<script>

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");}
});

var mensajesError = {
		mensajeErrorParametro: "${mensajeErrorParametro}",
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}"
	};

	$('#botonNuevo').on('click', function (e) {
		e.preventDefault();
		var json = {
				"descripcion" : document.getElementById("descripcion").value,
				"valor" : document.getElementById("valor").value
			};
		$.ajax({
			url : "parametrosNuevoJson",
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
				window.location = "parametros";
			}
		});
	});

</script>

</body>
</html>