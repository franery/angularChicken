<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
<body>

	<ul>
		<!-- Menu Admin -->
		<!-- usuarios link -->
		<li><form:form action="usuarios" method="post"
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
				<input type="submit" value=<spring:message code="usuarios"/> />
			</form:form></li>

		<!-- parametros link -->
		<li><form:form action="parametros" method="post"
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
				<input type="submit" value=<spring:message code="parametros"/> />
			</form:form></li>

		<!-- Menu productor -->
<%-- <li>	<jsp:include page="../productor/menuProductor.jsp"></jsp:include>
</li>
 --%>		<li><a href="../productor/reportes.jsp"> <spring:message
					code="productor.reportes" />
		</a></li>
		<li><a href="../productor/nuevoMovimiento.jsp"> <spring:message
					code="productor.nuevoMovimiento" />
		</a></li>

		<!-- Menu contable -->
		<li><a href="../contable/proveedores.jsp"> <spring:message
					code="proveedores" />
		</a></li>
		<li><a href="../contable/gallineros.jsp"> <spring:message
					code="gallineros" />
		</a></li>
		<li><a href="../contable/depositos.jsp"> <spring:message
					code="depositos" />
		</a></li>
		<li><a href="../contable/ventas.jsp"> <spring:message
					code="ventas" />
		</a></li>
		<li><a href="../contable/produccion.jsp"> <spring:message
					code="produccion" />
		</a></li>
	</ul>

</body>
</html>
