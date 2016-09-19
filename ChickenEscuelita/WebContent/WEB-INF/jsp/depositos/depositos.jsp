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

<title><spring:message code="depositos" /></title>
</head>
<body>

	<h1>
		<spring:message code="depositos" />
	</h1>


	<form:form action="depositosNuevo" method="post" commandName="deposito">
		<input type="submit" value=<spring:message code="nuevo"/> />
	</form:form>

	<table id="tablita" class="display order-column" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th><spring:message code="nombre" /></th>
				<th><spring:message code="stock" /></th>
				<th><spring:message code="stockMax" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody class="bod">
		</tbody>
	</table>

	<c:set var="value">
		<spring:message code="mensajeBorrar" />
	</c:set>
	<input id="mensajeBorrar" type="hidden" value="${value}" />

	<c:set var="value2">
		<spring:message code="mensajeModificar" />
	</c:set>
	<input id="mensajeModificar" type="hidden" value="${value2}" />
	
	<c:set var="borrar">
		<spring:message code="borrar" />
	</c:set>

	<c:set var="modificar">
		<spring:message code="modificar" />
	</c:set>
	
	<c:set var="depositoModificar">
		<spring:message code="depositoModificar" />
	</c:set>
	
	<c:set var="nombre">
		<spring:message code="nombre" />
	</c:set>

	<c:set var="stockMaximo">
		<spring:message code="stockMaximo" />
	</c:set>
	
<script>

$(document).ready(function(){

	var table = $('#tablita').DataTable( {
		ajax: "depositosJson",
	    columns: [
	        {data: "nombre" },
	        {data: "stockHuevos" },
	        {data: "stockMaximo" },
	        {defaultContent:'<button id="borrar">${borrar}</button>'},
	        {defaultContent:'<button id="modificar">${modificar}</button>'}
	        ],
	    select:true,
	    paging:true,
	    pageLength:5,
	    ordering:true
	});
	
	
	$('#tablita tbody').on( 'click', '#borrar', function (e) {
		var data = table.row( this.closest("tr") ).data();
		var json = { "id" :  data["id"], "nombre" :  data["nombre"], "stockHuevos":  data["stockHuevos"],
				 	"stockMaximo": data["stockMaximo"], "borrado": data["borrado"]};
		var mensaje = document.getElementById("mensajeBorrar").value;
	    e.preventDefault();
	    bootbox.confirm(mensaje, function (response) {        
	        if(response) {
				table = $('#tablita').DataTable( {
					ajax: {
						url: "depositosBorrarJson",
						type: "DELETE",
						data: function(){
							return JSON.stringify(json);
						},
						dataType: "json",
						contentType: "application/json",
						processData:false
					},
					bDestroy: true,
					serverside: true,
					columns: [
				              { data: "nombre" },
				              { data: "stockHuevos" },
				              { data: "stockMaximo" },
				              {defaultContent:'<button id="borrar">${borrar}</button>'},
				              {defaultContent:'<button id="modificar">${modificar}</button>'}
				              ]
				});
       		}
		}); 
	});	 


	$('#tablita tbody').on( 'click', '#modificar', function () {
		
		var data = table.row( this.closest("tr") ).data();
		var arrayHidden = [];
		var arrayShown = [];	
		var idHidden = {nombre:"id", valor: data["id"]};
		var borradoHidden = {nombre:"borrado", valor: data["borrado"]};
		var stockHuevosHidden = {nombre:"stockHuevos", valor: data["stockHuevos"]};
		arrayHidden.push(idHidden);
		arrayHidden.push(borradoHidden);
		arrayHidden.push(stockHuevosHidden);
		var nombreShown = {nombre:"nombre", mensaje:'${nombre}', valor: data["nombre"]};
		var stockMaximoShown = {nombre:"stockMaximo", mensaje:'${stockMaximo}', valor: data["stockMaximo"]};
		arrayShown.push(nombreShown);
		arrayShown.push(stockMaximoShown);
		bootbox.dialog({
	        title: "${depositoModificar}",
	        message: formularioModificar(arrayHidden,arrayShown),
	        buttons: {
	            success: {
	                label: "Save",
	                className: "btn-success",
	                callback: function (e) {
		                var json = { "id" : $('#id').val(), "nombre" :  $('#nombre').val(), "stockHuevos":  $('#stockHuevos').val(),
	        				 	"stockMaximo": $('#stockMaximo').val(), "borrado": $('#borrado').val()};
	    	    		var mensaje = document.getElementById("mensajeModificar").value;
	        		    e.preventDefault();
	        		    bootbox.confirm(mensaje, function (response) {        
		        	        if(response) {
		        				table =  $('#tablita').DataTable( {
		        					ajax: {
		        						url: "depositosModificarJson",
		        						type: "POST",
		        						data: function(){
		        							return JSON.stringify(json);
		        						},
		        						dataType: "json",
		        						contentType: "application/json",
		        						processData:false
		        					},
		        					bDestroy: true,
		        					serverside: true,
		        					columns: [
		        				              { data: "nombre" },
		        				              { data: "stockHuevos" },
		        				              { data: "stockMaximo" },
		        				              {defaultContent:'<button id="borrar">${borrar}</button>'},
		        				              {defaultContent:'<button id="modificar">${modificar}</button>'}
		        				              ]
					        	});
					        }
				        }); 
			        }
	   	        }
			}
		});
	});	
});	 
</script>
</body>
</html>