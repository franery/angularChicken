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
<title>Nueva Venta</title>
</head>
<body>

<h1>Venta</h1>

<form:form action="ventasCrearNuevoContable" method="post" commandName="venta">
	<form:input path="id" type="hidden" value="${venta.getId()}"/>
	<form:input path="usuarioId" type="hidden" value="${usuarioActual.getId()}"/>
	<table>
		<tr>
			<td><form:label path="proveedorId"><spring:message code="proveedor" text="Proveedor"/>:</form:label></td>
			<td>
				<form:select path="proveedorId">
					<form:option value="0"><spring:message code="seleccionar" /></form:option>
						<c:forEach items="${listaProveedores}" var="proveedor">
							<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
						</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label path="fecha"><spring:message code="fecha" text="Fecha"/>:</form:label></td>
			<td><form:input type="date" path="fecha"/></td>
		</tr>
		<tr>
			<td><form:label path="cantidad"><spring:message code="cantidad" text="Cantidad"/>:</form:label></td>
			<td><form:input path="cantidad"/></td>
		</tr>
		<tr>
			<td><form:label path="precio"><spring:message code="precio" text="Precio"/>:</form:label></td>
			<td><form:input path="precio"/></td>
		</tr>
	</table>
	<input type="submit" value=<spring:message code="guardar"/> />
</form:form>

</body>
</html>