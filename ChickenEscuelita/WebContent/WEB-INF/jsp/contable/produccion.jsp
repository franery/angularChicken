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
<title>Produccion</title>
</head>
<body>

		<!-- Tabla Depositos|Cant Huevos -->
	<div>
	
	<form:form action="produccionContable" method="post" commandName="filtro">
	<form:select path="depositoId">
		<form:option value="0"><spring:message code="seleccionar" text="Seleccionar"/></form:option>
		<c:forEach items="${listaDepositosDropDown}" var="deposito">
			<form:option value="${deposito.getId()}"><c:out value="${deposito.getNombre()}"></c:out></form:option>
		</c:forEach>
	</form:select>
	<form:input type="text" path="depositoNombre" />
	<input type="submit" value=<spring:message code="filtrar" text="Filtrar"/> />
</form:form>
	
		<table id="tablita">
			<thead>
				<tr>
					<th><spring:message code="deposito" text="Deposito"/></th>
					<th><spring:message code="cantidadHuevos" text="Cantidad de Huevos"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaDepositos}">
					<c:forEach items="${listaDepositos}" var="depositoVar">
						<tr>
							<td><c:out value="${depositoVar.getNombre() }"></c:out></td>
							<td><c:out value="${depositoVar.getStockHuevos() }"></c:out></td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaDepositos}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>

<br>
<br>
<br>

		<!-- Tabla Productor|Produccion Total -->
	<div>
	<form:form action="filtroProductorTotalProduccion" method="POST" commandName="filtroProductorTotal">
		<input type="text" name="nombre" placeholder="<spring:message code="productor" text="Nombre Productor"/>" />
		<input type="submit" value="<spring:message code="filtrar" text="Filtrar"/>" />
	</form:form>
		<table id="tablita">
			<thead>
				<tr>
					<th><spring:message code="productor" text="Productor"/></th>
					<th><spring:message code="ProduccionTotal" text="Produccion Total"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty hashTotales}">
					<c:forEach items="${hashTotales}" var="hashProductor">
						<tr>
							<td><c:out value="${hashProductor.key.getNombre() }"></c:out></td>
							<td><c:out value="${hashProductor.value }"></c:out></td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty hashTotales}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>


PRODUCCION

</body>
</html>