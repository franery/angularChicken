<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Nuevo Usuario</title>

</head>
<body>
	<h1>Nuevo Usuario</h1>

	<form:form method="POST" action="NuevoUsuarioPost"
		commandName="usuarioNuevo">
		<table>
			<tr>
				<td class="label"><spring:message code="nombreUsuario" /></td>
				<td><form:input path="nombreUsuario" /></td>
			</tr>
			<tr>
				<td class="label"><spring:message code="nombre" /></td>
				<td><form:input path="nombre" /></td>

				<td class="label"><spring:message code="apellido" /></td>
				<td><form:input path="apellido" /></td>
			</tr>
			<tr>
				<td class="label"><spring:message code="contrasenia" /></td>
				<td><form:input path="contrasenia" /></td>
			</tr>
			<tr>
				<td class="label"><spring:message code="perfil" /></td>
				<td><form:select path="perfil">
						<option value=""><spring:message code="seleccionar" /></option>
						<c:forEach var="perfil" items="${perfiles}">
							<option value="${perfil}">  ${perfil.getName()}  </option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center;">
				<input type="submit" value="<spring:message code="guardar"/>" /> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>