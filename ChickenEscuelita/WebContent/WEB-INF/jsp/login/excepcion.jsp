<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<script type="text/javascript">
	function showError() {
		document.getElementById('error').style.visibility = 'visible';
 		document.getElementById('hide').style.visibility = 'visible';
	}
	function hideError() {
		document.getElementById('error').style.visibility = 'hidden';
 		document.getElementById('hide').style.visibility = 'hidden';
	}
	</script>
	<style type="text/css">
		table.title{
			border-radius: 4px;
			width: 50%;
			margin: auto;
		}
		td.title, div.title{
			font-family: verdana;
			font-size: 14px;
			font-weight: bold;
			color: #FFFFFF;
			background-color: #1081C7;
			border: 1px solid #ccc;
		}
		.error{
			color: red;
			font-weight: bold;
		}
		.divError {
			border: 1px solid #ccc;
			OVERFLOW: auto;
			width: 800px;
			height: 240px;
		}
		 
	</style>  
</head>
<body>
	
	<div id="container">
		
		<div id="main">

			<div class="wrap">
				
				<div id="content">
					
					<div id="inside">
							<div class="alert alert-error">
								<strong><spring:message code="mensajeErrorAplicacion"/>!</strong><br/>
								<br><spring:message code="mensajeErrorTituloPagina"/><br>
							</div><br>
						
							<table class="title">
								<tr><td>
									<input id="details" type="button" value="Detalles" class="btn btn-primary btn-small"
										onclick="showError();" />
								</td></tr>
								<tr><td>
									<div id="error" style="visibility:hidden;">
										<div class="title" style="width:800px;"><spring:message code="mensajeErrorDescripion"/></div>
										<div style="width:800px; color:red;">${errorSpecified}</div>
										<div style="width:800px;">&nbsp;</div>
										<div class="title" style="width:800px;"><spring:message code="mensajeErrorDetalles"/></div>
										<div class="divError">${error}</div>
										<div>
											<input id="hide"
												class="btn btn-primary btn-small" 
												type="button" value="Ocultar" style="visibility:hidden;" onclick="hideError();">
										</div>
									</div>
								</td></tr>
							</table>
					</div>
					
				</div>

			</div>

		</div>

	</div>

</body>
</html>
