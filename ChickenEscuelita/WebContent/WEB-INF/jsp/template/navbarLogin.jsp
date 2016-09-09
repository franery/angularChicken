<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/navbar.css" />
<jsp:include page="importacion.jsp"></jsp:include>

<head>
<style type="text/css">
select.backVerde {
	background-color: #4CAF50;
}
submit.backVerde {
	background-color: #4CAF50;
}
</style></head>

<body>
	<ul class="ul">
		<li class="liLeft" id="text">${Title}</li>
		<li class="liRight">
		<form:form onsubmit="myFunction()" method="POST" action="cambioLenguaje">
				<select class="backVerde" name="languageRequest"> 
							<option value=""> <spring:message code="lenguaje"/> </option>
							<option value="en"> <spring:message code="ingles"/> </option>
							<option value="es"> <spring:message code="espaniol"/> </option>
					</select>
				<input type="hidden" name="urlRequest" id="urlRequest" >
				<input type="submit" class="langg" value=<spring:message code="cambiar"/> />
		</form:form></li>
	</ul>
<br>
<br>
<br>
</body>
</html>
