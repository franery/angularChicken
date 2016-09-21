package ar.com.escuelita.chicken.presentacion.rest;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.NegocioExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.presentacion.controlador.Controlador;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.validacion.MovimientoValidacion;

@RestController
public class MovimientosControladorRest extends Controlador{
	
	@Autowired
	private IMovimientoServicio movimientoServicio;
	
	@Autowired
	private MovimientoValidacion movimientoValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof MovimientoDTO){
		binder.setValidator(movimientoValidacion);
		}
    }
	
	@RequestMapping(path="/movimientosJson")
	public HashMap<String, Collection<DTO>> movimientosJson() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "movimientosJson");
		MovimientoFiltro m = new MovimientoFiltro();
		m.setProductorId(Long.parseLong(usuario.getId()));
		HashMap<String, Collection<DTO>> movimientosJson = new HashMap<String, Collection<DTO>>();
		movimientosJson.put(Constantes.DATA, movimientoServicio.listar(m));
		return movimientosJson;
	}
	
	@RequestMapping(path="/movimientosNuevoJson")
	public Object movimientosNuevoJson(@RequestBody @Validated MovimientoDTO movimiento,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "movimientosNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		movimientoServicio.crear(movimiento);
		return null;
	}
	
	@RequestMapping("filtrando")
	public @ResponseBody HashMap<String, Collection<DTO>> filtrar(@RequestBody MovimientoFiltro filtro) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "filtrar");
		filtro.setProductorId(Long.parseLong(usuario.getId()));
		HashMap<String, Collection<DTO>> movimientosJson = new HashMap<String, Collection<DTO>>();
		movimientosJson.put(Constantes.DATA, movimientoServicio.listar(filtro));
		return movimientosJson;
	}
}