package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.base.excepciones.NegocioExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IUsuarioValidacionServicio;
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
	private static final String PARAMETROS_VIEW = "administrador/parametros";
	private static final String PARAMETRO_NUEVO_VIEW = "administrador/parametroNuevo";
	private static final String VACIA_VIEW = "vacia";
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		binder.setValidator(usuarioValidacion);
    }
	
	@RequestMapping(path="/principalAdmin")
	public ModelAndView inicioAdmin() {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("pageToLoad", VACIA_VIEW);
		model.addObject("usuarioActual", usuario);
		return model;
	}
	
//	USUARIOS
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios() {
		ModelAndView model = new ModelAndView(obtenerVista());
		
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioNM = new UsuarioDTO();
		model.addObject("usuarioNM", usuarioNM);
		
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/borrarUsuario")
	public ModelAndView borrarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM ) {
		
		usuarioServicio.borrar(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping("/NuevoUsuario")
	public ModelAndView NuevoUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioParam){
		ModelAndView model = new ModelAndView(obtenerVista());
		
		model.addObject("usuarioActual", usuario);
		UsuarioDTO usuarioNM;
		if (usuarioParam != null) {
			usuarioNM = usuarioParam;
		} else {
			usuarioNM = new UsuarioDTO();
		}
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",EnumPerfil.values());
		
		model.addObject("flagNuevoModificar", NUEVO);
		
		model.addObject("pageToLoad", USUARIO_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ModificarUsuario")
	public ModelAndView ModificarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flagNuevoModificar", MODIFICAR);
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",EnumPerfil.values());

		model.addObject("pageToLoad", USUARIO_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/usuariosModificarNuevo")
	public ModelAndView usuariosModificarNuevo(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM, 
			@RequestParam("flagNuevoModificar") int flagNuevoModificar,
			@Valid UsuarioDTO usuarioDTO,
			final RedirectAttributes redirectAttributes,
			BindingResult result) {
		System.out.println("C");
		if (result.hasErrors()) {
			System.out.println("FASDKNKASLKDNASLKDNASLKNDLKASND");
			if(flagNuevoModificar == MODIFICAR) {
				return ModificarUsuario(usuarioNM);
			} else {	
				return NuevoUsuario(usuarioNM);
			}
		}
		try {
		System.out.println("D");
		if(flagNuevoModificar == MODIFICAR) {
			usuarioServicio.modificar(usuarioNM);
		} else {	
			usuarioServicio.crear(usuarioNM);
		}
		}
		catch (Exception e) {
			System.out.println("Chupala");
		}
//		
//		try {
//
//		} catch (NegocioExcepcion e) {
//			redirectAttributes.addFlashAttribute("usuarioNM",usuarioNM);
//			if(flagNuevoModificar == MODIFICAR) {
//				return new ModelAndView("redirect:/ModificarUsuario");
//			} else {	
//				return new ModelAndView("redirect:/NuevoUsuario");
//			}
//			
//		}
		return new ModelAndView("redirect:/usuarios");
	}

//	PARAMETROS
	@RequestMapping(path="/parametros")
	public ModelAndView parametrosList() {
		ModelAndView model = new ModelAndView(obtenerVista());
		ParametroDTO parametro = new ParametroDTO();
		List<DTO> listaParametros = (List<DTO>)parametroServicio.listar();
		model.addObject("listaParametros",listaParametros);
		model.addObject("parametro", parametro);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/borrarParametro")
	public ModelAndView borrarParametro(@ModelAttribute("parametro") ParametroDTO parametro ) {
	
		parametroServicio.borrar(parametro);
		return new ModelAndView("redirect:/parametros");
	}
	
	@RequestMapping("/NuevoParametro")
	public ModelAndView NuevoParametro( @RequestParam("flagNuevoModificar") int flagNuevoModificar ){
		ModelAndView model = new ModelAndView(obtenerVista());
		
		model.addObject("usuarioActual", usuario);
		ParametroDTO parametro = new ParametroDTO();
		model.addObject("parametro", parametro);
		
		model.addObject("flagNuevoModificar", NUEVO);
		
		model.addObject("pageToLoad", PARAMETRO_NUEVO_VIEW);
		return model;
	}
	
	
	@RequestMapping(path="/ModificarParametro")
	public ModelAndView ModificarParametro(@ModelAttribute("parametro") ParametroDTO parametro, @RequestParam("flagNuevoModificar") int flagNuevoModificar) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flagNuevoModificar", MODIFICAR);
		model.addObject("parametro", parametro);

		model.addObject("pageToLoad", PARAMETRO_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/parametrosModificarNuevo")
	public ModelAndView parametrosModificarNuevo(@ModelAttribute("parametro") ParametroDTO parametro, @RequestParam("flagNuevoModificar") int flagNuevoModificar) throws Exception {
		if(flagNuevoModificar == MODIFICAR) {
			parametroServicio.modificar(parametro);
		}
		else {
			parametroServicio.crear(parametro);
		}
		return new ModelAndView("redirect:/parametros");
	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception ex,HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(ex.getMessage());
//		return new ModelAndView();
//	}
}
