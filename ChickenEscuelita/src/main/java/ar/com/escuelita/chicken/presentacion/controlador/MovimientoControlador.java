package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.DepositoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.GallineroFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;
import ar.com.escuelita.chicken.presentacion.validacion.MovimientoValidacion;

@Controller
public class MovimientoControlador extends Controlador {

	@Autowired
	private IDepositoServicio depositoServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private IMovimientoServicio movimientoServicio;
	
	@Autowired
	private IGallineroServicio gallineroServicio;

	@Autowired
	private MovimientoValidacion movimientoValidacion;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientoControlador.class, "initBinder");
		if (binder.getTarget() instanceof MovimientoDTO){
			binder.setValidator(movimientoValidacion);
		}
	}
	
	@RequestMapping(path="/movimientos")
	public ModelAndView movimientos() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientoControlador.class, "movimientos");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		MovimientoFiltro m = new MovimientoFiltro();
		m.setProductorId(Long.parseLong(usuario.getId()));
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", Constantes.REPORTES_VIEW);
		model.addObject("filtro",m);
		model.addObject("listaMovimientos",movimientoServicio.listar(m));
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/produccion")
	public ModelAndView produccion(@ModelAttribute("usuarioFiltro") UsuarioFiltro usuarioFiltro, @ModelAttribute("depositoFiltro") 
	DepositoFiltro depositoFiltro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientoControlador.class, "produccion");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		// Tabla Depositos | Stock Huevos
		//model.addObject("listaDepositos", depositoServicio.listar(depositoFiltro));
		model.addObject("listaDepositosDropDown", depositoServicio.listar());
		// Tabla Productores | Total Produccion
		//model.addObject("hashTotales", usuarioServicio.getTotalesProduccion(usuarioFiltro));
		model.addObject("listaProductoresDropDown", usuarioServicio.listar());
		model.addObject("pageToLoad", Constantes.PRODUCCION_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="movimientosFiltro")
	public ModelAndView reportesConFiltro(@ModelAttribute("filtro") MovimientoFiltro filtro) {
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", Constantes.REPORTES_VIEW);
		filtro.setProductorId(Long.parseLong(usuario.getId()));
		model.addObject("listaMovimientos",movimientoServicio.listar(filtro));
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping("movimientosNuevo")
	public ModelAndView nuevoMovimiento(@ModelAttribute("movimiento") MovimientoDTO movimientoDto) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", MovimientoControlador.class, "nuevoMovimiento");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("movimiento", movimientoDto);
		model.addObject("listaDepositos", depositoServicio.listar());
		GallineroFiltro gallineroFiltro = new GallineroFiltro();
		gallineroFiltro.setUsuarioId(Long.parseLong(usuario.getId()));
		model.addObject("listaGallineros", gallineroServicio.listar(gallineroFiltro));
		model.addObject("pageToLoad", Constantes.NUEVO_MOVIMIENTO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="movimientosProcesarNuevo")
	public ModelAndView crearNuevoMovimiento(@ModelAttribute("movimiento") @Validated MovimientoDTO movimientoDto,
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return nuevoMovimiento(movimientoDto);
		}
		movimientoServicio.crear(movimientoDto);
		return new ModelAndView("redirect:/movimientos");
	}
}
