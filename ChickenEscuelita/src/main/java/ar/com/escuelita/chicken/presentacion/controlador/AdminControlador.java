package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class AdminControlador extends Controlador{
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String USUARIOS_VIEW = "administrador/usuarios";
	private static final String PARAMETROS_VIEW = "administrador/parametros";
	private static final String PRINCIPAL_VIEW = "administrador/principal";
	private static final String VACIA_VIEW = "vacia";

	
	@RequestMapping(path="/principalAdmin")
	public ModelAndView inicioAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("pageToLoad", VACIA_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
		
	
	@RequestMapping(path="/parametros")
	public ModelAndView parametros(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		ParametroDTO parametroDto = new ParametroDTO();
		model.addObject("parametro", parametroDto);
		model.addObject("usuarioUsuarioActual", user);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioNuevo", usuarioDto);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}
	
}
