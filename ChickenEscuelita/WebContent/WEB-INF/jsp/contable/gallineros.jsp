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


	<form:form action="gallinerosNuevoContable" method="post"
		commandName="gallinero">
		<input type="hidden" name="flag" value="1" />
		<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
	</form:form>

	<table id="tablita">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Nombre del usuario</th>
				<th>Stock</th>
			</tr>
		</thead>
		<c:if test="${!empty listaGallineros}">
			<c:forEach items="${listaGallineros}" var="gallinero">
				<tr>
					<td><c:out value="${gallinero.getNombre()}"></c:out></td>
					<td><c:out value="${gallinero.getUsuarioNombre()}"></c:out></td>
					<td><c:out value="${gallinero.getStockGallinas()}"></c:out></td>
					<td>
						<form:form action="gallinerosBorrarContable" method="post"
							commandName="gallinero">
							<form:input path="id" type="hidden" value="${gallinero.getId()}" />
							<input type="submit"
								value=<spring:message code="borrar" text="Borrar"/> />
						</form:form>
					</td>
					<td>
						<form:form action="gallinerosModificarContable"
							method="post" commandName="gallinero">
							<form:input path="id" type="hidden" value="${gallinero.getId()}" />
							<form:input path="nombre" type="hidden"
								value="${gallinero.getNombre()}" />
							<form:input path="usuarioNombre" type="hidden"
								value="${gallinero.getUsuarioNombre()}" />
							<form:input path="stockGallinas" type="hidden"
								value="${gallinero.getStockGallinas()}" />
							<input type="submit"
								value=<spring:message code="modificar" text="Modificar"/> />
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>