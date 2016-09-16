<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="movimientos"/></title>
</head>
<body>
<h1 class="page-header"><spring:message code="movimientos"/></h1>

	<form:form action="movimientosNuevo">
		<input type="submit" value=<spring:message code="nuevo"/> />
	</form:form>

	<form:form action="movimientosFiltro" method="POST" commandName="filtro" onclick="filtrar()">
		<table>
			<tr>
				<td> <form:label path="fechaDesde"><spring:message code="fechaDesde"/></form:label> </td>
				<td> <form:input path="fechaDesde" type="date" /> </td>
			</tr>
			<tr>
				<td> <form:label path="fechaHasta"><spring:message code="fechaHasta"/></form:label> </td>
				<td> <form:input path="fechaHasta" type="date" /> </td>
			</tr>
			<tr> 
				<td> <form:label path="cantidadDesde"><spring:message code="cantidadDesde"/></form:label> </td>
				<td> <form:input path="cantidadDesde" type="text" /> </td>
			</tr>
			<tr> 
				<td> <form:label path="cantidadHasta"><spring:message code="cantidadHasta"/></form:label> </td>
				<td> <form:input path="cantidadHasta" type="text" /> </td>
			</tr>
			<tr> <td> <input type="submit" value=<spring:message code="filtrar"/> /> </td> </tr>
		</table>
	</form:form>
	
	<table id="tablita" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th><spring:message code="fecha"/></th>
				<th><spring:message code="cantidad"/></th>
				<th><spring:message code="gallinero"/></th>
				<th><spring:message code="deposito"/></th>
            </tr>
        </thead>
    </table>
	
<!-- 	<div class="paraTabla"> -->
<!-- 		<table id="tablita" class="display order-column" cellspacing="0" width="100%"> -->
<!-- 			<thead class="fija"> -->
<!-- 				<tr class="fija"> -->
<%-- 					<th class="fija"><spring:message code="fecha"/></th> --%>
<%-- 					<th class="fija"><spring:message code="cantidad"/></th> --%>
<%-- 					<th class="fija"><spring:message code="gallinero"/></th> --%>
<%-- 					<th class="fija"><spring:message code="deposito"/></th> --%>
<!-- 				</tr> -->
<!-- 			</thead> -->
<!-- 			<tbody class="fija"> -->
<%-- 				<c:if test="${!empty listaMovimientos}"> --%>
<%-- 					<c:forEach items="${listaMovimientos}" var="movimiento"> --%>
<!-- 						<tr class="fija"> -->
<%-- 							<td class="filterable-cell fija"><c:out --%>
<%-- 									value="${movimiento.fecha}"></c:out></td> --%>
<%-- 							<td class="filterable-cell fija"><c:out --%>
<%-- 									value="${movimiento.cantidad}"></c:out></td> --%>
<%-- 							<td class="filterable-cell fija"><c:out --%>
<%-- 									value="${movimiento.getGallineroNombre()}"></c:out></td> --%>
<%-- 							<td class="filterable-cell fija"><c:out --%>
<%-- 									value="${movimiento.getDepositoNombre()}"></c:out></td> --%>
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<%-- 				</c:if> --%>
<!-- 			</tbody> -->

<!-- 		</table> -->
<!-- 	</div> -->
<script>
$(document).ready(function(){
	$('#tablita').DataTable( {
		ajax: "movimientosJson",
	    columns: [
	              { data: "fecha" },
	              { data: "cantidad" },
	              { data: "gallinero.nombre" },
	              { data: "deposito.nombre" }
	              ]
	});
});
</script>
</body>
</html>