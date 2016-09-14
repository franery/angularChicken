<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="usuarios"/></title>

</head>
<body>


<h1><spring:message code="usuarios"/></h1>

		<!-- Nuevo Usuario -->
		<form:form action="usuariosNuevo" method="post" commandName="usuarioNM">
				<input type="submit" value=<spring:message code="nuevo"/> />
		</form:form>
		
		<!-- Tabla Usuarios -->
		<table id="tablita">
			<thead>
				<tr>
					<th><spring:message code="nombreUsuario"/></th>
					<th><spring:message code="nombre"/></th>
					<th><spring:message code="apellido"/></th>
					<th><spring:message code="perfiles"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaUsuarios}">
					<c:forEach items="${listaUsuarios}" var="user">
						<tr>
							<td><c:out value="${user.getNombreUsuario() }"></c:out></td>
							<td><c:out value="${user.getNombre()}"></c:out></td>
							<td><c:out value="${user.getApellido()}"></c:out></td>
							<c:if test="${!empty user.getListaPerfiles()}">
							<td>
								<c:forEach items="${user.getListaPerfiles()}" var="perfil">
									<ul style="list-style: none;"><li>
									<c:out value="${perfil.getNombre()}">"${perfil.getNombre()}"</c:out>
									</li></ul>
								</c:forEach>							
							</td>
							</c:if>
							<c:if test="${empty user.getListaPerfiles()}">
									<td align="center"><spring:message code="sinPerfil"/></td>
							</c:if>
							<td>
							<form:form id="formBorrar" action="usuariosBorrar" method="post" commandName="usuarioNM">
								<form:input path="id" type="hidden" value="${user.getId() }"/>
								<input id="botonBorrar" class="botonBorrar" type="button" value=<spring:message code="borrar"/> />
							</form:form></td>
							<td>
							<form:form action="usuariosModificar" method="post" commandName="usuarioNM">
								<form:input path="id" type="hidden" value="${user.getId() }"/>
								<form:input path="nombreUsuario" type="hidden" value="${user.getNombreUsuario()}"/>
								<form:input path="nombre" type="hidden" value="${user.getNombre()}"/>
								<form:input path="apellido" type="hidden" value="${user.getApellido()}"/>
								<form:input path="contrasenia" type="hidden" value="${user.getContrasenia()}"/>
<%-- 								<form:input path="listaPerfiles" type="hidden" value="${user.getListaPerfiles()}"/> --%>
								<input type="submit" value=<spring:message code="modificar"/> />
							</form:form>
				</td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaUsuarios}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	<c:set var="value">
		<spring:message code="mensajeBorrar" />
	</c:set>
	<input id="mensajeBorrar" type="hidden" value="${value}" />

<script>

$('.botonBorrar').on('click', function (e) {
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