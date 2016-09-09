package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

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
	private static final String ADMIN_VIEW = "administrador/principal";
	private static final String CONTABLE_VIEW = "contable/principal";
	private static final String PRODUCTOR_VIEW = "productor/principal";
	private static final String VACIA_VIEW = "vacia";
	
	@RequestMapping("/inicio")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
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
		if((usuarioDto).getPerfil().equals(EnumPerfil.PRODUCTOR)) {
			return new ModelAndView("redirect:/principalProductor");
		}
		if((usuarioDto).getPerfil().equals(EnumPerfil.CONTABLE)) {
			return new ModelAndView("redirect:/principalContable");
		}
		if((usuarioDto).getPerfil().equals(EnumPerfil.ADMINISTRADOR)) {
			return new ModelAndView("redirect:/principalAdmin");
		}
		ModelAndView model = new ModelAndView("redirect:/vacia.jsp");
		return model;
	}
}
