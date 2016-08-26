<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
<body>

<ul>
  <li><a href="/reportes.jsp"> <spring:message code="productor.reportes" /> </a></li>
  <li><a href="/nuevoMovimiento.jsp"> <spring:message code="productor.nuevoMovimiento" /> </a></li>
</ul>

</body>
</html>
