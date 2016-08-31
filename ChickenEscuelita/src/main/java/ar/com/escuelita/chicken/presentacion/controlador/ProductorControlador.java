package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Commit;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
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
		if (usuario.getPerfil().equals(EnumPerfil.PRODUCTOR)){
			model = new ModelAndView(PRODUCTOR_VIEW);
		} else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		MovimientoFiltro m = new MovimientoFiltro();
		m.setProductorId(usuario.getId());
		model.addObject("listaMovimientos",movimientoServicio.listar(m));
		return model;
	}
	
	@RequestMapping(path="reportesFiltro")
	public ModelAndView reportesConFiltro(@ModelAttribute("filtro") MovimientoFiltro filtro) {
		ModelAndView model;
		if (usuario.getPerfil().equals(EnumPerfil.PRODUCTOR)){
			model = new ModelAndView(PRODUCTOR_VIEW);
		} else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		filtro.setProductorId(usuario.getId());
		model.addObject("listaMovimientos",movimientoServicio.listar(filtro));
		return model;
	}
	
	@RequestMapping("nuevoMovimiento")
	public ModelAndView nuevoMovimiento() {
		ModelAndView model;
		if (usuario.getPerfil().equals(EnumPerfil.PRODUCTOR)){
			model = new ModelAndView(PRODUCTOR_VIEW);
		} else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("movimiento", new MovimientoDTO());
		model.addObject("listaDepositos", depositoServicio.listar());
		model.addObject("listaGallineros", gallineroServicio.listar());
		model.addObject("pageToLoad", NUEVO_MOVIMIENTO_VIEW);
		return model;
	}
	
	@RequestMapping(path="crearNuevoMovimiento")
	public ModelAndView crearNuevoMovimiento(@ModelAttribute("movimiento") MovimientoDTO movimientoDto) {
//		movimientoDto.setGallinero((GallineroDTO)gallineroServicio.buscar(movimientoDto.getGallinero().getId()));
//		movimientoDto.setDeposito((DepositoDTO)depositoServicio.buscar(movimientoDto.getDeposito().getId()));
		movimientoServicio.crear(movimientoDto);
		return new ModelAndView("redirect:/nuevoMovimiento");
	}
	
}
