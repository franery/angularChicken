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
<div class="panel-group">
	<div class="panel panel-primary">
	<div class="panel-heading"><h4><spring:message code="filtros"/></h4></div>
    </div>
	<div class="panel panel-primary">
		<div class="panel-body " style="overflow-x:auto;">
		    <form:form method="POST" commandName="filtro">
		    	<table class="table">
		    		<tr>
		    			<td><form:label path="proveedorId"><spring:message code="proveedor"/>:</form:label></td>
		    			<td>
		    				<form:select id="proveedorId" class="form-control" style="width:auto;" path="proveedorId">
								<form:option value="0"><spring:message code="proveedor"/></form:option>
									<c:forEach items="${listaProveedores}" var="proveedor">
										<form:option value="${proveedor.getId()}">
											<c:out value="${proveedor.getNombre()}"></c:out>
										</form:option>
									</c:forEach>
							</form:select>
						</td>
		    		</tr>
		    		<tr>
		    		 	<td> <form:label path="fechaDesde"><spring:message code="fechaDesde"/></form:label> </td> 
						<td> <form:input class="form-control " id="fechaDesde" path="fechaDesde" type="date" /> </td> 
		    		 	<td><form:label  path="fechaHasta"><spring:message code="fechaHasta"/></form:label> </td> 
						<td> <form:input class="form-control " id="fechaHasta" path="fechaHasta" type="date" /> </td>
		    		</tr>
		    		<tr>
		    		 	<td><form:label path="cantidadDesde"><spring:message code="cantidadDesde"/></form:label></td> 
						<td><form:input class="form-control" id="cantidadDesde" path="cantidadDesde" type="text"/></td> 
		    		 	<td><form:label path="cantidadHasta"><spring:message code="cantidadHasta"/></form:label></td> 
						<td><form:input class="form-control" id="cantidadHasta" path="cantidadHasta" type="text" /> </td>
		    		</tr>
		    		<tr>
		    			<td colspan="4"><input type="button" class="btn btn-primary	" onclick="filtrar()" value=<spring:message code="filtrar"/> /></td>
		    		</tr>
		    	</table>
			</form:form>
		</div>
	</div>
</div>	

<!-- Ventas -->
<h3><spring:message code="ventas"/></h3>
<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-body">
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
		</div>
	</div>
</div>

<c:set var="borrar">
	<spring:message code="borrar" />
</c:set>

<c:set var="modificar">
	<spring:message code="modificar" />
</c:set>

<div class="wait"></div>

<script>

var table;

$(document).ready(function(){

	table = $('#tablita').DataTable( {
		language: i18n(),
		dom: 'Bfrtip',
		ajax: "ventasJson",
	    columns: [
	        {data: "proveedorNombre" },
	        {data: "fecha" },
	        {data: "cantidad" },
	        {data: "precio" }
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

function filtrar() {
	var proveedorId = $('#proveedorId').val();
	var fechaDesde = $('#fechaDesde').val();
    var fechaHasta = $('#fechaHasta').val();
    var cantidadDesde = $('#cantidadDesde').val();
    var cantidadHasta= $('#cantidadHasta').val();
    var json = {
	    		"proveedorId" : proveedorId,	
	    		"fechaDesde" : fechaDesde,
	   			"fechaHasta" : fechaHasta, 
	   			"cantidadDesde": cantidadDesde,
	   			"cantidadHasta": cantidadHasta
    			};
    $.ajax ({
		url: "filtrarVentas",
		type: "POST",
		data: JSON.stringify(json),
		dataType: "json",
		success: function(data) {
			table.clear().rows.add(data).draw();
		},
		contentType: "application/json",
		processData:false
	});
}
    

</script>

</body>
</html>