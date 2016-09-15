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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
import ar.com.escuelita.chicken.base.enumerador.EnumOperacion;
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.negocio.servicios.IPermisoServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;
import ar.com.escuelita.chicken.presentacion.validacion.PerfilValidacion;

@Controller
public class PerfilControlador extends Controlador {
	
	private static final String PERFILES_VIEW = "perfiles/perfiles";
	private static final String PERFILES_NUEVO_VIEW = "perfiles/perfilNuevo";
	private static final String PERFILES_MODIFICAR_VIEW = "perfiles/perfilModificar";
	
	@Autowired IPerfilServicio perfilServicio;

	@Autowired IPermisoServicio permisoServicio;
	
	@Autowired
	private PerfilValidacion perfilValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof PerfilDTO){
		binder.setValidator(perfilValidacion);
		}
    }
	
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
	public ModelAndView borrarPerfil(@ModelAttribute("perfil") @Validated PerfilDTO perfil,
			BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return perfiles();
		}
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
		
		Collection<DTO> listaPermisos = permisoServicio.listar();
		model.addObject("tablaPermisos", listaPermisos);
		model.addObject("listaOperaciones",EnumOperacion.values());
		model.addObject("listaModulos",EnumModulo.values());
		model.addObject("pageToLoad", PERFILES_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/perfilesProcesarNuevo")
	public ModelAndView perfilesProcesarNuevo(HttpServletRequest request) throws Exception {
		
		String nombre = (String) request.getParameter("nombre");
		List<PermisoDTO> listaNuevaPermisos = new ArrayList<>();
		
		Collection<DTO> listaPermisos = permisoServicio.listar();
		for (DTO dto: listaPermisos) {
			PermisoDTO permisoDto = (PermisoDTO) dto; 
			String id = (String) request.getParameter(permisoDto.getId());
			if (id != null && !id.isEmpty()) {
				System.out.println("ID:" + id);
				listaNuevaPermisos.add(permisoDto);
			}
		}
		PerfilDTO perfilNuevo = new PerfilDTO();
		perfilNuevo.setListaPermisos(listaNuevaPermisos);
		perfilNuevo.setNombre(nombre);
		perfilServicio.crear(perfilNuevo);
		return new ModelAndView("redirect:/perfiles");
	}
	
	
	
	
	@RequestMapping(path="/perfilesModificar")
	public ModelAndView modificarPerfil(@ModelAttribute("perfil") PerfilDTO perfil) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("perfil", perfil);
		model.addObject("listaPermisos",listaPermisos);
		model.addObject("tablaPermisos", permisoServicio.listar());
		model.addObject("tablaPermisosUsuario",((PerfilDTO)perfilServicio.buscar(Long.parseLong(perfil.getId()))).getListaPermisos());
		model.addObject("listaOperaciones",EnumOperacion.values());
		model.addObject("listaModulos",EnumModulo.values());
		
		
		
		model.addObject("pageToLoad", PERFILES_MODIFICAR_VIEW);
		return model;
	}

	@RequestMapping(path="/perfilesProcesarModificar")
	public ModelAndView perfilesProcesarModificar(@ModelAttribute("perfil") @Validated PerfilDTO perfil,
			HttpServletRequest request,BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return modificarPerfil(perfil);
		}
		List<PermisoDTO> listaNuevaPermisos = new ArrayList<>();
		
		Collection<DTO> listaPermisos = permisoServicio.listar();
		for (DTO dto: listaPermisos) {
			PermisoDTO permisoDto = (PermisoDTO) dto; 
			String id = (String) request.getParameter(permisoDto.getId());
			if (id!= null && !id.isEmpty()) {
				listaNuevaPermisos.add(permisoDto);
			}
		}
		perfil.setListaPermisos(listaNuevaPermisos);
		perfilServicio.modificar(perfil);
		return new ModelAndView("redirect:/perfiles");
	}
}