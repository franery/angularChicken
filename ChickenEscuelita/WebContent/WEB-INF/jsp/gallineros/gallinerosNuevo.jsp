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

<form:form action="gallinerosProcesarNuevo" method="post" commandName="gallinero">
	<form:input path="id" type="hidden" value="${gallinero.getId()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre"/>:</form:label></td>
			<td><form:input id="nombre" path="nombre" value="${gallinero.getNombre()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="usuarioId"><spring:message code="usuario"/>:</form:label></td>
			<td>
				<form:select id="usuarioId" path="usuarioId" required="required">
					<form:option value=""><spring:message code="seleccionar" /></form:option>
						<c:forEach items="${listaUsuarios}" var="usuario">
							<form:option value="${usuario.getId()}">
								<c:out value="${usuario.getNombre()}"></c:out>
							</form:option>
						</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label path="stockGallinas"><spring:message code="stock"/>:</form:label></td>
			<td><form:input id="stockGallinas" path="stockGallinas"  value="${gallinero.getStockGallinas()}" required="required" /></td>
		</tr>
		
	</table>
	<input id="botonNuevo" type="button" value=<spring:message code="guardar"/> />
</form:form>

<p id="errores"></p>

<script>

var mensajesError = {
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