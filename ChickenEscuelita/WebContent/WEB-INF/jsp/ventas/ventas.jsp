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

<title><spring:message code="ventas"/></title>

</head>
<body>
<h1 class="page-header"><spring:message code="ventas"/></h1>

<!-- FILTRO -->
<h3><spring:message code="filtros"/></h3>

<form:form class="form-horizontal" action="ventas" method="post" commandName="filtro">
	<div align="center" class="form-group">
		<form:label class="control-label col-sm-5" path="proveedorId"><spring:message code="proveedor"/>:</form:label>
		<div class="col-sm-5">
			<form:select class="form-control" style="width:auto;" path="proveedorId">
				<form:option value="0"><spring:message code="proveedor"/></form:option>
				<c:forEach items="${listaProveedores}" var="proveedor">
					<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
				</c:forEach>
			</form:select>
		</div>
	</div>
	<div class="form-inline">
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="fechaDesde"><spring:message code="fechaDesde"/>:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" type="date" path="fechaDesde" />
			</div>
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="fechaHasta"><spring:message code="fechaHasta"/>:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" type="date" path="fechaHasta" />
			</div>
		</div>
	</div>
	<div class="form-inline">
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="cantidadDesde"><spring:message code="cantidadDesde"/>:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" type="text" path="cantidadDesde" />
			</div>
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="cantidadHasta"><spring:message code="cantidadHasta"/>:</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" type="text" path="cantidadHasta" />
			</div>
		</div>
	</div>
	<div class="form-group">
	    <div class="col-sm-offset-1 col-sm-10">
			<input class="btn btn-primary" type="submit" value=<spring:message code="filtrar"/>>
		</div>
	</div>
</form:form>

<!-- Ventas -->
<h3><spring:message code="ventas"/></h3>
<form:form action="ventasNuevo" method="post" commandName="venta">
	<input class="btn btn-success" type="submit" value=<spring:message code="nuevo"/> />
</form:form>

		<table id="tablita" class="display order-column" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th><spring:message code="proveedor"/></th>
			<th><spring:message code="fecha"/></th>
			<th><spring:message code="cantidad"/></th>
			<th><spring:message code="precio"/></th>
		</tr>
	</thead>
	<c:if test="${!empty listaVentas}">
		<c:forEach items="${listaVentas}" var="venta">
			<tr>
				<td><c:out value="${venta.getProveedorNombre()}"></c:out></td>
				<td><c:out value="${venta.getFecha()}"></c:out></td>
				<td><c:out value="${venta.getCantidad()}"></c:out></td>
				<td><c:out value="${venta.getPrecio()}"></c:out></td>
			</tr>
		</c:forEach>
	</c:if>
				<c:if test="${empty listaVentas}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
</table>

<script type="text/javascript">
	$(document).ready(function() {
		$('#tablita').DataTable({
			language: {
				processing:     "<spring:message code='procesando'/>",
	            search:         "<spring:message code='buscar'/>",
	            lengthMenu:     "<spring:message code='tamanioMenu'/>",
	            info:           "<spring:message code='info'/>",
	            infoEmpty:      "<spring:message code='infoVacia'/>",
	            infoFiltered:   "<spring:message code='infoFiltrada'/>",
	            loadingRecords: "<spring:message code='cargandoRegistros'/>",
	            zeroRecords:    "<spring:message code='ceroRegistros'/>",
	            emptyTable:     "<spring:message code='noHayResultados'/>",
	            paginate: {
	                first:      "<spring:message code='primero'/>",
	                previous:   "<spring:message code='anterior'/>",
	                next:       "<spring:message code='siguiente'/>",
	                last:       "<spring:message code='ultimo'/>"
	            },
			},
		});
	});
</script>

</body>
</html>