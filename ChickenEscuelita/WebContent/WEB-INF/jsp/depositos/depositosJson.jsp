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
                <th>Nombre</th>
                <th>Stock Huevos</th>
                <th>Stock Maximo</th>
            </tr>
        </thead>
    </table>


<script>

var editor;

$(document).ready(function(){
	/*
	editor = new $.fn.dataTable.Editor( {
        //ajax: "depositosJson",
        table: "#tablita",
        fields: [ {
                label: "Nombre:",
                name: "nombre"
            }, {
                label: "Stock Huevos:",
                name: "stockHuevos"
            }, {
                label: "Stock Maximo:",
                name: "stockMaximo"
            }
        ]
    } );
	*/
	//$.getJSON('depositosJson', function(data) {
	 
	    $('#tablita').DataTable( {
	        //dom: "Bfrtip",
	        ajax: "depositosJson",
	        columns: [
	            { data: "nombre" },
	            { data: "stockHuevos" },
	            { data: "stockMaximo" }
	        ]
	    } );
		
	//});
});

</script>

</body>
</html>