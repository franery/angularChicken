package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class ProductorControlador extends Controlador {

	private static final String REPORTES_VIEW = "productor/reportes";
	private static final String NUEVO_MOVIMIENTO_VIEW = "productor/nuevoMovimiento";
	
	@RequestMapping("reportes")
	public ModelAndView reportes(@ModelAttribute("usuarioActual") UsuarioDTO usuario) {
		ModelAndView model;
		if (usuario.getPerfil().equals(EnumPerfil.PRODUCTOR)){
			model = new ModelAndView(PRODUCTOR_VIEW);
		} else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		return model;
	}
	
	@RequestMapping("nuevoMovimiento")
	public ModelAndView nuevoMovimiento(@ModelAttribute("usuarioActual") UsuarioDTO usuario) {
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
