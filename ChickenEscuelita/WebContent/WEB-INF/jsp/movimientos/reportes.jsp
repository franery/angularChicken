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

<style>
th {
	text-align: center;
}

</style>

</head>
<body>
<h1 class="page-header"><spring:message code="movimientos"/></h1>

<!-- FILTRO -->
<h3><spring:message code="filtros"/></h3>

<form:form class="form-horizontal" method="POST" commandName="filtro">
	<div class="form-inline">
		<div class="form-group">
			 <form:label class="control-label col-sm-2" path="fechaDesde"><spring:message code="fechaDesde"/></form:label> 
			 <div class="col-sm-10">
			 	<form:input class="form-control" id="fechaDesde" path="fechaDesde" type="date" /> 
			</div>
		</div>
		<div class="form-group">
		 	<form:label class="control-label col-sm-2" path="fechaHasta"><spring:message code="fechaHasta"/></form:label> 
			 <div class="col-sm-10">
			 	<form:input class="form-control" id="fechaHasta" path="fechaHasta" type="date" /> 
			 </div>			 
		</div>
	</div>
	<div class="form-inline">
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="cantidadDesde"><spring:message code="cantidadDesde"/></form:label> 
			<div class="col-sm-10">
				<form:input class="form-control" id="cantidadDesde" path="cantidadDesde" type="text" /> 
			</div>
		</div>
		<div class="form-group">
			<form:label class="control-label col-sm-2" path="cantidadHasta"><spring:message code="cantidadHasta"/></form:label> 
			<div class="col-sm-10">
				<form:input class="form-control" id="cantidadHasta" path="cantidadHasta" type="text" /> 
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-1 col-sm-10">
			<input type="button" class="btn btn-primary" onclick="filtrar()" value=<spring:message code="filtrar"/> />  
		</div>
	</div>
</form:form>
	
<!-- Movimientos -->
<h3><spring:message code="movimientos"/></h3>
<button class="btn btn-success" id="nuevo"><spring:message code="productor.nuevoMovimiento"/></button>

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

<div class="wait"></div>

<script>
$(document).ready(function(){
	listar();
});

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");}
});

$('#nuevo').on('click', function (e) {
	window.location = "movimientosNuevo";
});

function listar() {
	$('#tablita').DataTable( {
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
		ajax: "movimientosJson",
	    columns: [
	              { data: "fecha" },
	              { data: "cantidad" },
	              { data: "gallineroNombre" },
	              { data: "depositoNombre" }
	              ]
	});
}

function filtrar() {
	var fechaDesde = $('#fechaDesde').val();
    var fechaHasta = $('#fechaHasta').val();
    var cantidadDesde = $('#cantidadDesde').val();
    var cantidadHasta= $('#cantidadHasta').val();
    var json = {"fechaDesde" : fechaDesde,
    			"fechaHasta" : fechaHasta, 
    			"cantidadDesde": cantidadDesde,
    			"cantidadHasta": cantidadHasta
    			};
	$('#tablita').DataTable( {
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
		ajax: {
			url: "filtrando",
			type: "POST",
			data: function() {
				return JSON.stringify(json);
			},
			dataType: "json",
			contentType: "application/json",
			processData:false
		},
		bDestroy: true,
		serverside: true,
		columns: [
	              { data: "fecha" },
	              { data: "cantidad" },
	              { data: "gallineroNombre" },
	              { data: "depositoNombre" }
	              ]
	});
}
</script>
</body>
</html>