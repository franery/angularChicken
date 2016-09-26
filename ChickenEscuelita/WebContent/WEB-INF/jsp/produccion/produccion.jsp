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
<div>
	<h2 class="page-header"> <spring:message code="tablaDepositosStock"/></h2>
	<h3><spring:message code="filtros"/></h3>
	<form:form class="form-horizontal form-inline" method="post" commandName="depositoFiltro">
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
	
<table id="tablita" class="display order-column" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th><spring:message code="deposito"/></th>
			<th><spring:message code="cantidadHuevos"/></th>
		</tr>
	</thead>
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
				<th><spring:message code="ProduccionTotal"/></th>
			</tr>
		</thead>
	</table>
</div>

<div class="wait"></div>

<script>

$(document).ready(function() {
	$('#tablita').DataTable( {
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
	
 	$('#tablita2').DataTable( {
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

</script>

</body>
</html>