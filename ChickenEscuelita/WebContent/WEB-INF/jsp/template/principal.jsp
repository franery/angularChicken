<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../template/importacion.jsp"></jsp:include>
<title><spring:message code="nombreApp" /></title>
</head>
<body>
	<!-- NavBar -->
<%-- 	<c:set var="Title" scope="request" value="${usuarioActual.getListaPerfiles().get(0).getNombre()}"/> --%>
<c:set var="Nombre" value="${usuarioActual.getNombre() }" scope="request" />
<jsp:include page="../template/cabecera.jsp"></jsp:include>

<div class="container">
	<div class="text-center">
		<jsp:include page="../${pageToLoad}.jsp"></jsp:include>
	</div>
</div>

<jsp:include page="pieDePagina.jsp"></jsp:include>



<script type="text/javascript">
function i18n() {
	var objeto = {
		processing:     "<spring:message code='procesando'/>",
        search:         "<spring:message code='buscar'/>",
        lengthMenu:     "<spring:message code='tamanioMenu'/>",
        info:           "<spring:message code='info'/>",
        infoEmpty:      "<spring:message code='infoVacia'/>",
        infoFiltered:   "<spring:message code='infoFiltrada'/>",
        loadingRecords: "<spring:message code='cargandoRegistros'/>",
        zeroRecords:    "<spring:message code='ceroRegistros'/>",
        emptyTable:     "<spring:message code='noHayResultados'/>",
        paginate: {
            first:      "<spring:message code='primero'/>",
            previous:   "<spring:message code='anterior'/>",
            next:       "<spring:message code='siguiente'/>",
            last:       "<spring:message code='ultimo'/>"
            },
	};
	return objeto;
}
</script>
</body>
</html>