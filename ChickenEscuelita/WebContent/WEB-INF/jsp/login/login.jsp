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

	<table align="center">
		<form:form action ="${pageContext.request.contextPath}/login" method="POST">
		<tr>
			<td> <spring:message code="usuario"/>: </td>
			<td> <input type ="text" id="username" name="username" /> </td>
		</tr>
		<tr>
			<td><spring:message code="contrasenia"/>: </td>
			<td> <input type ="password" id="password" name="password" /> </td>
		</tr>
		<tr>	
			<td align="center" colspan="2"><input type="submit" value=<spring:message code="ingresar" /> /></td>
		</tr>
		</form:form>
	</table>
</body>
</html>