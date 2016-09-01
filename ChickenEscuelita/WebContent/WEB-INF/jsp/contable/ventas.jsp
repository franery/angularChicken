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
<title>Ventas</title>
</head>
<body>

<form:form action="ventasNuevoContable" method="post" commandName="venta">
	<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
</form:form>

<form:form action="ventasContable" method="post" commandName="filtro">
	<form:select path="proveedorId">
		<form:option value="0"><spring:message code="proveedor" text="Proveedor"/></form:option>
		<c:forEach items="${listaProveedores}" var="proveedor">
			<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
		</c:forEach>
	</form:select>
	<form:input type="date" path="fechaDesde" placeholder="FechaDesde" />
	<form:input type="date" path="fechaHasta" placeholder="FechaHasta" />
	<form:input type="text" path="cantidadDesde" placeholder="CantidadDesde" />
	<form:input type="text" path="cantidadHasta" placeholder="CantidadHasta" />
	<input type="submit" value=<spring:message code="filtrar" text="Filtrar"/>/>
</form:form>

<table id="tablita">
	<thead>
		<tr>
			<th>Proveedor</th>
			<th>Fecha</th>
			<th>Cantidad</th>
			<th>Precio</th>
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
</table>

</body>
</html>