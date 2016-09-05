<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
</head>

<body>

  	<form:form action="proveedoresContable" method="post">
	<input class="menu" type="submit" value=<spring:message code="proveedores"/> />
	</form:form>

  	<form:form action="gallinerosContable" method="post">
	<input class="menu" type="submit" value=<spring:message code="gallineros"/> />
	</form:form>

  	<form:form action="depositosContable" method="post">
	<input class="menu" type="submit" value=<spring:message code="depositos"/> />
	</form:form>

  	<form:form action="ventasContable" method="post">
	<input class="menu" type="submit" value=<spring:message code="ventas"/> />
	</form:form>

  	<form:form action="produccionContable" method="post">
	<input class="menu" type="submit" value=<spring:message code="produccion"/> />
	</form:form>

</body>
</html>
