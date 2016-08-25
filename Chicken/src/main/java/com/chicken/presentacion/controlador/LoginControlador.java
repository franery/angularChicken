package com.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chicken.base.dto.DTO;
import com.chicken.base.enumeradores.EPerfil;
import com.chicken.negocio.servicios.IUsuarioServicio;
import com.chicken.presentacion.bean.dto.UsuarioDTO;

@Controller
@RequestMapping("login")
public class LoginControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login/login");
		model.addObject("usuario", new UsuarioDTO());
		return model;
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public ModelAndView loginVerificacion(@ModelAttribute("usuario") UsuarioDTO user) {
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		for(DTO usuarioDto : listaUsuarios) {
			if(((UsuarioDTO)usuarioDto).getNombreUsuario().equals(user.getNombreUsuario()) && ((UsuarioDTO)usuarioDto).getContrasenia().equals(user.getContrasenia())) {
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EPerfil.PRODUCTOR)) {
					ModelAndView model = new ModelAndView("productor/principal");
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EPerfil.CONTABLE)) {
					ModelAndView model = new ModelAndView("contable/principal");
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EPerfil.ADMINISTRADOR)) {
					ModelAndView model = new ModelAndView("administrador/principal");
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
			}
		}
		return new ModelAndView("login/login");
	}
}
