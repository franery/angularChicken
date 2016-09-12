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
<title><spring:message code="gallinerosModificar"/></title>
</head>
<body>

<h1><spring:message code="gallinerosModificar"/></h1>

<form:form id="formModificar" action="gallinerosProcesarModificarContable" method="post" commandName="gallinero">
	<form:input path="id" type="hidden" value="${gallinero.getId()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre"/>:</form:label></td>
			<td><form:input path="nombre" value="${gallinero.getNombre()}" /></td>
		</tr>
		<tr>
			<td><form:label path="usuarioId"><spring:message code="usuario"/>:</form:label></td>
			<td>
				<form:select path="usuarioId" required="required">
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
			<td><form:input path="stockGallinas"  value="${gallinero.getStockGallinas()}" required="required"/></td>
		</tr>
	</table>
	<input id="botonGuardar" type="submit" value=<spring:message code="guardar"/> />
</form:form>
	
	<c:set var="value">
		<spring:message code="mensajeModificar" />
	</c:set>
	<input id="mensajeModificar" type="hidden" value="${value}" />
	
<script>

$('#botonGuardar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeModificar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
            $('#formModificar').submit();
        }
    });
});

</script>

</body>
</html>