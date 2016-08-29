<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>

<!-- 	<ul> -->
<%-- 		<li><a href="/nuevoMovimiento.jsp"> <spring:message code="productor.nuevoMovimiento" /></a></li> --%>
<!-- 	</ul> -->	
	<ul>
		<li>
			<form:form id="reportesForm" action="reportes" method="post" commandName="usuarioActual">
				<form:input type="hidden" path="nombre" value="${usuarioActual.getNombre()}" />
				<form:input type="hidden" path="perfil" value="${usuarioActual.getPerfil()}" />
				<a href="javascript:{}" onClick="document.getElementById('reportesForm').submit(); return false;"><spring:message code="reportes"/></a>
			</form:form>
		</li>
		<li>
			<form:form id="nuevoMovimientoForm" action="nuevoMovimiento" method="post" commandName="usuarioActual">
				<form:input type="hidden" path="nombre" value="${usuarioActual.getNombre()}" />
				<form:input type="hidden" path="perfil" value="${usuarioActual.getPerfil()}" />
				<a href="javascript:{}" onClick="document.getElementById('nuevoMovimientoForm').submit(); return false;"><spring:message code="productor.nuevoMovimiento"/></a>
			</form:form>
		</li>
	</ul>
	

</body>
</html>
