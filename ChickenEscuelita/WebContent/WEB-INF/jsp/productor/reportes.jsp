<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Fecha</th>
				<th>Cantidad</th>
				<th>Gallinero</th>
				<th>Deposito</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty listaMovimientos}">
				<c:forEach items="${listaMovimientos}" var="movimiento">
					<tr>
						<td><c:out value="${movimiento.fecha}"></c:out></td>
						<td><c:out value="${movimiento.cantidad}"></c:out></td>
						<td><c:out value="${movimiento.gallinero.nombre}"></c:out></td>
						<td><c:out value="${movimiento.deposito.nombre}"></c:out></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>

	</table>

</body>
</html>