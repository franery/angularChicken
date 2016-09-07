<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="parametros" text="Parametros"/></title>

</head>
<body>
		<!-- Nuevo Parametro -->
		<form:form action="NuevoParametro" method="post" commandName="parametro">
				<input type="submit" value=<spring:message code="nuevo"/> />
		</form:form>
		
		<!-- Tabla Parametros -->
		<table id="tablita">
			<thead>
				<tr>
					<th><spring:message code="descripcion"/></th>
					<th><spring:message code="valor"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaParametros}">
					<c:forEach items="${listaParametros}" var="parametroVar">
						<tr>
							<td><c:out value="${parametroVar.getDescripcion() }"></c:out></td>
							<td><c:out value="${parametroVar.getValor() }"></c:out></td>
							<td><c:set var="mensajeConfirmacion" scope="request">
								<spring:message code="mensajeConfirmacion"></spring:message>
							</c:set>
							<form:form action="borrarParametro" onsubmit="return confirm('${mensajeConfirmacion} ${parametroVar.getDescripcion()}?');" 
										method="post" commandName="parametro">
								<form:input path="id" type="hidden" value="${parametroVar.getId() }"/>
								<input type="submit" value=<spring:message code="borrar"/> />
							</form:form></td>
							<td>
							<form:form action="ModificarParametro" method="post" commandName="parametro">
								<form:input path="id" type="hidden" value="${parametroVar.getId() }"/>
								<form:input path="descripcion" type="hidden" value="${parametroVar.getDescripcion()}"/>
								<form:input path="valor" type="hidden" value="${parametroVar.getValor()}"/>
								<input type="hidden" name="flagNuevoModificar" value="0"/>
								<input type="submit" value=<spring:message code="modificar"/> />
							</form:form>
				</td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaParametros}">
					<tr>
						<td colspan="5"><spring:message code="noHayDatos"/></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div>
			<!-- <a class="btn btn-default" href="Nuevo" role="button">Nueva
				Mascota</a> -->
		</div>

</body>
</html>