<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
<body>

<ul>
  <li>
		<form:form action="proveedores" method="post" commandName="usuarioActual">
		<form:input path="nombre" type="hidden" value="${usuarioActual.getNombre()}"/>
		<form:input path="apellido" type="hidden" value="${usuarioActual.getApellido()}"/>
		<form:input path="nombreUsuario" type="hidden" value="${usuarioActual.getNombreUsuario()}"/>
		<form:input path="contrasenia" type="hidden" value="${usuarioActual.getContrasenia()}"/>
		<form:input path="perfil" type="hidden" value="${usuarioActual.getPerfil()}"/>
		<input type="submit" value=<spring:message code="proveedores"/> />
		</form:form>
  </li>
  <li><a href="/gallineros.jsp"> <spring:message code="gallineros" /> </a></li>
  <li><a href="/depositos.jsp"> <spring:message code="depositos" /> </a></li>
  <li><a href="/ventas.jsp"> <spring:message code="ventas" /> </a></li>
  <li><a href="/produccion.jsp"> <spring:message code="produccion" /> </a></li>      
</ul>

</body>
</html>
