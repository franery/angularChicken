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

		<form:form action="NuevoUsuarioPost" method="post" commandName="usuarioNuevo">
			<form:label path="nombreUsuario">Nombre de usuario: </form:label>
			<form:input path="nombreUsuario" />
			<br>
			<form:label path="nombre">nombre: </form:label>
			<form:input path="nombre" />
			<br>
			<form:label path="apellido">apellido: </form:label>
			<form:input path="apellido" />
			<br>
			<form:label path="contrasenia">contraseña: </form:label>
			<form:input path="contrasenia" />
			<br>
			<form:select path="perfil">
					<form:option value="${EnumPerfil.CONTABLE}">
						<c:out value="CONTABLE"></c:out>
					</form:option>
					<form:option value="${EnumPerfil.ADMINISTRADOR}">
						<c:out value="ADMINISTRADOR"></c:out>
					</form:option>
					<form:option value="${EnumPerfil.PRODUCTOR}">
						<c:out value="PRODUCTOR"></c:out>
					</form:option>
			</form:select>
			<br>
			<input type="submit" value="Guardar" />
		</form:form>
</body>
</html>