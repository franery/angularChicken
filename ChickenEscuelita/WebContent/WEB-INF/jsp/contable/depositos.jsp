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
<title>Depositos</title>
</head>
<body>


<form:form action="depositosNuevoContable" method="post" commandName="deposito">
	<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
</form:form>

<table id="tablita">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Stock</th>
			<th>Stock Maximo</th>
		</tr>
	</thead>
	<c:if test="${!empty listaDepositos}">
		<c:forEach items="${listaDepositos}" var="deposito">
			<tr>
				<td><c:out value="${deposito.getNombre()}"></c:out></td>
				<td><c:out value="${deposito.getStockHuevos()}"></c:out></td>
				<td><c:out value="${deposito.getStockMaximo()}"></c:out></td>
				<td>
					<form:form action="depositosBorrarContable" method="post" commandName="deposito">
						<form:input path="id" type="hidden" value="${deposito.getId()}"/>
						<input type="submit" value=<spring:message code="borrar" text="Borrar"/> />
					</form:form>
				</td>
				<td>
					<form:form action="depositosModificarContable" method="post" commandName="deposito">
						<form:input path="id" type="hidden" value="${deposito.getId()}"/>
						<form:input path="nombre" type="hidden" value="${deposito.getNombre()}"/>
						<form:input path="stockHuevos" type="hidden" value="${deposito.getStockHuevos()}"/>
						<form:input path="stockMaximo" type="hidden" value="${deposito.getStockMaximo()}"/>
						<input type="submit" value=<spring:message code="modificar" text="Modificar"/> />
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</body>
</html>