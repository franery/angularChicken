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

GALLINEROS


<form:form action="proveedoresNuevoContable" method="post" commandName="proveedor">
	<input type="hidden" name="flag" value="1"/>
	<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
</form:form>

<table id="tablita">
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
				<td>
					<form:form action="proveedoresBorrarContable" method="post" commandName="proveedor">
						<form:input path="id" type="hidden" value="${proveedor.getId()}"/>
						<input type="submit" value=<spring:message code="borrar" text="Borrar"/> />
					</form:form>
				</td>
				<td>
					<form:form action="proveedoresModificarContable" method="post" commandName="proveedor">
						<form:input path="id" type="hidden" value="${proveedor.getId()}"/>
						<form:input path="nombre" type="hidden" value="${proveedor.getNombre()}"/>
						<form:input path="direccion" type="hidden" value="${proveedor.getDireccion()}"/>
						<form:input path="mail" type="hidden" value="${proveedor.getMail()}"/>
						<form:input path="telefono" type="hidden" value="${proveedor.getTelefono()}"/>
						<input type="hidden" name="flag" value="0"/>
						<input type="submit" value=<spring:message code="modificar" text="Modificar"/> />
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

</body>
</html>