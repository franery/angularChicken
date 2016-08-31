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
<title>Proveedores</title>
</head>
<body>

	<form:form action="crearNuevoMovimiento" method="POST"
		commandName="movimiento">
		<table>
			<tr>
				<td><form:label path="gallineroId">
						<spring:message code="gallinero" text="gallinero" />:</form:label></td>
				<td><form:select path="gallineroId">
						<form:option value="0">
							<spring:message code="seleccioneGallinero"
								text="Seleccione gallinero" />
						</form:option>
						<c:forEach items="${listaGallineros}" var="gallineroVar">
							<form:option value="${gallineroVar.getId()}">
								<c:out value="${gallineroVar.getNombre()}"></c:out>
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="depositoId">
						<spring:message code="deposito" text="deposito" />:</form:label></td>
				<td><form:select path="depositoId">
						<form:option value="0">
							<spring:message code="seleccioneDeposito"
								text="Seleccione deposito" />
						</form:option>
						<c:forEach items="${listaDepositos}" var="depositoVar">
							<form:option value="${depositoVar.getId()}">
								<c:out value="${depositoVar.getNombre()}"></c:out>
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="cantidad">
						<spring:message code="cantidad" text="cantidad" />:</form:label></td>
				<td><form:input path="cantidad" /></td>
			</tr>
			<tr>
				<td><form:label path="fecha">
						<spring:message code="fecha" text="fecha" />:</form:label></td>
				<td><form:input path="fecha" type="date" /></td>
			</tr>
		</table>
		<input type="submit" value=<spring:message code="guardar"/> />

	</form:form>
</body>
</html>