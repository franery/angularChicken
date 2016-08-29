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
public class ContableControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String CONTABLE_VIEW = "contable/principal";
	
	@RequestMapping(path="/principal")
	public ModelAndView inicio(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(CONTABLE_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	@RequestMapping(path="/proveedores")
	public ModelAndView proveedores(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PROVEEDORES_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	/*
	@RequestMapping(path="/ingresar")
	public ModelAndView loginVerificacion(@ModelAttribute("usuario") UsuarioDTO user) {
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		for(DTO usuarioDto : listaUsuarios) {
			if(((UsuarioDTO)usuarioDto).getNombreUsuario().equals(user.getNombreUsuario()) && ((UsuarioDTO)usuarioDto).getContrasenia().equals(user.getContrasenia())) {
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EnumPerfil.PRODUCTOR)) {
					ModelAndView model = new ModelAndView(PRODUCTOR_VIEW);
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EnumPerfil.CONTABLE)) {
					ModelAndView model = new ModelAndView(CONTABLE_VIEW);
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
				if(((UsuarioDTO)usuarioDto).getPerfil().equals(EnumPerfil.ADMINISTRADOR)) {
					ModelAndView model = new ModelAndView(ADMIN_VIEW);
					model.addObject("usuarioActual", (UsuarioDTO)usuarioDto);
					return model;
				}
			}
		}
		
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
		return model;
	}
	*/
}
