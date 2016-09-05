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


<form:form action="depositosNuevoContable" method="post" commandName="deposito">
	<input type="submit" value=<spring:message code="nuevo"/> />
</form:form>

<table id="tablita">
	<thead>
		<tr>
			<th><spring:message code="nombre"/></th>
			<th><spring:message code="stock"/></th>
			<th><spring:message code="stockMax"/></th>
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
				<td><c:set var="mensajeConfirmacion" scope="request">
						<spring:message code="mensajeConfirmacion"></spring:message>
					</c:set> 
					<form:form onsubmit="return confirm('${mensajeConfirmacion} ${deposito.getNombre()}?');" action="depositosBorrarContable" method="post" commandName="deposito">
						<form:input path="id" type="hidden" value="${deposito.getId()}"/>
						<input type="submit" value=<spring:message code="borrar"/> />
					</form:form>
				</td>
				<td>
					<form:form action="depositosModificarContable" method="post" commandName="deposito">
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
</table>

</body>
</html>