package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class ProductorControlador extends Controlador {

	@RequestMapping("reportes")
	public ModelAndView reportes(@ModelAttribute("usuario") UsuarioDTO usuario) {
		ModelAndView model = new ModelAndView("productor/reportes");
		UsuarioDTO usuarioDto = new UsuarioDTO();
		System.out.println("LLEGUE????");
		model.addObject("usuario", usuarioDto);
		return model;
	}
	
}
