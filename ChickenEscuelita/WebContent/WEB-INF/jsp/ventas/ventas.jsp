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

<title><spring:message code="ventas"/></title>
</head>
<body>
<h1 class="page-header"><spring:message code="ventas"/></h1>
<form:form action="ventasNuevo" method="post" commandName="venta">
	<input type="submit" value=<spring:message code="nuevo"/> />
</form:form>

<form:form action="ventas" method="post" commandName="filtro">
		<table id="tablita" class="display order-column" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th><spring:message code="filtros"/></th>
			</tr>
		</thead>
		<tr>
			<td><form:label path="proveedorId"><spring:message code="proveedor"/>:</form:label></td>
			<td>
				<form:select path="proveedorId">
					<form:option value="0"><spring:message code="proveedor"/></form:option>
						<c:forEach items="${listaProveedores}" var="proveedor">
					<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
				</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label path="fechaDesde"><spring:message code="fechaDesde"/>:</form:label></td>
			<td><form:input type="date" path="fechaDesde" /></td>
			<td><form:label path="fechaHasta"><spring:message code="fechaHasta"/>:</form:label></td>
			<td><form:input type="date" path="fechaHasta" /></td>
		</tr>
		<tr>
			<td><form:label path="cantidadDesde"><spring:message code="cantidadDesde"/>:</form:label></td>
			<td><form:input type="text" path="cantidadDesde" /></td>
			<td><form:label path="cantidadHasta"><spring:message code="cantidadHasta"/>:</form:label></td>
			<td><form:input type="text" path="cantidadHasta" /></td>
		</tr>
	</table>
	<input type="submit" value=<spring:message code="filtrar"/>>
</form:form>

		<table id="tablita" class="display order-column" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th><spring:message code="proveedor"/></th>
			<th><spring:message code="fecha"/></th>
			<th><spring:message code="cantidad"/></th>
			<th><spring:message code="precio"/></th>
		</tr>
	</thead>
	<c:if test="${!empty listaVentas}">
		<c:forEach items="${listaVentas}" var="venta">
			<tr>
				<td><c:out value="${venta.getProveedorNombre()}"></c:out></td>
				<td><c:out value="${venta.getFecha()}"></c:out></td>
				<td><c:out value="${venta.getCantidad()}"></c:out></td>
				<td><c:out value="${venta.getPrecio()}"></c:out></td>
			</tr>
		</c:forEach>
	</c:if>
				<c:if test="${empty listaVentas}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
</table>

</body>
</html>