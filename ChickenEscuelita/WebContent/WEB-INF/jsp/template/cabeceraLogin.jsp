<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	
		<!-- Eleccion Idioma -->
		<li class="liRight">
		<c:set var="idioma" scope="session" value="${pageContext.response.locale.displayName}"/>
		<form:form id="butonLang1" onsubmit="myFunction()" method="POST" action="cambioLenguaje">
				<input type="hidden" name="urlRequest" id="urlRequest" >
				<input type="hidden" name="lenguajeElegido" id="lenguajeElegido" value="en" >	
				<c:choose>
        		  	<c:when test="${idioma.equals('English')}">
	        	<input type="image" src="http://bazaar.eprints.org/224/1/static/images/flags/us.png" 
	        	alt="EN" disabled/> 
       		    	</c:when>
       		    	<c:otherwise>
	        	<input type="image" src="http://bazaar.eprints.org/224/1/static/images/flags/us.png" 
	        	alt="EN" onclick="cambiarLenguaje1();"/> 
       		    	</c:otherwise>    					
        		</c:choose>
		</form:form></li>
		<li class="liRight">
		<form:form id="butonLang2" onsubmit="myFunction2()" method="POST" action="cambioLenguaje">
				<input type="hidden" name="urlRequest" id="urlRequest2" >
				<input type="hidden" name="lenguajeElegido" id="lenguajeElegido" value="es" >
	        	<c:choose>
        		  	<c:when test="${idioma.equals('Spanish')}">
        		<input type="image" src="http://bazaar.eprints.org/224/1/static/images/flags/ar.png" 
        		alt="ES" disabled/> 
       		    	</c:when>
       		    	<c:otherwise>
		        <input type="image" src="http://bazaar.eprints.org/224/1/static/images/flags/ar.png" 
		        alt="ES" onclick="cambiarLenguaje2();"/> 
       		    	</c:otherwise>    					
        		</c:choose>
		</form:form>




	</ul>
<br>
<br>
<br>
<script>
function myFunction() {
    var x = document.URL;
	document.getElementById("urlRequest").value = x;
}
function myFunction2() {
    var x = document.URL;
	document.getElementById("urlRequest2").value = x;
}
function cambiarLenguaje1() {
	document.getElementById('butonLang1').submit();
	}
function cambiarLenguaje2() {
	document.getElementById('butonLang2').submit();
	}
</script>
</body>
</html>
