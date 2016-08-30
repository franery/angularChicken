package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
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
	private static final String ADMIN_VIEW = "administrador/principal";
	private static final String VACIA_VIEW = "vacia";
	private static final String USUARIONUEVO_VIEW = "administrador/usuarioNuevo";
	
	
	@RequestMapping(path="/principalAdmin")
	public ModelAndView inicioAdmin() {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		model.addObject("pageToLoad", VACIA_VIEW);
		model.addObject("usuarioActual", usuario);
		return model;
	}
	
	
	@RequestMapping(path="/parametros")
	public ModelAndView parametros() {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		ParametroDTO parametroDto = new ParametroDTO();
		model.addObject("parametro", parametroDto);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios() {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioBorrar", usuarioDto);

		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/borrarUsuario")
	public ModelAndView borrarUsuario(@ModelAttribute("usuarioBorrar") UsuarioDTO usuarioB ) {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
		usuarioServicio.borrar(usuarioB);

		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioBorrar", usuarioDto);

		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}
	
	@RequestMapping("NuevoUsuario")
	public ModelAndView NuevoUsuario(){
		ModelAndView model = new ModelAndView(ADMIN_VIEW);

		model.addObject("usuarioActual", usuario);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioNuevo", usuarioDto);
		
		model.addObject("perfiles",EnumPerfil.values());

		model.addObject("pageToLoad", USUARIONUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="NuevoUsuarioPost")
	public ModelAndView AltaUsuario(@ModelAttribute("usuarioNuevo")UsuarioDTO usuarioNuevo){
		usuarioServicio.crear(usuarioNuevo);

		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioBorrar", usuarioDto);

		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}
}
