package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.validacion.UsuarioValidacion;

@Controller
public class UsuariosControlador extends Controlador {
		
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private UsuarioValidacion usuarioValidacion;
	
	@Autowired
	private IPerfilServicio perfilServicio;
	
	private static final String USUARIOS_VIEW = "usuarios/usuarios";
	private static final String USUARIO_NUEVO_VIEW = "usuarios/usuariosNuevo";
	private static final String USUARIO_MODIFICAR_VIEW = "usuarios/usuariosModificar";
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof UsuarioDTO){
		binder.setValidator(usuarioValidacion);
		}
    }
	
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioNM = new UsuarioDTO();
		model.addObject("usuarioNM", usuarioNM);		
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/usuariosBorrar")
	public ModelAndView borrarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM ) {
		usuarioServicio.borrar(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping("/usuariosNuevo")
	public ModelAndView nuevoUsuario(){
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		
		model.addObject("usuarioActual", usuario);
		UsuarioDTO usuarioNM = new UsuarioDTO();
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",perfilServicio.listar());
		model.addObject("pageToLoad", USUARIO_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/usuariosModificar")
	public ModelAndView ModificarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",perfilServicio.listar());
		model.addObject("pageToLoad", USUARIO_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	//procesar nuevo usuario
	@RequestMapping(path="/usuariosProcesarNuevo")
	public ModelAndView usuariosProcesarNuevo(@ModelAttribute("usuarioNM") @Validated UsuarioDTO usuarioNM, 
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
				return nuevoUsuario();
		}
		usuarioServicio.crear(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}

	//procesar modificar usuario
	@RequestMapping(path="/usuariosProcesarModificar")
	public ModelAndView usuariosProcesarModificar(@ModelAttribute("usuarioNM") @Validated UsuarioDTO usuarioNM, 
			BindingResult result) throws Exception {
		usuarioServicio.modificar(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}
	
}