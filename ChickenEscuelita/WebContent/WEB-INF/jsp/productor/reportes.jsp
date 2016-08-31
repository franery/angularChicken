<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Reportes</title>
</head>
<body>
	<form:form action="nuevoMovimiento" mehtod="GET">
		<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
	</form:form>

	<form:form action="reportesFiltro" method="POST" commandName="filtro">
		<input type="date" name="fecha" placeholder="AAAA-MM-DD" />
		<input type="text" name="cantidad" placeholder="Cantidad" />
		<input type="submit" value="Filtrar" />
	</form:form>
	<div class="paraTabla">
		<table class="table table-striped table-hover header-fixed fija">
			<thead class="fija">
				<tr class="fija">
					<th class="fija">Fecha</th>
					<th class="fija">Cantidad</th>
					<th class="fija">Gallinero</th>
					<th class="fija">Deposito</th>
				</tr>
			</thead>
			<tbody class="fija">
				<c:if test="${!empty listaMovimientos}">
					<c:forEach items="${listaMovimientos}" var="movimiento">
						<tr class="fija">
							<td class="filterable-cell fija"><c:out
									value="${movimiento.fecha}"></c:out></td>
							<td class="filterable-cell fija"><c:out
									value="${movimiento.cantidad}"></c:out></td>
							<td class="filterable-cell fija"><c:out
									value="${movimiento.gallinero.nombre}"></c:out></td>
							<td class="filterable-cell fija"><c:out
									value="${movimiento.deposito.nombre}"></c:out></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>
	</div>

</body>
</html>