<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parametros</title>

</head>
<body>
		<!-- Nuevo Parametro -->
		<form:form action="NuevoParametro" method="post" commandName="parametro">
			<input type="hidden" name="flagNuevoModificar" value="1"/>
				<input type="submit" value=<spring:message code="nuevo" text="Nuevo"/> />
		</form:form>
		
		<!-- Tabla Parametros -->
		<table id="tablita">
			<thead>
				<tr>
					<th>Descripcion</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaParametros}">
					<c:forEach items="${listaParametros}" var="param">
						<tr>
							<td><c:out value="${param.getDescripcion() }"></c:out></td>
							<td><c:out value="${param.getValor() }"></c:out></td>
							<td><form:form action="borrarParametro" method="post" commandName="parametro">
								<form:input path="id" type="hidden" value="${param.getId() }"/>
								<input type="submit" value=<spring:message code="borrar" text="Borrar"/> />
							</form:form></td>
							<td>
							<form:form action="ModificarParametro" method="post" commandName="parametro">
								<form:input path="id" type="hidden" value="${param.getId() }"/>
								<form:input path="descripcion" type="hidden" value="${param.getDescripcion()}"/>
								<form:input path="valor" type="hidden" value="${param.getValor()}"/>
								<input type="hidden" name="flagNuevoModificar" value="0"/>
								<input type="submit" value=<spring:message code="modificar" text="Modificar"/> />
							</form:form>
				</td>
						 </tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty listaParametros}">
					<tr>
						<td colspan="5">No hay datos disponibles por el momento</td>
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