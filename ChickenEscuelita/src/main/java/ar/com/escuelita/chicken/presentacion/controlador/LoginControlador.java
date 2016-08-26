package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class LoginControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login/login");
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
		return model;
	}
	
	@RequestMapping(path="/ingresar")
	public ModelAndView loginVerificacion(@ModelAttribute("usuario") UsuarioDTO user) {
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		for(DTO usuarioDto : listaUsuarios) {
			if(((UsuarioDTO)usuarioDto).getNombreUsuario().equals(user.getNombreUsuario()) && ((UsuarioDTO)usuarioDto).getContrasenia().equals(user.getContrasenia())) {
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EnumPerfil.PRODUCTOR)) {
					ModelAndView model = new ModelAndView("productor/principal");
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EnumPerfil.CONTABLE)) {
					ModelAndView model = new ModelAndView("contable/principal");
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EnumPerfil.ADMINISTRADOR)) {
					ModelAndView model = new ModelAndView("administrador/principal");
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
			}
		}
		
		ModelAndView model = new ModelAndView("login/login");
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
		return model;
	}
}
