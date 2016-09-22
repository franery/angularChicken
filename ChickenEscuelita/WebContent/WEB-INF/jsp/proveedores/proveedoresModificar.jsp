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
<title><spring:message code="proveedoresModificar"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="proveedoresModificar"/></h1>

<form:form class="form-horizontal maxwid" id="formModificar" action="proveedoresProcesarModificar" method="post" commandName="proveedor">
	<form:input id="id" path="id" type="hidden" value="${proveedor.getId()}"/>
	<form:input id="borrado" path="borrado" type="hidden" value="${proveedor.getBorrado()}"/>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="nombre"><spring:message code="nombre"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="nombre" path="nombre" value="${proveedor.getNombre()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="direccion"><spring:message code="direccion"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="direccion" path="direccion" value="${proveedor.getDireccion()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="mail"><spring:message code="mail"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="mail" path="mail" value="${proveedor.getMail()}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="telefono"><spring:message code="telefono"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" id="telefono" path="telefono" value="${proveedor.getTelefono()}" required="required"/>
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

<p id="errores"></p>

<script>

var mensajesError = {
	mensajeErrorNombreVacio: "${mensajeErrorNombreVacio}",
	mensajeErrorNombreUnico: "${mensajeErrorNombreUnico}",
	mensajeErrorDireccionVacio: "${mensajeErrorDireccionVacio}",
	mensajeErrorMailVacio: "${mensajeErrorMailVacio}",
	mensajeErrorTelefonoVacio: "${mensajeErrorTelefonoVacio}",
};

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	var json = {
        			"id" : document.getElementById("id").value,
        			"nombre" : document.getElementById("nombre").value,
        			"direccion" : document.getElementById("direccion").value,
        			"mail" : document.getElementById("mail").value,
        			"telefono" : document.getElementById("telefono").value
        		};
        	$.ajax({
        		url : "proveedoresModificarJson",
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
        			window.location = "proveedores";
        		}
        	});
        }
    });
});

</script>

</body>
</html>