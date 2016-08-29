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
<title>Proveedores</title>
</head>
<body>

	<!-- NavBar -->
	<c:set var="Title" value="Contable" scope="request" />
	<c:set var="Nombre" value="${usuarioActual.getNombre() }" scope="request" />
	<jsp:include page="../template/navbar.jsp"></jsp:include>

	<form:form action="principal" method="post" commandName="usuarioActual">
		<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
		<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
		<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
		<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
		<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
		<input type="submit" value="back"/>
	</form:form>

</body>
</html>