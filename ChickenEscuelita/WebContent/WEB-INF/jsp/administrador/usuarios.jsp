<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
		<!-- Nuevo Usuario -->
		<form:form action="NuevoUsuario" method="post" commandName="usuarioNuevo">
			<input type="hidden" name="flagNuevoModificar" value="1"/>
				<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
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
							<td><form:form action="borrarUsuario" method="post" commandName="usuarioNM">
								<form:input path="id" type="hidden" value="${user.getId() }"/>
								<input type="submit" value=<spring:message code="borrar" text="Borrar"/> />
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
								<input type="submit" value=<spring:message code="modificar" text="Modificar"/> />
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

</body>
</html>