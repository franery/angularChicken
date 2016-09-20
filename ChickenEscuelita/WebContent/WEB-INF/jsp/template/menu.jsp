<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
</head>
<body>
	

<!-- Menu General -->
	
	 <div class="sidebar-nav">
      <div class="navbar navbar-default navbar-center" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span class="visible-xs navbar-brand">Menu</span>
        </div>
        <div class="navbar-collapse collapse sidebar-navbar-collapse">
          <ul class="nav navbar-nav">
	            <li class="active"><c:forEach items="${listaPermisos}" var="permiso">
							<!-- link -->
							<form:form action="${permiso}" method="post" >
								<li><input class="menu" type="submit" value=<spring:message code="${permiso}"/> /></li>
							</form:form>
						</c:forEach>
					</li>
          </ul>
        </div>
   </div>
  </div>







</body>
</html>

	