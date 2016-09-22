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

<title><spring:message code="produccion"/></title>

<style>
th {
	text-align: center;
}

</style>

</head>
<body>

		<!-- Tabla Depositos|Cant Huevos -->
<div>
	<h2 class="page-header"> <spring:message code="tablaDepositosStock"/></h2>
	<h3><spring:message code="filtros"/></h3>
	<form:form class="form-horizontal form-inline" action="produccion" method="post" commandName="depositoFiltro">
	 	<div class="form-group">
		<form:select class="form-control" style="width:auto;" path="depositoId">
			<form:option value="0"><spring:message code="seleccionar"/></form:option>
			<c:forEach items="${listaDepositosDropDown}" var="deposito">
				<form:option value="${deposito.getId()}"><c:out value="${deposito.getNombre()}"></c:out></form:option>
			</c:forEach>
		</form:select>
		<form:input class="form-control" type="text" path="depositoNombre" />
		<input class="btn btn-primary" type="submit" value=<spring:message code="filtrar"/> />
	</div>
	</form:form>
	
	<br>
<!-- <table id="" class="display" cellspacing="0" width="100%"> -->
<table id="tablita" class="display order-column" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th><spring:message code="deposito" text="Deposito"/></th>
			<th><spring:message code="cantidadHuevos"/></th>
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
				<td></td>
<!-- 						TODO no funca datatable -->
			</tr>
		</c:if>
	</tbody>
</table>
</div>

<br>

	<!-- Tabla Productor|Produccion Total -->
<div>
	<h2 class="page-header"> <spring:message code="tablaTotalesProductor"/></h2>
	<h3><spring:message code="filtros"/></h3>

	<form:form class="form-horizontal form-inline" action="produccionContable" method="post" commandName="usuarioFiltro">
	 	<div class="form-group">
			<form:select class="form-control" style="width:auto;" path="id">
				<form:option value="0"><spring:message code="seleccionar"/></form:option>
				<c:forEach items="${listaProductoresDropDown}" var="productor">
					<form:option value="${productor.getId()}"><c:out value="${productor.getNombre()}"></c:out></form:option>
				</c:forEach>
			</form:select>
			<form:label class="control-label" path="nombre"> <spring:message code="nombre"/>: </form:label>
			<form:input class="form-control" type="text" path="nombre"  />
			<form:label  class="control-label" path="apellido"> <spring:message code="apellido"/>: </form:label>
			<form:input class="form-control" type="text" path="apellido" />
			
			<input class="btn btn-primary" type="submit" value=<spring:message code="filtrar"/> />
		</div>
	</form:form>

	<br>
	<table id="tablita2" class="display order-column" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th><spring:message code="nombre"/></th>
				<th><spring:message code="apellido"/></th>
				<th><spring:message code="ProduccionTotal"/></th>
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
	
	<br>
	<br>
	<br>
</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablita2').DataTable();
		});
	</script>
</body>
</html>