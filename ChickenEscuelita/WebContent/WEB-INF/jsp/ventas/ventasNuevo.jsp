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
<title><spring:message code="ventaNuevo"/></title>
</head>
<body>

<h1><spring:message code="venta"/></h1>

<form:form action="ventasProcesarNuevoContable" method="post" commandName="venta">
	<form:input path="id" type="hidden" value="${venta.getId()}"/>
	<form:input path="usuarioId" type="hidden" value="${usuarioActual.getId()}"/>
<%-- 	<form:input path="borrado" type="hidden" value="0"/>
 --%>
	<table>
		<tr>
			<td><form:label path="proveedorId"><spring:message code="proveedor"/>:</form:label></td>
			<td>
				<form:select path="proveedorId" required="required">
					<form:option value=""><spring:message code="seleccionar" /></form:option>
						<c:forEach items="${listaProveedores}" var="proveedor">
							<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
						</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label path="fecha"><spring:message code="fecha"/>:</form:label></td>
			<td><form:input type="date" path="fecha" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="cantidad"><spring:message code="cantidad"/>:</form:label></td>
			<td><form:input path="cantidad" required="required"/></td>
		</tr>
		<tr>
			<td><form:label path="precio"><spring:message code="precio"/>:</form:label></td>
			<td><form:input path="precio" required="required"/></td>
		</tr>
	</table>
	<input type="submit" value=<spring:message code="guardar"/> />
</form:form>

</body>
</html>