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
<title><spring:message code="depositoNuevo"/></title>
</head>
<body>

<h1><spring:message code="depositoNuevo"/></h1>

<form:form action="depositosModificarCrearNuevoContable" method="post" commandName="deposito">
	<form:input path="id" type="hidden" value="${deposito.getId()}"/>
	<form:input path="stockHuevos" type="hidden" value="${deposito.getStockHuevos()}"/>
	<table>
		<tr>
			<td><form:label path="nombre"><spring:message code="nombre" text="Nombre"/>:</form:label></td>
			<td><form:input path="nombre" value="${deposito.getNombre()}" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="stockMaximo"><spring:message code="stockMaximo" text="Stock Maximo"/>:</form:label></td>
			<td><form:input path="stockMaximo" value="${deposito.getStockMaximo()}" required="required"/></td>
		</tr>
	</table>
	<input type="hidden" name="flag" value="${flag}"/>
	<input type="submit" value=<spring:message code="guardar"/> />
</form:form>

</body>
</html>