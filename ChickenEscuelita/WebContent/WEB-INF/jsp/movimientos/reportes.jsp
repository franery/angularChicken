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

<!-- FILTRO -->

<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4><spring:message code="filtros"/></h4>
		</div>
    </div>
	<div class="panel panel-primary">
		<div class="panel-body " style="overflow-x:auto;">
		    <form:form method="POST" commandName="filtro">
		    	<table class="table">
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

<!-- Movimientos -->
<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-body">

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
		</div>
	</div>
</div>

<div class="wait"></div>

<script>
$(document).ready(function(){
	listar();
});

$(document).on({
    ajaxStart: function() {$("body").addClass("loading");},
    ajaxStop: function() {$("body").removeClass("loading");}
});

function listar() {
	$('#tablita').DataTable( {
		language: i18n(),
		dom: 'Bfrtip',
		ajax: "movimientosJson",
	    columns: [
	              { data: "fecha" },
	              { data: "cantidad" },
	              { data: "gallineroNombre" },
	              { data: "depositoNombre" }
	              ],
   	    buttons: [
 	              {
 	                  text: '<button class="btn btn-success pull-left" id="nuevo"><spring:message code="nuevo"/></button>',
 	                  action: function ( e, dt, node, config ) {
 	                      window.location = "movimientosNuevo";
 	                  }
 	              }
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
		language: i18n(),
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