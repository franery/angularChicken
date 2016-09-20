<!DOCTYPE html>
<%@page import="java.util.Locale"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
 <style type="text/css">
body {
  padding-top: 50px;
}
.container-fluid > .navbar-nav.navbar-right:last-child,
.container-fluid > .navbar-collapse > .navbar-nav.navbar-right:last-child{
    margin-right: 10px;
}
@media (min-width: 768px) { 
    .twoRow .navbar-collapse {
        
    }
}
</style> 
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top twoRow" role="navigation">	
	<div class=container-fluid>
		<div class="navbar-header">
 			<a class="navbar-brand" href="#"><spring:message code="nombreApp" /></a>
     		<button type = "button" class = "navbar-toggle" data-toggle="collapse" data-target = "#example-navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>       
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<div>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/logout"> <spring:message	code="logout" /></a></li>
				<li>
					<!-- Eleccion Idioma -->
					<c:set var="idioma" scope="session" value="${pageContext.response.locale.displayName}" />
						<form:form id="butonLang1" onsubmit="myFunction()" method="POST" action="cambioLenguaje">
							<input type="hidden" name="urlRequest" id="urlRequest">
							<input type="hidden" name="lenguajeElegido" id="lenguajeElegido" value="en">
							<c:choose>
								<c:when test="${idioma.equals('English')}">
									<input class="navbar-btn img-circle center-block" type="image" height="30" src="http://bazaar.eprints.org/224/1/static/images/flags/us.png" alt="EN" disabled />
								</c:when>
								<c:otherwise>
									<input class="navbar-btn img-circle center-block" type="image" height="30" src="http://bazaar.eprints.org/224/1/static/images/flags/us.png" alt="EN" onclick="cambiarLenguaje1();" />
								</c:otherwise>
							</c:choose>
						</form:form>
					</li>
					<li>
						<form:form id="butonLang2"
							onsubmit="myFunction2()" method="POST" action="cambioLenguaje">
							<input type="hidden" name="urlRequest" id="urlRequest2">
							<input type="hidden" name="lenguajeElegido" id="lenguajeElegido"
								value="es">
							<c:choose>
								<c:when test="${idioma.equals('Spanish')}">
									<input class="navbar-btn img-circle center-block" type="image" height="30"
										src="http://bazaar.eprints.org/224/1/static/images/flags/ar.png"
										alt="ES" disabled />
								</c:when>
								<c:otherwise>
									<input class="navbar-btn img-circle center-block" type="image" height="30"
										src="http://bazaar.eprints.org/224/1/static/images/flags/ar.png"
										alt="ES" onclick="cambiarLenguaje2();" />
								</c:otherwise>
							</c:choose>
						</form:form>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="navbar navbar-inverse navbar-static-top" id="navbar2" role="navigation">	
	<div  class="container-fluid no-radius">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar2-navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbar2-navbar-collapse">
			<ul class="nav navbar-nav">
				<c:forEach items="${listaPermisos}" var="permiso">
				<li><a href="${permiso}"><spring:message code="${permiso}"/></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<%-- 	 		 Current Locale : ${pageContext.response.locale } --%>
<br>
<br>

<script>
$(function(){
    $('#navbar1 .navbar .navbar-collapse').on('show.bs.collapse', function(e) {
        $('#navbar1 .navbar .navbar-collapse').not(this).collapse('hide');
    });
});
	
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
