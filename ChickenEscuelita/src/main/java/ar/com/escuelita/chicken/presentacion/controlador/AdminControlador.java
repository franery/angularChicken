package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class AdminControlador extends Controlador{
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String ADMIN_VIEW = "administrador/principal";
	private static final String USUARIOS_VIEW = "administrador/usuarios";
	private static final String USUARIO_NUEVO_VIEW = "administrador/usuarioNuevo";
	private static final String PARAMETROS_VIEW = "administrador/parametros";
	private static final String PARAMETRO_NUEVO_VIEW = "administrador/parametroNuevo";
	private static final String VACIA_VIEW = "vacia";
	
	
	@RequestMapping(path="/principalAdmin")
	public ModelAndView inicioAdmin() {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		model.addObject("pageToLoad", VACIA_VIEW);
		model.addObject("usuarioActual", usuario);
		return model;
	}
	
//	USUARIOS
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios() {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
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
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
		usuarioServicio.borrar(usuarioNM);

		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioNM", usuarioDto);

		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}
	
	@RequestMapping("/NuevoUsuario")
	public ModelAndView NuevoUsuario( @RequestParam("flagNuevoModificar") int flagNuevoModificar ){
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
		model.addObject("usuarioActual", usuario);
		UsuarioDTO usuarioNM = new UsuarioDTO();
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",EnumPerfil.values());
		
		model.addObject("flagNuevoModificar", flagNuevoModificar);
		
		model.addObject("pageToLoad", USUARIO_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ModificarUsuario")
	public ModelAndView ModificarUsuario(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM, @RequestParam("flagNuevoModificar") int flagNuevoModificar) {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("flagNuevoModificar", flagNuevoModificar);
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",EnumPerfil.values());

		model.addObject("pageToLoad", USUARIO_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/usuariosModificarNuevo")
	public ModelAndView proveedoresCrearNuevo(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM, @RequestParam("flagNuevoModificar") int flagNuevoModificar) {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		if(flagNuevoModificar == 0) {
			usuarioServicio.modificar(usuarioNM);
		}
		else {
			usuarioServicio.crear(usuarioNM);
		}
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaUsuarios", listaUsuarios);
		
		model.addObject("usuarioNM", new UsuarioDTO());
		model.addObject("perfiles",EnumPerfil.values());

		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}

//	PARAMETROS
	@RequestMapping(path="/parametros")
	public ModelAndView parametros() {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		ParametroDTO parametro = new ParametroDTO();
//		List<DTO> listaParametros = (List<DTO>)parametroServicio.listar();
		model.addObject("listaParametros",parametroServicio.listar());
		model.addObject("parametro", parametro);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/borrarParametro")
	public ModelAndView borrarParametro(@ModelAttribute("parametro") ParametroDTO parametro ) {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		parametroServicio.borrar(parametro);
		List<DTO> listaParametros = (List<DTO>)parametroServicio.listar();
		ParametroDTO parametroDto = new ParametroDTO();
		model.addObject("listaParametros",listaParametros);
		model.addObject("parametro", parametroDto);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
	
	@RequestMapping("/NuevoParametro")
	public ModelAndView NuevoParametro( @RequestParam("flagNuevoModificar") int flagNuevoModificar ){
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		
		model.addObject("usuarioActual", usuario);
		ParametroDTO parametro = new ParametroDTO();
		model.addObject("parametro", parametro);
		
		model.addObject("flagNuevoModificar", flagNuevoModificar);
		
		model.addObject("pageToLoad", PARAMETRO_NUEVO_VIEW);
		return model;
	}
	
	
	@RequestMapping(path="/ModificarParametro")
	public ModelAndView ModificarParametro(@ModelAttribute("parametro") ParametroDTO parametro, @RequestParam("flagNuevoModificar") int flagNuevoModificar) {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("flagNuevoModificar", flagNuevoModificar);
		model.addObject("parametro", parametro);

		model.addObject("pageToLoad", PARAMETRO_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/parametrosModificarNuevo")
	public ModelAndView proveedoresCrearNuevo(@ModelAttribute("parametro") ParametroDTO parametro, @RequestParam("flagNuevoModificar") int flagNuevoModificar) {
		ModelAndView model = new ModelAndView(ADMIN_VIEW);
		if(flagNuevoModificar == 0) {
			parametroServicio.modificar(parametro);
		}
		else {
			parametroServicio.crear(parametro);
		}
		List<DTO> listaParametros = (List<DTO>)parametroServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaParametros", listaParametros);
		
		model.addObject("parametro", new ParametroDTO());

		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
}
