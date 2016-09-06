package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.filtro.GallineroFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;

@Controller
public class ProductorControlador extends Controlador {

	private static final String REPORTES_VIEW = "productor/reportes";
	private static final String NUEVO_MOVIMIENTO_VIEW = "productor/nuevoMovimiento";
	
	@Autowired
	IMovimientoServicio movimientoServicio;
	
	@Autowired
	IGallineroServicio gallineroServicio;
	
	@Autowired
	IDepositoServicio depositoServicio;
	
	@RequestMapping("reportes")
	public ModelAndView reportes() {
		ModelAndView model;
		MovimientoFiltro m = new MovimientoFiltro();
		if (usuario.getPerfil().equals(EnumPerfil.PRODUCTOR)){
			model = new ModelAndView(PRODUCTOR_VIEW);
			m.setProductorId(Long.parseLong(usuario.getId()));
		} else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		model.addObject("filtro",m);
		model.addObject("listaMovimientos",movimientoServicio.listar(m));
		return model;
	}
	
	@RequestMapping(path="reportesFiltro")
	public ModelAndView reportesConFiltro(@ModelAttribute("filtro") MovimientoFiltro filtro) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		filtro.setProductorId(Long.parseLong(usuario.getId()));
		model.addObject("listaMovimientos",movimientoServicio.listar(filtro));
		return model;
	}
	
	@RequestMapping("nuevoMovimiento")
	public ModelAndView nuevoMovimiento() {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("movimiento", new MovimientoDTO());
		model.addObject("listaDepositos", depositoServicio.listar());
		GallineroFiltro gallineroFiltro = new GallineroFiltro();
		gallineroFiltro.setUsuarioId(Long.parseLong(usuario.getId()));
		model.addObject("listaGallineros", gallineroServicio.listar(gallineroFiltro));
		model.addObject("pageToLoad", NUEVO_MOVIMIENTO_VIEW);
		return model;
	}
	
	@RequestMapping(path="crearNuevoMovimiento")
	public ModelAndView crearNuevoMovimiento(@ModelAttribute("movimiento") MovimientoDTO movimientoDto) throws Exception {
//		movimientoDto.setGallinero((GallineroDTO)gallineroServicio.buscar(movimientoDto.getGallinero().getId()));
//		movimientoDto.setDeposito((DepositoDTO)depositoServicio.buscar(movimientoDto.getDeposito().getId()));
		movimientoServicio.crear(movimientoDto);
		return new ModelAndView("redirect:/reportes");
	}
	
}
