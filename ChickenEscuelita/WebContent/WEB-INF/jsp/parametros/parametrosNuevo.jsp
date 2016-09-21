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

<form:form method="post" commandName="parametro">
	<table>
		<tr>
			<td><form:label path="descripcion"><spring:message code="descripcion" text="descripcion"/>:</form:label></td>
			<td><form:input id="descripcion" path="descripcion" value="${parametro.getDescripcion()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="valor"><spring:message code="valor" text="valor"/>:</form:label></td>
			<td><form:input id="valor" path="valor" value="${parametro.getValor()}" required="required"/></td>
		</tr>
	</table>
	<input id="botonNuevo" type="button" value=<spring:message code="guardar"/> />
</form:form>

<c:set var="mensajeErrorParametro">
	<spring:message code="mensajeErrorParametro" />
</c:set>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<p id="errores"></p>

<script>

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