<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
<body>

<ul>
	<!-- Menu Admin -->
  <li><a href="/usuarios.jsp"> <spring:message code="usuarios" /> </a></li>
  <li><a href="/parametros.jsp"> <spring:message code="parametros" /> </a></li>

	<!-- Menu productor -->
  <li><a href="../productor/reportes.jsp"> <spring:message code="productor.reportes" /> </a></li>
  <li><a href="../productor/nuevoMovimiento.jsp"> <spring:message code="productor.nuevoMovimiento" /> </a></li>
	
	<!-- Menu contable -->
  <li><a href="../contable/proveedores.jsp"> <spring:message code="proveedores" /> </a></li>
  <li><a href="../contable/gallineros.jsp"> <spring:message code="gallineros" /> </a></li>
  <li><a href="../contable/gallineros.jsp"> <spring:message code="gallineros" /> </a></li>
  <li><a href="../contable/depositos.jsp"> <spring:message code="depositos" /> </a></li>
  <li><a href="../contable/ventas.jsp"> <spring:message code="ventas" /> </a></li>
  <li><a href="../contable/produccion.jsp"> <spring:message code="produccion" /> </a></li>      
</ul>

</body>
</html>
