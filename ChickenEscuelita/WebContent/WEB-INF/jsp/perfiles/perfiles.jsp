<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="perfiles"/></title>

</head>
<body>

<h1><spring:message code="perfiles"/></h1>

		<!-- Nuevo Perfil -->
		<form:form action="perfilesNuevo" method="post" commandName="perfil">
				<input type="submit" value=<spring:message code="nuevo"/> />
		</form:form>
		
		<!-- Tabla Perfiles -->
		<table id="tablita">
			<thead>
				<tr>
					<th><spring:message code="nombre"/></th>
					<th><spring:message code="permisos"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaPerfiles}">
					<c:forEach items="${listaPerfiles}" var="perfil">
						<tr>
							<td><c:out value="${perfil.getNombre()}"></c:out></td>
							<td><c:out value="${perfil.}"></c:out></td>
							<td>
							<c:set var="mensajeConfirmacion" scope="request">
								<spring:message code="mensajeConfirmacion"></spring:message>
							</c:set>
							<form:form id="formBorrar" action="borrarPerfil" method="post" commandName="perfil">
								<form:input path="id" type="hidden" value="${perfil.getId() }"/>
								<input id="botonBorrar" type="submit" value=<spring:message code="borrar"/> />
							</form:form></td>
							<td>
							<form:form action="ModificarPerfil" method="post" commandName="perfil">
								<form:input path="id" type="hidden" value="${perfil.getId() }"/>
								<form:input path="nombre" type="hidden" value="${perfil.getNombre()}"/>
								<input type="submit" value=<spring:message code="modificar"/> />
							</form:form>
				</td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaPerfiles}">
					<tr>
						<td colspan="5"><spring:message code="accesoDenegado"/></td>
					</tr>
				</c:if>
			</tbody>
		</table>

	<c:set var="value">
		<spring:message code="mensajeBorrar" />
	</c:set>
	<input id="mensajeBorrar" type="hidden" value="${value}" />

<script>

$('#botonBorrar').on('click', function (e) {
	var mensaje = document.getElementById("mensajeBorrar").value;
    e.preventDefault();
    bootbox.confirm(mensaje, function (response) {        
        if(response) {
            $('#formBorrar').submit();
        }
    });
});

</script>

</body>
</html>