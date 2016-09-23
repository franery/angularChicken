<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="perfiles"/></title>

<style>
th {
	text-align: center;
}

</style>

</head>
<body>

<h1 class="page-header"><spring:message code="perfiles"/></h1>

		<!-- Nuevo Perfil -->
		<form:form action="perfilesNuevo" method="post" commandName="perfil">
				<input class="btn btn-success" type="submit" value=<spring:message code="nuevo"/> />
		</form:form>
		
		<!-- Tabla Perfiles -->
<%-- 		<table id="tablita" class="display order-column" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th><spring:message code="nombre"/></th>
					<th><spring:message code="permisos"/></th>
					<th></th>
				<th></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaPerfiles}">
					<c:forEach items="${listaPerfiles}" var="perfil">
						<tr>
							<td><c:out value="${perfil.getNombre()}"></c:out></td>
							<td>
								<c:forEach items="${perfil.getListaPermisos() }" var="permiso">
									<c:out value="${permiso.getModulo() }"></c:out>
									<c:out value="${permiso.getOperacion() }"></c:out>								
								</c:forEach>
							</td>
							<td>
							<form:form id="form${perfil.getId()}" action="perfilesBorrar" method="post" commandName="perfil">
								<form:input path="id" type="hidden" value="${perfil.getId() }"/>
								<form:input path="nombre" type="hidden" value="${perfil.getNombre() }"/>
								<input id="boton${perfil.getId()}" class="botonBorrar btn btn-danger" type="button" value=<spring:message code="borrar"/> />
							</form:form></td>
							<td>
							<form:form action="perfilesModificar" method="post" commandName="perfil">
								<form:input path="id" type="hidden" value="${perfil.getId() }"/>
								<form:input path="nombre" type="hidden" value="${perfil.getNombre()}"/>
								<input class="btn btn-warning" type="submit" value=<spring:message code="modificar"/> />
							</form:form>
				</td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaPerfiles}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
			</tbody>
		</table> --%>


<table id="tablita" class="display order-column" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th><spring:message code="nombre"/></th>
					<th><spring:message code="permisos"/></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
</table>
			

	<form:form id="formModificar" action="perfilesModificar" method="post" commandName="perfil">
		<form:input id="id" path="id" type="hidden"/>
		<form:input id="nombre" path="nombre" type="hidden"/>
	</form:form>
	
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

<div class="wait"></div>

<script>

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
		ajax: "perfilesJson",
	    columns: [
	        {data: "nombre" },
	        {data: "listaPermisos[].nombreModulo"},
	        {defaultContent:'<button class="btn btn-danger" id="borrar">${borrar}</button>'},
	        {defaultContent:'<button class="btn btn-warning" id="modificar">${modificar}</button>'}
	        ],
	    select:true,
	    paging:true,
	    pageLength:50,
	    ordering:true
	});
	
	$(document).on({
	    ajaxStart: function() {$("body").addClass("loading");},
	    ajaxStop: function() {$("body").removeClass("loading");}
	});
	
	$('#nuevo').on('click', function (e) {
		window.location = "perfilesNuevo";
	});
	
	
	$('#tablita tbody').on('click', '#borrar', function (e) {
		var data = table.row(this.closest("tr")).data();
		var json = {
			"id" : data["id"],
			"nombre" : data["nombre"],
		};
		var mensaje = document.getElementById("mensajeBorrar").value;
		e.preventDefault();
		bootbox.confirm(mensaje, function (response) {
			if (response) {
				$.ajax({
					url : "perfilesBorrarJson",
					type : "DELETE",
					data : JSON.stringify(json),
					dataType : "json",
					contentType : "application/json",
					processData : false,
					complete : function () {
						table.ajax.reload();
					}
				});
			}
		});
	});
});
	

$('#tablita tbody').on('click', '#modificar', function (e) {
	var data = table.row(this.closest("tr")).data();
	e.preventDefault();
	document.getElementById("id").value = data["id"];
	document.getElementById("nombre").value = data["nombre"];
	document.getElementById("stockHuevos").value = data["stockHuevos"];
	document.getElementById("stockMaximo").value = data["stockMaximo"];
	document.getElementById("borrado").value = data["borrado"];
	document.getElementById("formModificar").submit();
});


<c:forEach items="${listaPerfiles}" var="perfil">
$('#boton' + '${perfil.id}').on('click', function (e) {
	var mensaje = document.getElementById("mensajeBorrar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
        	$('#form' + '${perfil.id}').submit();
        }
    });
});
</c:forEach>

</script>

</body>
</html>