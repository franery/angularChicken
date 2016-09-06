<!DOCTYPE html>
<%@page import="java.util.Locale"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/navbar.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css" />


<jsp:include page="importacion.jsp"></jsp:include>
<body>

	<ul class="ul">
		<li class="liLeft" >${Title}</li>
		<li class="liRightHov"><a class="sup" href="<%=request.getContextPath()%>/index.jsp">Logout</a></li>
		<li class="liRight">${Nombre}</li>
		<li class="liRight">
	</ul>

	<form:form onsubmit="myFunction()" method="POST" action="principalAdmin2">
				<select name="languageRequest"> 
							<option value=""> <spring:message code="lenguaje"/> </option>
							<option value="en"> <spring:message code="ingles"/> </option>
							<option value="es"> <spring:message code="espaniol"/> </option>
					</select>
				<input type="hidden" name="urlRequest" id="urlRequest" >
				<input type="submit" value="<spring:message code="guardar"/>" />
	</form:form>
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
