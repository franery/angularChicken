<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
<body>

<ul>
  <li><a href="/proveedores.jsp"> <spring:message code="proveedores" /> </a></li>
  <li><a href="/gallineros.jsp"> <spring:message code="gallineros" /> </a></li>
  <li><a href="/depositos.jsp"> <spring:message code="depositos" /> </a></li>
  <li><a href="/ventas.jsp"> <spring:message code="ventas" /> </a></li>
  <li><a href="/produccion.jsp"> <spring:message code="produccion" /> </a></li>      
</ul>

</body>
</html>
