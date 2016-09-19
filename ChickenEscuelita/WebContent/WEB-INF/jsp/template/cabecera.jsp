<!DOCTYPE html>
<%@page import="java.util.Locale"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style type="text/css">

.container-fluid > .navbar-nav.navbar-right:last-child,
.container-fluid > .navbar-collapse > .navbar-nav.navbar-right:last-child{
    margin-right: 10px;
}

</style>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/navbar.css" />
</head>
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
					<li><a href="<%=request.getContextPath()%>/logout"> <spring:message
								code="logout" />
					</a> <%-- ${Nombre} --%></li>
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

	<%--  		 Current Locale : ${pageContext.response.locale } --%>

<!-- 
<div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a class="navbar-brand topNavBar-Title" style="color:#ffffff !important" href="/">Accenture Portal</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li style="cursor: pointer;">
                    <a class="navbar-brand topNavBar-UserName" style="color:#ffffff !important" ng-click="goToLink(user.URL)" ap-track="click:['InnerMe','Click','Name']">Petit de Meurville, R.</a>
                </li>
                <li style="cursor: pointer;">
                    <div>
                        <a class="navbar-brand topNavBar-Picture" ng-click="goToLink(user.URL)" ap-track="click:['InnerMe','Click','Image']">
                            <img ap-profile-picture="" class="img-circle center-block">
                        </a>
                    </div>
                </li>
                <li dropdown="" class="">
                    <a id="navbarPreferences" class="navbar-brand glyphicon glyphicon-cog dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
                    </a>
                    <ul id="preferencesTab" class="dropdown-menu" role="menu">
                        <li><a ng-click="openTutorial()">TUTORIAL</a></li>
                        <li role="separator" class="divider" id="lineDivider"></li>
                        <li><a ng-click="goToLink('https://support.accenture.com/applications/AccenturePortalSupport/Pages/DefaultGlobal.aspx?rd=3&amp;HP=1')">HELP</a></li>
                        <li role="separator" class="divider" id="lineDivider"></li>
                        <li ng-controller="PreferencesCtrl"><a ng-click="OpenModal()">PREFERENCES</a></li>
                        <li role="separator" class="divider" id="lineDivider"></li>
                        <li><a ng-click="logOff()">LOG OUT</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="navbar-brand glyphicon glyphicon-bell"></a>
                </li>
            </ul>
        </div>
        
        
         -->
         
         
         <!-- <br>
        <br><br>	
        <div class="nav-center">
                    <ul class="nav nav-tabs links-title">
                        <li ng-show="topLinks &amp;&amp; topLinks.SubCategories" ng-mouseover="selectCategory('TopLinks')"><a class="links-title" data-toggle="tab" ng-class="{'category-active': isCategorySelected('TopLinks')}">Quick Links</a></li>

                        ngRepeat: n in navLinks<li ng-repeat-start="n in navLinks"><a class="links-divider" data-toggle="tab">|</a></li>
                        <li ng-mouseover="selectCategory(n.Id, n.SubCategories[0].Id)" ng-repeat-end=""><a class="links-title nav-links" data-toggle="tab" ng-class="{'category-active': isCategorySelected(n.Id)}">Sell &amp; Deliver</a></li>end ngRepeat: n in navLinks<li ng-repeat-start="n in navLinks"><a class="links-divider" data-toggle="tab">|</a></li>
                        <li ng-mouseover="selectCategory(n.Id, n.SubCategories[0].Id)" ng-repeat-end=""><a class="links-title nav-links" data-toggle="tab" ng-class="{'category-active': isCategorySelected(n.Id)}">Career &amp; Benefits</a></li>end ngRepeat: n in navLinks<li ng-repeat-start="n in navLinks"><a class="links-divider" data-toggle="tab">|</a></li>
                        <li ng-mouseover="selectCategory(n.Id, n.SubCategories[0].Id)" ng-repeat-end=""><a class="links-title nav-links" data-toggle="tab" ng-class="{'category-active': isCategorySelected(n.Id)}">Corporate Services</a></li>end ngRepeat: n in navLinks<li ng-repeat-start="n in navLinks"><a class="links-divider" data-toggle="tab">|</a></li>
                        <li ng-mouseover="selectCategory(n.Id, n.SubCategories[0].Id)" ng-repeat-end=""><a class="links-title nav-links" data-toggle="tab" ng-class="{'category-active': isCategorySelected(n.Id)}">About Accenture</a></li>end ngRepeat: n in navLinks<li ng-repeat-start="n in navLinks"><a class="links-divider" data-toggle="tab">|</a></li>
                        <li ng-mouseover="selectCategory(n.Id, n.SubCategories[0].Id)" ng-repeat-end=""><a class="links-title nav-links" data-toggle="tab" ng-class="{'category-active': isCategorySelected(n.Id)}">Stay Connected</a></li>end ngRepeat: n in navLinks

                        <li ng-show="azLinks &amp;&amp; azLinks.SubCategories"><a class="links-divider" data-toggle="tab">|</a></li>
                        <li ng-show="azLinks &amp;&amp; azLinks.SubCategories" ng-mouseover="selectCategory('AtoZ','A')"><a class="links-title nav-links" data-toggle="tab" ng-class="{'category-active': isCategorySelected('AtoZ')}">A to Z</a></li>
                    </ul>
                </div> -->


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
