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
	<h2> <spring:message code="tablaDepositosStock"/></h2>
	<form:form action="produccionContable" method="post" commandName="depositoFiltro">
	<form:select path="depositoId">
		<form:option value="0"><spring:message code="seleccionar" text="Seleccionar"/></form:option>
		<c:forEach items="${listaDepositosDropDown}" var="deposito">
			<form:option value="${deposito.getId()}"><c:out value="${deposito.getNombre()}"></c:out></form:option>
		</c:forEach>
	</form:select>
	<form:input type="text" path="depositoNombre" />
	<input type="submit" value=<spring:message code="filtrar" text="Filtrar"/> />
</form:form>
	
 
		<!-- <table id="" class="display" cellspacing="0" width="100%"> -->
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


		<!-- Tabla Productor|Produccion Total -->
	<div>
	<h2> <spring:message code="tablaTotalesProductor"/></h2>

	<form:form action="produccionContable" method="post" commandName="usuarioFiltro">
	<form:select path="id">
		<form:option value="0"><spring:message code="seleccionar" text="Seleccionar"/></form:option>
		<c:forEach items="${listaProductoresDropDown}" var="productor">
			<form:option value="${productor.getId()}"><c:out value="${productor.getNombre()}"></c:out></form:option>
		</c:forEach>
	</form:select>
	<form:label path="nombre"> <spring:message code="nombre"/> </form:label>
	<form:input type="text" path="nombre"  />
	<form:label path="apellido"> <spring:message code="apellido"/> </form:label>
	<form:input type="text" path="apellido" />
	
	<input type="submit" value=<spring:message code="filtrar" text="Filtrar"/> />
</form:form>




		<table id="tablita">
			<thead>
				<tr>
					<th><spring:message code="nombre" text="Productor"/></th>
					<th><spring:message code="apellido" text="Productor"/></th>
					<th><spring:message code="ProduccionTotal" text="Produccion Total"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty hashTotales}">
					<c:forEach items="${hashTotales}" var="hashProductor">
						<tr>
							<td><c:out value="${hashProductor.key.getNombre() }"></c:out></td>
							<td><c:out value="${hashProductor.key.getApellido() }"></c:out></td>
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
</body>
</html>