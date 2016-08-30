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
<title>Nuevo Proveedor</title>
</head>
<body>

<form:form action="proveedoresModificarCrearNuevoContable" method="post" commandName="proveedor">
	<form:input path="id" type="hidden" value="${proveedor.getId()}"/>
	
	<form:label path="nombre"><spring:message code="nombre" text="Nombre"/>:</form:label>
	<form:input path="nombre" value="${proveedor.getNombre()}"/>
	<br>
	<form:label path="direccion"><spring:message code="direccion" text="Direccion"/>:</form:label>
	<form:input path="direccion" value="${proveedor.getDireccion()}"/>
	<br>
	<form:label path="mail"><spring:message code="mail" text="Mail"/>:</form:label>
	<form:input path="mail" value="${proveedor.getMail()}"/>
	<br>
	<form:label path="telefono"><spring:message code="telefono" text="Telefono"/>:</form:label>
	<form:input path="telefono" value="${proveedor.getTelefono()}"/>
	<br>
	<input type="hidden" name="flag" value="${flag}"/>
	<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
</form:form>

</body>
</html>