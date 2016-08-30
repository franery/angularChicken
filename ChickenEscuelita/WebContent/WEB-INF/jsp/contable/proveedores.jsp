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

<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Direccion</th>
			<th>Mail</th>
			<th>Telefono</th>
		</tr>
	</thead>
	<c:if test="${!empty listaProveedores}">
		<c:forEach items="${listaProveedores}" var="proveedor">
			<tr>
				<td><c:out value="${proveedor.getNombre()}"></c:out></td>
				<td><c:out value="${proveedor.getDireccion()}"></c:out></td>
				<td><c:out value="${proveedor.getMail()}"></c:out></td>
				<td><c:out value="${proveedor.getTelefono()}"></c:out></td>
				<form:form action="proveedoresBorrarContable" method="post" commandName="proveedorBorrar">
				<form:input path="id" type="hidden" value="${proveedor.getId()}"/>
				<input type="submit" value=<spring:message code="borrar" text="Borrar"/> />
				</form:form>
			</tr>
		</c:forEach>
	</c:if>
</table>

</body>
</html>