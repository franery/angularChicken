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
.container-fluid > .navbar-nav.navbar-right:last-child,
.container-fluid > .navbar-collapse > .navbar-nav.navbar-right:last-child{
    margin-right: 10px;
}
</style></head>

<body>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<%-- ${Title} --%>
				<a class="navbar-brand" href=""><spring:message code="nombreApp" /></a>
				     <button type = "button" class = "navbar-toggle" data-toggle="collapse" data-target = "#example-navbar-collapse">
					      <span class="sr-only">Toggle navigation</span>
					      <span class="icon-bar"></span>
					      <span class="icon-bar"></span>
					      <span class="icon-bar"></span>
					</button>
			</div>

			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<!-- Eleccion Idioma -->
						<div>
							<c:set var="idioma" scope="session"
								value="${pageContext.response.locale.displayName}" />
							<form:form class="navbar-form navbar-right" id="butonLang1"
								onsubmit="myFunction()" method="POST" action="cambioLenguaje">
								<input type="hidden" name="urlRequest" id="urlRequest">
								<input type="hidden" name="lenguajeElegido" id="lenguajeElegido"
									value="en">
								<c:choose>
									<c:when test="${idioma.equals('English')}">
										<input class="navbar-btn" type="image"
											src="http://bazaar.eprints.org/224/1/static/images/flags/us.png"
											alt="EN" disabled />
									</c:when>
									<c:otherwise>
										<input class="navbar-btn" type="image"
											src="http://bazaar.eprints.org/224/1/static/images/flags/us.png"
											alt="EN" onclick="cambiarLenguaje1();" />
									</c:otherwise>
								</c:choose>
							</form:form>
						</div>
					</li>
					<li>
						<div>
							<form:form class="navbar-form navbar-right" id="butonLang2"
								onsubmit="myFunction2()" method="POST" action="cambioLenguaje">
								<input type="hidden" name="urlRequest" id="urlRequest2">
								<input type="hidden" name="lenguajeElegido" id="lenguajeElegido"
									value="es">
								<c:choose>
									<c:when test="${idioma.equals('Spanish')}">
										<input class="navbar-btn" type="image"
											src="http://bazaar.eprints.org/224/1/static/images/flags/ar.png"
											alt="ES" disabled />
									</c:when>
									<c:otherwise>
										<input class="navbar-btn" type="image"
											src="http://bazaar.eprints.org/224/1/static/images/flags/ar.png"
											alt="ES" onclick="cambiarLenguaje2();" />
									</c:otherwise>
								</c:choose>
							</form:form>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>

<br>
<br>
<br>
<br>
<br>
<br>
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
