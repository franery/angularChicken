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
<title><spring:message code="ventaNuevo"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="venta"/></h1>

<form:form class="form-horizontal maxwid" id="formNuevo" method="post" commandName="venta">
	<form:input id="usuarioId" path="usuarioId" type="hidden" value="${usuarioActual.getId()}"/>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="proveedorId"><spring:message code="proveedor"/>:</form:label>
		<div class="col-sm-10">
			<form:select id="proveedorId" class="form-control" style="width:auto;" path="proveedorId" required="required">
				<form:option value=""><spring:message code="seleccionar" /></form:option>
					<c:forEach items="${listaProveedores}" var="proveedor">
						<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
					</c:forEach>
			</form:select>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="fecha"><spring:message code="fecha"/>:</form:label>
		<div class="col-sm-10">
			<form:input id="fecha" class="form-control" type="date" path="fecha" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="cantidad"><spring:message code="cantidad"/>:</form:label>
		<div class="col-sm-10">
			<form:input id="cantidad" class="form-control" path="cantidad" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="precio"><spring:message code="precio"/>:</form:label>
		<div class="col-sm-10">
			<form:input id="precio" class="form-control" path="precio" required="required"/>
		</div>
	</div>
</form:form>

<c:set var="mensajeErrorVentaCantidad">
	<spring:message code="mensajeErrorVentaCantidad" />
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

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");},
    ready: function() {$("#errores").style.display("none");}
});

var mensajesError = {
	mensajeErrorVentaCantidad: "${mensajeErrorVentaCantidad}"
};

$('#botonNuevo').on('click', function (e) {
	e.preventDefault();
	var json = {
			"usuarioId" : document.getElementById("usuarioId").value,
			"proveedorId" : document.getElementById("proveedorId").value,
			"fecha" : document.getElementById("fecha").value,
			"cantidad" : document.getElementById("cantidad").value,
			"precio" : document.getElementById("precio").value
		};
	$.ajax({
		url : "ventasNuevoJson",
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
			window.location = "ventas";
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