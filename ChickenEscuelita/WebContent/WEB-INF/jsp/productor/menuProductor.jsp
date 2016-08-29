<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
<body>

	<ul>
<%-- 		<li><a href="/reportes.jsp"> <spring:message --%>
<%-- 					code="productor.reportes" /> --%>
<!-- 		</a></li> -->
		<li><a href="/nuevoMovimiento.jsp"> <spring:message
					code="productor.nuevoMovimiento" />
		</a></li>
	</ul>

	<form:form id="reportesForm" action="reportes" method="post" commandName="usuario">
		<form:input type="hidden" path="nombreUsuario"
			value="${usuarioActual.getNombre()}" />
		<form:input type="hidden" path="perfil"
			value="${usuarioActual.getPerfil()}" />
<!-- 		<input type="submit" value=<spring:message code="reportes"/> /> -->
	<a href="javascript:{}" onClick="document.getElementById('reportesForm').submit(); return false;"><spring:message code="reportes"/></a>
	</form:form>
	
	

</body>
</html>
