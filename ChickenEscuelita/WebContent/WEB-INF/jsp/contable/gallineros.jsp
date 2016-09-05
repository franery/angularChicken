<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallineros</title>
</head>
<body>


	<form:form action="gallinerosNuevoContable" method="post" commandName="gallinero">
		<input type="hidden" name="flag" value="1" />
		<input type="submit" value=<spring:message code="nuevo"/> />
	</form:form>

	<table id="tablita">
		<thead>
			<tr>
				<th><spring:message code="nombre"/></th>
				<th><spring:message code="nombreUsuario"/></th>
				<th><spring:message code="stock"/></th>
			</tr>
		</thead>
		<c:if test="${!empty listaGallineros}">
			<c:forEach items="${listaGallineros}" var="gallinero">
				<tr>
					<td><c:out value="${gallinero.getNombre()}"></c:out></td>
					<td><c:out value="${gallinero.getUsuarioNombre()}"></c:out></td>
					<td><c:out value="${gallinero.getStockGallinas()}"></c:out></td>
					<td><c:set var="mensajeConfirmacion" scope="request">
							<spring:message code="mensajeConfirmacion"></spring:message>
						</c:set> 
						<form:form onsubmit="return confirm('${mensajeConfirmacion} ${gallinero.getNombre()}?');" action="gallinerosBorrarContable" method="post" commandName="gallinero">
							<form:input path="id" type="hidden" value="${gallinero.getId()}" />
							<input type="submit"
								value=<spring:message code="borrar"/> />
						</form:form>
					</td>
					<td>
						<form:form action="gallinerosModificarContable" method="post" commandName="gallinero">
							<form:input path="id" type="hidden" 
								value="${gallinero.getId()}" />
							<form:input path="usuarioId" type="hidden"
								value="${gallinero.getUsuarioId()}" />
							<form:input path="nombre" type="hidden"
								value="${gallinero.getNombre()}" />
							<form:input path="usuarioNombre" type="hidden"
								value="${gallinero.getUsuarioNombre()}" />
							<form:input path="stockGallinas" type="hidden"
								value="${gallinero.getStockGallinas()}" />
							<input type="submit" 
								value=<spring:message code="modificar"/> />
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>