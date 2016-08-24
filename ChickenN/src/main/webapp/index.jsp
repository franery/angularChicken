<%@page import="com.chicken.presentacion.bean.dto.ParametroDTO"%>
<%@page import="com.chicken.negocio.servicios.impl.ParametroServicioImpl"%>
<html>
<body>
<h2>Hello World!</h2>
<%ParametroServicioImpl p = new ParametroServicioImpl();
	ParametroDTO pd = new ParametroDTO();
	pd.setDescripcion("LALALA");
	pd.setValor("!!!!");
	p.crear(pd);
	%>
</body>
</html>
