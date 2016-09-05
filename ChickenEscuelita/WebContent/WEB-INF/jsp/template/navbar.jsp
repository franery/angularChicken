<!DOCTYPE html>
<html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/navbar.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css" />

<jsp:include page="importacion.jsp"></jsp:include>
<body>

	<ul class="ul">
		<li class="liLeft" >${Title}</li>
		<li class="liRightHov"><a class="sup" href="<%=request.getContextPath()%>/index.jsp">Logout</a></li>
		<li class="liRight">${Nombre}</li>
	</ul>
<br>
</body>
</html>
