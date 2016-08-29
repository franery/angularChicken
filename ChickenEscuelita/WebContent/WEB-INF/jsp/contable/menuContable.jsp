<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>

  	<form:form action="proveedores" method="post" commandName="usuarioActual">
	<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
	<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
	<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
	<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
	<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
	<input class="menu" type="submit" value=<spring:message code="proveedores"/> />
	</form:form>

  	<form:form action="gallineros" method="post" commandName="usuarioActual">
	<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
	<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
	<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
	<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
	<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
	<input class="menu" type="submit" value=<spring:message code="gallineros"/> />
	</form:form>

  	<form:form action="depositos" method="post" commandName="usuarioActual">
	<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
	<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
	<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
	<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
	<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
	<input class="menu" type="submit" value=<spring:message code="depositos"/> />
	</form:form>

  	<form:form action="ventas" method="post" commandName="usuarioActual">
	<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
	<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
	<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
	<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
	<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
	<input class="menu" type="submit" value=<spring:message code="ventas"/> />
	</form:form>

  	<form:form action="produccion" method="post" commandName="usuarioActual">
	<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
	<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
	<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
	<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
	<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
	<input class="menu" type="submit" value=<spring:message code="produccion"/> />
	</form:form>

</body>
</html>
