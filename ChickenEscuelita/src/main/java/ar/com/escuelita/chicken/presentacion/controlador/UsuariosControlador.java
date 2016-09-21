package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.PerfilFiltro;
import ar.com.escuelita.chicken.presentacion.validacion.UsuarioValidacion;

@Controller
public class UsuariosControlador extends Controlador {
		
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private UsuarioValidacion usuarioValidacion;
	
	@Autowired
	private IPerfilServicio perfilServicio;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof UsuarioDTO){
		binder.setValidator(usuarioValidacion);
		}
    }
	
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios() {
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		
		List<DTO> listaUsuarios = (List<DTO>)usuarioServicio.listar();
		model.addObject("listaUsuarios",listaUsuarios);
		
		UsuarioDTO usuarioNM = new UsuarioDTO();
		model.addObject("usuarioNM", usuarioNM);		
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", Constantes.USUARIOS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/usuariosBorrar")
	public ModelAndView borrarUsuario(@ModelAttribute("usuarioNM") @Validated UsuarioDTO usuarioNM, 
			BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return usuarios();
		}
		usuarioServicio.borrar(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping("/usuariosNuevo")
	public ModelAndView usuariosNuevo(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM){
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		if (usuarioNM == null) {
			usuarioNM = new UsuarioDTO();
		}
		usuarioNM.setListaPerfiles(new ArrayList<PerfilDTO>());
		model.addObject("usuarioNM", usuarioNM);
		
		model.addObject("perfiles",perfilServicio.listar(new PerfilFiltro(Constantes.USUARIO_ROOT_ID)));
		model.addObject("pageToLoad", Constantes.USUARIO_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/usuariosModificar")
	public ModelAndView usuariosModificar(@ModelAttribute("usuarioNM") UsuarioDTO usuarioNM) {
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("usuarioNM", usuarioNM);
		model.addObject("perfiles",perfilServicio.listar(new PerfilFiltro(Constantes.USUARIO_ROOT_ID)));
		model.addObject("pageToLoad", Constantes.USUARIO_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	//procesar nuevo usuario
	@RequestMapping(path="/usuariosProcesarNuevo")
	public ModelAndView usuariosProcesarNuevo(HttpServletRequest request, @ModelAttribute("usuarioNM") @Validated UsuarioDTO usuarioNM, 
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return usuariosNuevo(usuarioNM);
		}
		List<PerfilDTO> listaNuevaPerfiles = obtenerListaPerfiles(request);
		usuarioNM.setListaPerfiles(listaNuevaPerfiles);
		usuarioServicio.crear(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}



	//procesar modificar usuario
	@RequestMapping(path="/usuariosProcesarModificar")
	public ModelAndView usuariosProcesarModificar(HttpServletRequest request, @ModelAttribute("usuarioNM") @Validated UsuarioDTO usuarioNM, 
			BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return usuariosModificar(usuarioNM);
		}
		List<PerfilDTO> listaNuevaPerfiles = obtenerListaPerfiles(request);
		usuarioNM.setListaPerfiles(listaNuevaPerfiles);
		usuarioServicio.modificar(usuarioNM);
		return new ModelAndView("redirect:/usuarios");
	}
	
	private List<PerfilDTO> obtenerListaPerfiles(HttpServletRequest request) {
		List<PerfilDTO> listaNuevaPerfiles = new ArrayList<>();
		Collection<DTO> listaPerfiles = perfilServicio.listar();
		for (DTO dto : listaPerfiles) {
			PerfilDTO perfilDTO = (PerfilDTO) dto;
			String id = (String) request.getParameter(perfilDTO.getId());
			if (id != null && !id.isEmpty()) {
				listaNuevaPerfiles.add(perfilDTO);
			}
		}
		return listaNuevaPerfiles;
	}	
}