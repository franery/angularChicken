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
<title><spring:message code="ventaNuevo"/></title>
</head>
<body>

<h1 class="page-header"><spring:message code="venta"/></h1>

<form:form class="form-horizontal maxwid" action="ventasProcesarNuevo" method="post" commandName="venta">
	<form:input path="id" type="hidden" value="${venta.getId()}"/>
	<form:input path="usuarioId" type="hidden" value="${usuarioActual.getId()}"/>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="proveedorId"><spring:message code="proveedor"/>:</form:label>
		<div class="col-sm-10">
			<form:select class="form-control" style="width:auto;" path="proveedorId" required="required">
				<form:option value=""><spring:message code="seleccionar" /></form:option>
					<c:forEach items="${listaProveedores}" var="proveedor">
						<form:option value="${proveedor.getId()}"><c:out value="${proveedor.getNombre()}"></c:out></form:option>
					</c:forEach>
			</form:select>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="fecha"><spring:message code="fecha"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" type="date" path="fecha" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="cantidad"><spring:message code="cantidad"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" path="cantidad" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<form:label class="control-label col-sm-2" path="precio"><spring:message code="precio"/>:</form:label>
		<div class="col-sm-10">
			<form:input class="form-control" path="precio" required="required"/>
		</div>
	</div>	
	<div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
			<input class="btn btn-default" type="submit" value=<spring:message code="guardar"/> />
			<form:errors path="cantidad" cssClass="error" />  
		</div>
	</div>	
</form:form>

</body>
</html>