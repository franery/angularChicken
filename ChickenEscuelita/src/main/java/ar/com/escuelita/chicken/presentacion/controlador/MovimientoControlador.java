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

import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.filtro.DepositoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.GallineroFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;
import ar.com.escuelita.chicken.presentacion.validacion.MovimientoValidacion;
import ar.com.escuelita.chicken.presentacion.validacion.PerfilValidacion;

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
	
	private static final String PRODUCCION_VIEW = "produccion/produccion";
	private static final String REPORTES_VIEW = "movimientos/reportes";
	private static final String NUEVO_MOVIMIENTO_VIEW = "movimientos/movimientosNuevo";
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof MovimientoDTO){
			binder.setValidator(movimientoValidacion);
		}
	}
	
	@RequestMapping(path="/produccion")
	public ModelAndView produccion(@ModelAttribute("usuarioFiltro") UsuarioFiltro usuarioFiltro, @ModelAttribute("depositoFiltro") 
	DepositoFiltro depositoFiltro) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		// Tabla Depositos | Stock Huevos
		model.addObject("listaDepositos", depositoServicio.listar(depositoFiltro));
		model.addObject("listaDepositosDropDown", depositoServicio.listar());
		// Tabla Productores | Total Produccion
		model.addObject("hashTotales", usuarioServicio.getTotalesProduccion(usuarioFiltro));
		model.addObject("listaProductoresDropDown", usuarioServicio.listarProductores());
		model.addObject("pageToLoad", PRODUCCION_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/movimientos")
	public ModelAndView movimientos() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		MovimientoFiltro m = new MovimientoFiltro();
		m.setProductorId(Long.parseLong(usuario.getId()));
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		model.addObject("filtro",m);
		model.addObject("listaMovimientos",movimientoServicio.listar(m));
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="movimientosFiltro")
	public ModelAndView reportesConFiltro(@ModelAttribute("filtro") MovimientoFiltro filtro) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		filtro.setProductorId(Long.parseLong(usuario.getId()));
		model.addObject("listaMovimientos",movimientoServicio.listar(filtro));
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping("movimientosNuevo")
	public ModelAndView nuevoMovimiento(@ModelAttribute("movimiento") MovimientoDTO movimientoDto) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("movimiento", movimientoDto);
		model.addObject("listaDepositos", depositoServicio.listar());
		GallineroFiltro gallineroFiltro = new GallineroFiltro();
		gallineroFiltro.setUsuarioId(Long.parseLong(usuario.getId()));
		model.addObject("listaGallineros", gallineroServicio.listar(gallineroFiltro));
		model.addObject("pageToLoad", NUEVO_MOVIMIENTO_VIEW);
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
