<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../template/importacion.jsp"></jsp:include>

<style type="text/css">
body {
	padding-top: 70px;
}
</style>

<title><spring:message code="nombreApp" /></title>

</head>
<body>


	<!-- NavBar -->
	<%-- 	<c:set var="Title" scope="request" value="${usuarioActual.getListaPerfiles().get(0).getNombre()}"/> --%>
	<c:set var="Nombre" value="${usuarioActual.getNombre() }"
		scope="request" />
	<jsp:include page="../template/cabecera.jsp"></jsp:include>

	
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div>
					<jsp:include page="../template/menu.jsp"></jsp:include>
				</div>
			</div>
			<div class="col-sm-9">
				<jsp:include page="../${pageToLoad}.jsp"></jsp:include>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablita').DataTable();
		});
	</script>
</body>
</html>