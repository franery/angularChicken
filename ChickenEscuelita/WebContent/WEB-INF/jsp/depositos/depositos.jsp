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

<title><spring:message code="depositos"/></title>
</head>
<body>
	
	<h1>
		<spring:message code="depositos" />
	</h1>
	

<form:form action="depositosNuevo" method="post" commandName="deposito">
	<input type="submit" value=<spring:message code="nuevo"/> />
</form:form>

		<table id="tablita" class="display order-column" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th><spring:message code="nombre"/></th>
			<th><spring:message code="stock"/></th>
			<th><spring:message code="stockMax"/></th>
			<th></th>
				<th></th>
		</tr>
	</thead>
	<c:if test="${!empty listaDepositos}">
		<c:forEach items="${listaDepositos}" var="deposito">
				<c:choose>
					<c:when
						test="${deposito.getStockHuevos() > deposito.getStockMaximo()}">
						<tr class="depositoRojo">
					</c:when>
					<c:otherwise>
						<tr>
					</c:otherwise>
				</c:choose>

				<td><c:out value="${deposito.getNombre()}"></c:out></td>
				<td><c:out value="${deposito.getStockHuevos()}"></c:out></td>
				<td><c:out value="${deposito.getStockMaximo()}"></c:out></td>
				<td>
					<form:form id="form${deposito.getId()}" action="depositosBorrar" method="post" commandName="deposito">
						<form:input path="id" type="hidden" value="${deposito.getId()}"/>
						<input id="boton${deposito.getId()}" type="button" value=<spring:message code="borrar"/> />
					</form:form>
				</td>
				<td>
					<form:form action="depositosModificar" method="post" commandName="deposito">
						<form:input path="id" type="hidden" value="${deposito.getId()}"/>
						<form:input path="nombre" type="hidden" value="${deposito.getNombre()}"/>
						<form:input path="stockHuevos" type="hidden" value="${deposito.getStockHuevos()}"/>
						<form:input path="stockMaximo" type="hidden" value="${deposito.getStockMaximo()}"/>
						<input type="submit" value=<spring:message code="modificar"/> />
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty listaDepositos}">
				<tr>
					<td colspan="5"><spring:message code="noHayDatos" /></td>
				</tr>
			</c:if>
</table>

	<c:set var="value">
		<spring:message code="mensajeBorrar" />
	</c:set>
	<input id="mensajeBorrar" type="hidden" value="${value}" />

<script>

<c:forEach items="${listaDepositos}" var="deposito">
$('#boton' + '${deposito.id}').on('click', function (e) {
	var mensaje = document.getElementById("mensajeBorrar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	$('#form' + '${deposito.id}').submit();
        }
    });
});
</c:forEach>

</script>

</body>
</html>