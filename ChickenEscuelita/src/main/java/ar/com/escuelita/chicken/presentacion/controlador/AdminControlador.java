package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import javassist.expr.Instanceof;

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
import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.validacion.UsuarioValidacion;

@Controller
public class AdminControlador extends Controlador{
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private UsuarioValidacion usuarioValidacion;
	
	private static final String USUARIOS_VIEW = "administrador/usuarios";
	private static final String USUARIO_NUEVO_VIEW = "administrador/usuarioNuevo";
	private static final String USUARIO_MODIFICAR_VIEW = "administrador/usuarioModificar";
	private static final String PARAMETROS_VIEW = "administrador/parametros";
	private static final String PARAMETRO_NUEVO_VIEW = "administrador/parametroNuevo";
	private static final String PARAMETRO_MODIFICAR_VIEW = "administrador/parametroModificar";
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof UsuarioDTO){
		binder.setValidator(usuarioValidacion);
		}
    }
	
	@RequestMapping(path="/principalAdmin")
	public ModelAndView inicioAdmin() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("pageToLoad", VACIA_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
//	USUARIOS
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
	
	@RequestMapping(path="/borrarUsuario")
	public ModelAndView borrarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM ) {
		usuarioServicio.borrar(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping("/NuevoUsuario")
	public ModelAndView NuevoUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioParam){
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		
		model.addObject("usuarioActual", usuario);
		UsuarioDTO usuarioNM;
		if (usuarioParam != null) {
			usuarioNM = usuarioParam;
		} else {
			usuarioNM = new UsuarioDTO();
		}
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",EnumModulo.values());
		model.addObject("pageToLoad", USUARIO_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/ModificarUsuario")
	public ModelAndView ModificarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("pageToLoad", USUARIO_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	//procesar nuevo usuario
	@RequestMapping(path="/usuariosProcesarNuevo")
	public ModelAndView usuariosProcesarNuevo(@ModelAttribute("usuarioNM") @Validated UsuarioDTO usuarioNM, 
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
				return NuevoUsuario(usuarioNM);
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
	
//	PARAMETROS
	@RequestMapping(path="/parametros")
	public ModelAndView parametrosList() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		ParametroDTO parametro = new ParametroDTO();
		List<DTO> listaParametros = (List<DTO>)parametroServicio.listar();
		model.addObject("listaParametros",listaParametros);
		model.addObject("parametro", parametro);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/borrarParametro")
	public ModelAndView borrarParametro(@ModelAttribute("parametro") ParametroDTO parametro ) {
	
		parametroServicio.borrar(parametro);
		return new ModelAndView("redirect:/parametros");
	}
	
	@RequestMapping("/NuevoParametro")
	public ModelAndView NuevoParametro( ){
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		ParametroDTO parametro = new ParametroDTO();
		model.addObject("parametro", parametro);
		model.addObject("pageToLoad", PARAMETRO_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	
	@RequestMapping(path="/ModificarParametro")
	public ModelAndView ModificarParametro(@ModelAttribute("parametro") ParametroDTO parametro) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("parametro", parametro);
		model.addObject("pageToLoad", PARAMETRO_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/parametrosNuevo")
	public ModelAndView parametrosNuevo(@ModelAttribute("parametro") ParametroDTO parametro) throws Exception {
			parametroServicio.crear(parametro);
		return new ModelAndView("redirect:/parametros");
	}
	
	@RequestMapping(path="/parametrosModificar")
	public ModelAndView parametrosModificar(@ModelAttribute("parametro") ParametroDTO parametro) throws Exception {
			parametroServicio.modificar(parametro);
		return new ModelAndView("redirect:/parametros");
	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception ex,HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(ex.getMessage());
//		return new ModelAndView();
//	}
}
