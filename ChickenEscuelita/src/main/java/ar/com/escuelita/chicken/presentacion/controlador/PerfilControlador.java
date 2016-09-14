package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
import ar.com.escuelita.chicken.base.enumerador.EnumPermiso;
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.negocio.servicios.IPermisoServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;

@Controller
public class PerfilControlador extends Controlador {
	
	private static final String PERFILES_VIEW = "perfiles/perfiles";
	private static final String PERFILES_NUEVO_VIEW = "perfiles/perfilNuevo";
	private static final String PERFILES_MODIFICAR_VIEW = "perfiles/perfilModificar";
	
	@Autowired IPerfilServicio perfilServicio;

	@Autowired IPermisoServicio permisoServicio;
	
	@RequestMapping(path="/perfiles")
	public ModelAndView perfiles() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		List<DTO> listaPerfiles = (List<DTO>)perfilServicio.listar();
		model.addObject("listaPerfiles",listaPerfiles);
		PerfilDTO perfil = new PerfilDTO();
		model.addObject("perfil", perfil);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PERFILES_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/perfilesBorrar")
	public ModelAndView borrarPerfil(@ModelAttribute("perfil") PerfilDTO perfil) {
		perfilServicio.borrar(perfil);
		return new ModelAndView("redirect:/perfiles");
	}
	
	@RequestMapping("/perfilesNuevo")
	public ModelAndView nuevoPerfil(){
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);		
		model.addObject("usuarioActual", usuario);
		PerfilDTO perfil = new PerfilDTO();
		model.addObject("perfil", perfil);
		model.addObject("listaPermisos",listaPermisos);
		model.addObject("listaOperaciones",EnumPermiso.values());
		model.addObject("listaModulos",EnumModulo.values());
		model.addObject("pageToLoad", PERFILES_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/perfilesModificar")
	public ModelAndView modificarPerfil(@ModelAttribute("perfil") PerfilDTO perfil) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("perfil", perfil);
		model.addObject("listaPermisos",listaPermisos);
		model.addObject("listaOperaciones",EnumPermiso.values());
		model.addObject("listaModulos",EnumModulo.values());
		model.addObject("pageToLoad", PERFILES_MODIFICAR_VIEW);
		return model;
	}
	
	@RequestMapping(path="/perfilesProcesarNuevo")
	public ModelAndView perfilesProcesarNuevo(@RequestParam("permisos")String permisos,
			@RequestParam("nombre")String nombre) throws Exception {
		perfilServicio.crear(permisos,nombre);
		return new ModelAndView("redirect:/perfiles");
	}

	@RequestMapping(path="/perfilesProcesarModificar")
	public ModelAndView perfilesProcesarModificar(@ModelAttribute("perfil") PerfilDTO perfil) throws Exception {
		perfilServicio.modificar(perfil);
		return new ModelAndView("redirect:/perfiles");
	}
}