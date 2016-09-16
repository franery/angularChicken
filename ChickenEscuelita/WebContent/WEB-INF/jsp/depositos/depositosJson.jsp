<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../template/importacion.jsp"></jsp:include>

<title>DepositosJson</title>
</head>
<body>

<table id="tablita" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th><spring:message code="nombre"/></th>
				<th><spring:message code="stock"/></th>
				<th><spring:message code="stockMax"/></th>
				<th></th>
				<th></th>
            </tr>
        </thead>
    </table>

<script>

$(document).ready(function(){
	$('#tablita').DataTable( {
		ajax: "depositosJson",
	    columns: [
	              { data: "nombre" },
	              { data: "stockHuevos" },
	              { data: "stockMaximo" }
	              ]
	});
});

</script>

</body>
</html>