package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;

@Controller
public class ProductorControlador extends Controlador {

	private static final String REPORTES_VIEW = "productor/reportes";
	private static final String NUEVO_MOVIMIENTO_VIEW = "productor/nuevoMovimiento";
	
	@Autowired
	IMovimientoServicio movimientoServicio;
	
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
	
	@RequestMapping("nuevoMovimiento")
	public ModelAndView nuevoMovimiento() {
		ModelAndView model;
		if (usuario.getPerfil().equals(EnumPerfil.PRODUCTOR)){
			model = new ModelAndView(PRODUCTOR_VIEW);
		} else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", NUEVO_MOVIMIENTO_VIEW);
		return model;
	}
	
}
