<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contable</title>
</head>
<body>

	<!-- NavBar -->
	<c:set var="Title" value="Contable" scope="request" />
	<c:set var="Nombre" value="${usuarioActual.getNombre() }" scope="request" />
	<jsp:include page="../template/navbar.jsp"></jsp:include>
	
	<div class="alineacion">
		<!-- Menu -->
		<jsp:include page="../contable/menuContable.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="../${pageToLoad}.jsp"></jsp:include>
	</div>
	
</body>
</html>