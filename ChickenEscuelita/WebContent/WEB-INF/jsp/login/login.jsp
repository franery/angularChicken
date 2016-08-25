<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title>Login</title>
	</head>
<body>

<form:form action="ingresar" method="post" commandName="usuario">
	<form:label path="nombreUsuario">Usuario: </form:label>
	<form:input path="nombreUsuario"/>
	<br>
	<form:label path="contrasenia">Contrasenia: </form:label>
	<form:input path="contrasenia"/>
	<br>
	<input type="submit" value="Ingresar" />
</form:form>

</body>
</html>