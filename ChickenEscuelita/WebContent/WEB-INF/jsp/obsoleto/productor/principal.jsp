<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productor</title>
</head>
<body>
	<!-- NavBar -->
	<c:set var="Title" scope="request">
		<spring:message code="${usuarioActual.getPerfil().toString() }" />
	</c:set>
	<c:set var="Nombre" value="${usuarioActual.getNombre() }"
		scope="request" />
	<jsp:include page="../../template/navbar.jsp"></jsp:include>
	<div class="alineacion">
		<!-- Menu -->
		<jsp:include page="../productor/menuProductor.jsp"></jsp:include>
	</div>
	<div class="pantalla">
		<jsp:include page="../${pageToLoad}.jsp"></jsp:include>
	</div>
</body>
</html>