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
        <thead class=depo_name>
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

	    "aoColumnDefs":[{
	                  "nombre":"nombre"
	                , "aTargets": [ "nombre" ]
	            },{
	                  "aTargets": [ 1 ]
	                , "bSortable": false
	                , "mRender": function ( url, type, full )  {
	                    return  '<a href="'+url+'">' + url + '</a>';
	                }
	            },{
	                  "aTargets":[ 3 ]
	                , "sType": "date"
	                , "mRender": function(date, type, full) {
	                    return (full[2] == "Blog") 
	                              ? new Date(date).toDateString()
	                              : "N/A" ;
	                }  
	            }]
	              
	});
});

</script>

</body>
</html>