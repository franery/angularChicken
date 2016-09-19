package ar.com.escuelita.chicken.presentacion.rest;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.presentacion.controlador.Controlador;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;

@RestController
public class MovimientosControladorRest extends Controlador{
	
	private static final String DATA = "data";
	
	@Autowired
	private IMovimientoServicio movimientoServicio;
	
	@RequestMapping(path="/movimientosJson")
	public HashMap<String, Collection<DTO>> movimientos() {
		MovimientoFiltro m = new MovimientoFiltro();
		m.setProductorId(Long.parseLong(usuario.getId()));
		HashMap<String, Collection<DTO>> movimientosJson = new HashMap<String, Collection<DTO>>();
		movimientosJson.put(DATA, movimientoServicio.listar(m));
		return movimientosJson;
	}
	
	@RequestMapping("filtrando")
	public @ResponseBody HashMap<String, Collection<DTO>> filtrar(@RequestBody MovimientoFiltro filtro) {
		filtro.setProductorId(Long.parseLong(usuario.getId()));
		HashMap<String, Collection<DTO>> movimientosJson = new HashMap<String, Collection<DTO>>();
		movimientosJson.put(DATA, movimientoServicio.listar(filtro));
		return movimientosJson;
	}
}