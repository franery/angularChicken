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

	<c:set var="borrar">
		<spring:message code="borrar" />
	</c:set>

	<c:set var="modificar">
		<spring:message code="modificar" />
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
	
	$('#tablita tbody').on( 'click', '#modificar', function () {
		 var data = table.row( this.closest("tr") ).data();
		 alert( data["id"] +"'s value is: "+ data["borrado"] );
	    } );	
	
	$('#tablita tbody').on( 'click', '#borrar', function (e) {
		var data = table.row( this.closest("tr") ).data();
		var json = { "id" :  data["id"], "nombre" :  data["nombre"], "stockHuevos":  data["stockHuevos"],
				 	"stockMaximo": data["stockMaximo"], "borrado": data["borrado"]};
		var mensaje = document.getElementById("mensajeBorrar").value;
	    e.preventDefault();
	    bootbox.confirm(mensaje, function (response) {        
	        if(response) {
				$('#tablita').DataTable( {
					ajax: {
						url: "depositosBorrarJson",
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
	});	 
});	 
			 
		 /* alert( data["id"] +"'s value is: "+ data["nombre"] );
	    }  );*/	
	
	
	
	/* 
	$('#tablita tbody').on( 'click', 'tr', function () {
		 var data = table.row( this ).data();
	        alert( data["nombre"] +"'s value is: "+ data["stockMaximo"] );
	    } );
 */
	

</script>

</body>
</html>