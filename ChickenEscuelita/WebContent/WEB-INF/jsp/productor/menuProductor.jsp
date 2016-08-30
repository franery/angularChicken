<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
</head>
<body>

	<form:form id="reportesForm" action="reportes" method="post" commandName="usuarioActual">
		<form:input type="hidden" path="nombre" value="${usuarioActual.getNombre()}" />
		<form:input type="hidden" path="perfil" value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit" value=<spring:message code="productor.reportes"/> />
	</form:form>

	<form:form id="nuevoMovimientoForm" action="nuevoMovimiento" method="post" commandName="usuarioActual">
		<form:input type="hidden" path="nombre" value="${usuarioActual.getNombre()}" />
		<form:input type="hidden" path="perfil" value="${usuarioActual.getPerfil()}" />
		<input class="menu" type="submit" value=<spring:message code="productor.nuevoMovimiento"/> />
	</form:form>
<%-- 		<a href="reportes" class="menu"><spring:message code="productor.reportes"/></a> --%>
<%-- 		<a href="reportes" class="menu"><spring:message code="productor.nuevoMovimiento"/></a> --%>
</body>
</html>
