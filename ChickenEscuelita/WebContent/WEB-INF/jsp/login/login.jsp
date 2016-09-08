<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Login</title>
</head>

<body>

	<c:set var="Title" value="LogIn" scope="request" />
	<c:set var="Nombre" value="" scope="request" />
	<jsp:include page="../template/navbarLogin.jsp"></jsp:include>

	<!-- 	<table align="center"> -->
	<%-- 		<form:form action="ingresar" method="post" commandName="usuario"> --%>
	<!-- 			<tr> -->
	<%-- 				<td><form:label path="nombreUsuario"><spring:message code="usuario" />:</form:label></td> --%>
	<%-- 				<td><form:input path="nombreUsuario" /></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<%-- 				<td><form:label path="contrasenia"><spring:message code="contrasenia" />:</form:label></td> --%>
	<%-- 				<td><form:input path="contrasenia" type="password" /></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td align="center" colspan="2"><input type="submit" value=<spring:message code="submit"/> /></td> -->
	<!-- 			</tr> -->
	<%-- 		</form:form> --%>
	<!-- 	</table> -->
	<table align="center">
		<form:form action ="j_spring_security_check" method="post">
			Usuario: <input type ="text" name="j_username" /> <br />
			Contraseña: <input type ="password" name="j_password" /> <br />
			<input type="submit" value="Entrar" />
		</form:form>
	</table>
</body>
</html>