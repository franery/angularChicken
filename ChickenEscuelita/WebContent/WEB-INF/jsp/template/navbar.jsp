<!DOCTYPE html>
<%@page import="java.util.Locale"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/navbar.css" />


<body>
<div>
	<ul class="ul">
		<li class="liLeft" >${Title}</li>
		<li class="liRightHov"><a class="sup" href="<%=request.getContextPath()%>/logout">
			<spring:message code="logout"/>
		</a></li>
		<li class="liRight">${Nombre}</li>
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
</div>
 <%-- 			 Current Locale : ${pageContext.response.locale }
 			 
 --%> <br>
 
<script>
function myFunction() {
    var x = document.URL;
	document.getElementById("urlRequest").value = x;
}

</script>	
</body>
</html>
