<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/navbar.css" />
<jsp:include page="importacion.jsp"></jsp:include>
<body>
	<ul class="ul">
		<li class="liLeft" id="text">${Title}</li>
		<li class="liRight">
		<spring:message code="lenguaje"/>:
		<a href="?lang=en">EN</a> | <a href="?lang=es">ES</a></li>
	</ul>
<br>
<br>
<br>
</body>
</html>
