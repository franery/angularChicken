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
<title><spring:message code="gallineroNuevo"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="gallineroNuevo"/></h1>

<form:form class="form-horizontal maxwid" action="gallinerosProcesarNuevo" method="post" commandName="gallinero">
	<form:input path="id" type="hidden" value="${gallinero.getId()}"/>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="nombre"><spring:message code="nombre"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="nombre" path="nombre" value="${gallinero.getNombre()}" required="required"/>
		</div>	
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="usuarioId"><spring:message code="usuario"/>:</form:label>
		<div class="col-sm-10">
			<form:select class="form-control" style="width:auto;" id="usuarioId" path="usuarioId" required="required">
				<form:option value=""><spring:message code="seleccionar" /></form:option>
					<c:forEach items="${listaUsuarios}" var="usuario">
						<form:option value="${usuario.getId()}">
							<c:out value="${usuario.getNombre()}"></c:out>
						</form:option>
					</c:forEach>
			</form:select>
		</div>				
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="stockGallinas"><spring:message code="stock"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control"  id="stockGallinas" path="stockGallinas"  value="${gallinero.getStockGallinas()}" required="required" />
		</div>
	</div>
	<div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
			<input class="btn btn-default" id="botonNuevo" type="button" value=<spring:message code="guardar"/> />
		</div>
	</div>
</form:form>

<p id="errores"></p>

<c:set var="mensajeErrorNombreVacio">
	<spring:message code="mensajeErrorNombreVacio" />
</c:set>

<c:set var="mensajeErrorNombreUnico">
	<spring:message code="mensajeErrorNombreUnico" />
</c:set>

<c:set var="mensajeErrorStockMinimo">
	<spring:message code="mensajeErrorStockMinimo" />
</c:set>

<c:set var="mensajeErrorUsuarioInvalido">
	<spring:message code="mensajeErrorUsuarioInvalido" />
</c:set>

<c:set var="mensajeErrorStockGallinasNumero">
	<spring:message code="mensajeErrorStockGallinasNumero" />
</c:set>

<script>

var mensajesError = {
		mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}",
		mensajeErrorNombreUnico: "${mensajeErrorNombreUnico}",
		mensajeErrorStockMinimo: "${mensajeErrorStockMinimo}",
		mensajeErrorUsuarioInvalido: "${mensajeErrorUsuarioInvalido}",
		mensajeErrorStockGallinasNumero: "${mensajeErrorStockGallinasNumero}",
};

$('#botonNuevo').on('click', function (e) {
	e.preventDefault();
	var json = {
			"nombre" : document.getElementById("nombre").value,
			"usuarioId" : document.getElementById("usuarioId").value,
			"stockGallinas" : document.getElementById("stockGallinas").value
		};
	$.ajax({
		url : "gallinerosNuevoJson",
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
			window.location = "gallineros";
		}
	});
});

</script>

</body>
</html>