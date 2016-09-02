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
<title>Nuevo Gallinero</title>
</head>
<body>

<h1>Gallinero</h1>

<form:form action="gallinerosModificarCrearNuevoContable" method="post" commandName="gallinero">
	<form:input path="id" type="hidden" value="${gallinero.getId()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre" text="Nombre"/>:</form:label></td>
			<td><form:input path="nombre" value="${gallinero.getNombre()}"/></td>
		</tr>
		<tr>
			<td><form:label path="direccion"><spring:message code="direccion" text="Direccion"/>:</form:label></td>
			<td><form:input path="direccion" value="${gallinero.getDireccion()}"/></td>
		</tr>
		<tr>
			<td><form:label path="mail"><spring:message code="mail" text="Mail"/>:</form:label></td>
			<td><form:input path="mail" value="${gallinero.getMail()}"/></td>
		</tr>
		<tr>
			<td><form:label path="telefono"><spring:message code="telefono" text="Telefono"/>:</form:label></td>
			<td><form:input path="telefono" value="${gallinero.getTelefono()}"/></td>
		</tr>
	</table>
	<input type="hidden" name="flag" value="${flag}"/>
	<input type="submit" value=<spring:message code="guardar"/> />
</form:form>

</body>
</html>