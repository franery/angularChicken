<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
</head>
<body>
	<!-- Menu Admin -->
	<!-- usuarios link -->
	<form:form action="usuarios" method="post" commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="usuarios"/> />
	</form:form>

	<!-- parametros link -->
	<form:form action="parametros" method="post"
		commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="parametros"/> />
	</form:form>

	<!-- Menu productor -->


	<form:form action="proveedoresContable" method="post"
		commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="proveedores"/> />
	</form:form>


	<form:form action="gallinerosContable" method="post"
		commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="gallineros"/> />
	</form:form>

	<form:form action="depositosContable" method="post"
		commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="depositos"/> />
	</form:form>

	<form:form action="ventasContable" method="post"
		commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="ventas"/> />
	</form:form>

	<form:form action="produccionContable" method="post"
		commandName="usuarioActual">
		<form:input path="nombre" type="hidden"
			value="${usuarioActual.getNombre()}" />
		<form:input path="apellido" type="hidden"
			value="${usuarioActual.getApellido()}" />
		<form:input path="nombreUsuario" type="hidden"
			value="${usuarioActual.getNombreUsuario()}" />
		<form:input path="contrasenia" type="hidden"
			value="${usuarioActual.getContrasenia()}" />
		<form:input path="perfil" type="hidden"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="produccion"/> />
	</form:form>


	<form:form action="reportes" method="post" commandName="usuarioActual">
		<form:input type="hidden" path="nombre"
			value="${usuarioActual.getNombre()}" />
		<form:input type="hidden" path="perfil"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="productor.reportes"/> />
	</form:form>

	<form:form action="nuevoMovimiento" method="post"
		commandName="usuarioActual">
		<form:input type="hidden" path="nombre"
			value="${usuarioActual.getNombre()}" />
		<form:input type="hidden" path="perfil"
			value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit"
			value=<spring:message code="productor.nuevoMovimiento"/> />
	</form:form>

</body>
</html>
