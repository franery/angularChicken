<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
</head>
<body>

	<form:form id="reportesForm" action="reportes" method ="post">
		<input class="menu" type="submit" value=<spring:message code="productor.reportes"/> />
	</form:form>
</body>
</html>
