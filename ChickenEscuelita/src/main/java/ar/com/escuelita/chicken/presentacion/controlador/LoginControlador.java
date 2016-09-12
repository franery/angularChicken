package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

@Controller
public class LoginControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String LOGIN_VIEW = "login/login";
	
	@RequestMapping("/inicio")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
		return model;
	}
	
	@RequestMapping("/403")
	public ModelAndView accesoDenegado() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", "login/403");
		return model;
	}
	@RequestMapping(path="/ingresar")
	public ModelAndView loginVerificacion() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDTO usuarioDto = null;
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNombreUsuario(auth.getName());
		for (DTO usuarioDTO : usuarioServicio.listar(filtro)) {
			usuarioDto = (UsuarioDTO) usuarioDTO;
		}
		setUsuario(usuarioDto);
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual",usuario);
		return model;
	}
}
