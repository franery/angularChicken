<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<title>Login</title>
	</head>
<body>

<form:form action="ingresar" method="post" commandName="usuario">
	<form:label path="nombreUsuario">
		<spring:message code="user"/>:
	</form:label>
	<form:input path="nombreUsuario"/>
	<br>
	<form:label path="contrasenia">
		<spring:message code="password"/>:
	</form:label>
	<form:input path="contrasenia" type="password"/>
	<br>
	<input type="submit" value= <spring:message code="submit"/> />
</form:form>



</body>
</html>