package ar.com.escuelita.chicken.presentacion.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.controlador.LoginControlador;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.DepositoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;
import ar.com.escuelita.chicken.presentacion.validacion.MovimientoValidacion;

@RestController
public class MovimientosControladorRest {
	
	@Autowired
	private IMovimientoServicio movimientoServicio;
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private MovimientoValidacion movimientoValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof MovimientoDTO){
		binder.setValidator(movimientoValidacion);
		}
    }
	
	@RequestMapping(path="/movimientosJson")
	public HashMap<String, Collection<DTO>> movimientosJson() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "movimientosJson");
		MovimientoFiltro m = new MovimientoFiltro();
		m.setProductorId(Long.parseLong(LoginControlador.usuario.getId()));
		HashMap<String, Collection<DTO>> movimientosJson = new HashMap<String, Collection<DTO>>();
		movimientosJson.put(Constantes.DATA, movimientoServicio.listar(m));
		return movimientosJson;
	}
	
	@RequestMapping(path="/movimientosNuevoJson")
	public Object movimientosNuevoJson(@RequestBody @Validated MovimientoDTO movimiento,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "movimientosNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		movimientoServicio.crear(movimiento);
		return null;
	}
	
	@RequestMapping("filtrarMovimientos")
	public @ResponseBody Collection<DTO> filtrarMovimientos(@RequestBody MovimientoFiltro filtro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "filtrar");
		filtro.setProductorId(Long.parseLong(LoginControlador.usuario.getId()));
		return movimientoServicio.listar(filtro);
	}
	
	@RequestMapping(path="/produccionDepositosJson")
	public HashMap<String, List<DTO>> produccionDepositosJson() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "produccionDepositosJson");
		HashMap<String, List<DTO>> produccionDepositosJson = new HashMap<String, List<DTO>>();
		produccionDepositosJson.put(Constantes.DATA, (List<DTO>)depositoServicio.listar());
		return produccionDepositosJson;
	}
	
	@RequestMapping(path="/produccionTotalesJson")
	public HashMap<String, List<HashMap<String, String>>> produccionTotalesJson() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "produccionTotalesJson");
		HashMap<String, List<HashMap<String, String>>> produccionTotalesJson = new HashMap<String, List<HashMap<String, String>>>();
		produccionTotalesJson.put(Constantes.DATA, usuarioServicio.getTotalesProduccion(null));
		return produccionTotalesJson;
	}
	
	@RequestMapping("filtrarDepositosProduccion")
	public @ResponseBody Collection<DTO> filtrarDepositosProduccion(@RequestBody DepositoFiltro filtro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "filtrar");
		return depositoServicio.listar(filtro);
	}
	
	@RequestMapping("filtrarTotalesProduccion")
	public @ResponseBody List<HashMap<String, String>> filtrarTotalesProduccion(@RequestBody UsuarioFiltro filtro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientosControladorRest.class, "filtrar");
		System.out.println("LLEGAMOS");
		return usuarioServicio.getTotalesProduccion(filtro);
	}
}