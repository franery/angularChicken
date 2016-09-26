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

<table id="tablita" class="display order-column" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th><spring:message code="proveedor"/></th>
			<th><spring:message code="fecha"/></th>
			<th><spring:message code="cantidad"/></th>
			<th><spring:message code="precio"/></th>
		</tr>
	</thead>
</table>

<c:set var="borrar">
	<spring:message code="borrar" />
</c:set>

<c:set var="modificar">
	<spring:message code="modificar" />
</c:set>

<div class="wait"></div>

<script>

$(document).ready(function(){

	var table = $('#tablita').DataTable( {
		language: i18n(),
		dom: 'Bfrtip',
		ajax: "ventasJson",
	    columns: [
	        {data: "proveedorNombre" },
	        {data: "fecha" },
	        {data: "cantidad" },
	        {data: "precio" },
	        {defaultContent:'<button class="btn btn-danger" id="borrar">${borrar}</button>'},
	        {defaultContent:'<button class="btn btn-warning" id="modificar">${modificar}</button>'}
	        ],
	    select:true,
	    paging:true,
	    pageLength:50,
	    ordering:true,
	    buttons: [
	              {
	                  text: '<button class="btn btn-success pull-left" id="nuevo"><spring:message code="nuevo"/></button>',
	                  action: function ( e, dt, node, config ) {
	                      window.location = "ventasNuevo";
	                  }
	              }
	          ]
	});
	
	$(document).on({
	    ajaxStart: function() {$("body").addClass("loading");},
	    ajaxStop: function() {$("body").removeClass("loading");}
	});
});

</script>

</body>
</html>