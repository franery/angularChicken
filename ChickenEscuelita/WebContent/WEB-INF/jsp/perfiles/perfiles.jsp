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
		
		<!-- Tabla Usuarios -->
		<table id="tablita">
			<thead>
				<tr>
					<th>Nombre de Usuario</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Perfil</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaUsuarios}">
					<c:forEach items="${listaUsuarios}" var="user">
						<tr>
							<td><c:out value="${user.getNombreUsuario() }"></c:out></td>
							<td><c:out value="${user.getNombre()}"></c:out></td>
							<td><c:out value="${user.getApellido()}"></c:out></td>
							<td><c:out value="${user.getPerfil().toString()}"></c:out></td>
							<td>
							<c:set var="mensajeConfirmacion" scope="request">
								<spring:message code="mensajeConfirmacion"></spring:message>
							</c:set>
							<form:form id="formBorrar" action="borrarUsuario" method="post" commandName="usuarioNM">
								<form:input path="id" type="hidden" value="${user.getId() }"/>
								<input id="botonBorrar" type="submit" value=<spring:message code="borrar"/> />
							</form:form></td>
							<td>
							<form:form action="ModificarUsuario" method="post" commandName="usuarioNM">
								<form:input path="id" type="hidden" value="${user.getId() }"/>
								<form:input path="nombreUsuario" type="hidden" value="${user.getNombreUsuario()}"/>
								<form:input path="nombre" type="hidden" value="${user.getNombre()}"/>
								<form:input path="apellido" type="hidden" value="${user.getApellido()}"/>
								<form:input path="contrasenia" type="hidden" value="${user.getContrasenia()}"/>
								<form:input path="perfil" type="hidden" value="${user.getPerfil()}"/>
								<input type="hidden" name="flagNuevoModificar" value="0"/>
								<input type="submit" value=<spring:message code="modificar"/> />
							</form:form>
				</td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaUsuarios}">
					<tr>
						<td colspan="5">No hay datos disponibles por el momento</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div>
			<!-- <a class="btn btn-default" href="Nuevo" role="button">Nueva
				Mascota</a> -->
		</div>

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