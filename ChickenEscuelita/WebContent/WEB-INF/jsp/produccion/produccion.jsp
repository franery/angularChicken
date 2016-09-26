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

</head>
<body>

		<!-- Tabla Depositos|Cant Huevos -->

		<h2 class="page-header"> <spring:message code="tablaDepositosStock"/></h2>
<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4><spring:message code="filtros"/></h4>
		</div>
    </div>
	<div class="panel panel-primary">
		<div class="panel-body">	
			<form:form class="form-horizontal form-inline" method="post" commandName="depositoFiltro">
				 	<div class="form-group">
						<form:label path="depositoId"><spring:message code="deposito"/></form:label>
						<form:select class="form-control" style="width:auto;" id="depositoId" path="depositoId">
							<form:option value="0"><spring:message code="seleccionar"/></form:option>
							<c:forEach items="${listaDepositosDropDown}" var="deposito">
								<form:option value="${deposito.getId()}"><c:out value="${deposito.getNombre()}"></c:out></form:option>
							</c:forEach>
						</form:select>
						<form:label path="depositoNombre"><spring:message code="nombre"/></form:label>
						<form:input class="form-control" type="text" id="depositoNombre" path="depositoNombre" />
						<input class="btn btn-primary" type="button" onclick="filtrar()" value=<spring:message code="filtrar"/> />
					</div>
			</form:form>
		</div>
	</div>
</div>	

	<br>
<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-body " style="overflow-x:auto;">	
			<table id="tablita" class="display order-column" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th><spring:message code="deposito"/></th>
						<th><spring:message code="cantidadHuevos"/></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<br>

	<!-- Tabla Productor|Produccion Total -->
<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4><spring:message code="filtros"/></h4>
		</div>
    </div>
	<div class="panel panel-primary">
		<div class="panel-body">	
			<form:form class="form-horizontal form-inline" method="post" commandName="usuarioFiltro">
			 	<div class="form-group">
					<form:select class="form-control" id="id" style="width:auto;" path="id">
						<form:option value="0"><spring:message code="seleccionar"/></form:option>
						<c:forEach items="${listaProductoresDropDown}" var="productor">
							<form:option value="${productor.getId()}"><c:out value="${productor.getNombre()}"></c:out></form:option>
						</c:forEach>
					</form:select>
					<form:label class="control-label" path="nombre"> <spring:message code="nombre"/>: </form:label>
					<form:input class="form-control" type="text" id="nombre" path="nombre"  />
					<input class="btn btn-primary" type="button" onclick="filtrar2()" value=<spring:message code="filtrar"/> />
				</div>
			</form:form>
		</div>
	</div>
</div>
<br>
<div class="panel-group">
	<div class="panel panel-primary">
		<div class="panel-body " style="overflow-x:auto;">	
			<table id="tablita2" class="display order-column" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th><spring:message code="nombre"/></th>
						<th><spring:message code="ProduccionTotal"/></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<div class="wait"></div>

<script>
var table;
var table2;

$(document).ready(function() {
	table = $('#tablita').DataTable( {
		language: i18n(),
		ajax: "produccionDepositosJson",
	    columns: [
	        {data: "nombre" },
	        {data: "stockHuevos" }
	        ],
	    select:true,
	    paging:true,
	    pageLength:50,
	    ordering:true,
	});
	
 	table2 = $('#tablita2').DataTable( {
		language: i18n(),
		ajax: "produccionTotalesJson",
	    columns: [
	        {data: "nombre"},
	        {data: "valor"}
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
});

function filtrar() {
	var depositoId = $('#depositoId').val();
    var depositoNombre = $('#depositoNombre').val();
    var json = {"depositoId" : depositoId,
    			"depositoNombre" : depositoNombre
    			};
    $.ajax ({
		url: "filtrarDepositosProduccion",
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

function filtrar2() {
	var id = $('#id').val();
    var nombre = $('#nombre').val();
    var json = {"id" : id,
    			"nombre" : nombre,
    			};
    $.ajax ({
		url: "filtrarTotalesProduccion",
		type: "POST",
		data: JSON.stringify(json),
		dataType: "json",
		success: function(data) {
			table2.clear().rows.add(data).draw();
		},
		contentType: "application/json",
		processData:false
    });
}
</script>

</body>
</html>