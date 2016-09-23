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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.escuelita.chicken.base.constantes.Constantes;
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

	@Autowired IPerfilServicio perfilServicio;

	@Autowired IPermisoServicio permisoServicio;

	@Autowired
	private PerfilValidacion perfilValidacion;

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "initBinder");
		if (binder.getTarget() instanceof PerfilDTO){
			binder.setValidator(perfilValidacion);
		}
	}

	@RequestMapping(path="/perfiles")
	public ModelAndView perfiles() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "perfiles");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		List<DTO> listaPerfiles = (List<DTO>)perfilServicio.listar();
		model.addObject("listaPerfiles",listaPerfiles);
		PerfilDTO perfil = new PerfilDTO();
		model.addObject("perfil", perfil);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", Constantes.PERFILES_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}

	@RequestMapping(path="/perfilesBorrar")
	public ModelAndView borrarPerfil(@ModelAttribute("perfil") @Validated PerfilDTO perfil,
			BindingResult result) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "perfilesBorrar");
		if(result.hasErrors()) {
			return new ModelAndView("redirect:/perfiles");
		}
		perfilServicio.borrar(perfil);
		return new ModelAndView("redirect:/perfiles");
	}

	@RequestMapping("/perfilesNuevo")
	public ModelAndView nuevoPerfil(@ModelAttribute("perfil") @Validated PerfilDTO perfil, BindingResult result){
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "nuevoPerfil");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);		
		model.addObject("usuarioActual", usuario);
		model.addObject("perfil", perfil);
		model.addObject("listaPermisos",listaPermisos);
		model.addObject("tablaPermisos", permisoServicio.listar());
		model.addObject("listaOperaciones",EnumOperacion.values());
		model.addObject("listaModulos",EnumModulo.values());
		model.addObject("pageToLoad", Constantes.PERFILES_NUEVO_VIEW);
		return model;
	}

	@RequestMapping(path="/perfilesProcesarNuevo")
	public ModelAndView perfilesProcesarNuevo(@ModelAttribute("perfil") @Validated PerfilDTO perfil,
			BindingResult result,HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "perfilesProcesarNuevo");
		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView("redirect:/perfilesNuevo");
			redirectAttributes.addFlashAttribute("perfil", perfil);
			return model;
		}
		setPermisos(request, perfil);
		perfilServicio.crear(perfil);
		return new ModelAndView("redirect:/perfiles");
	}

	@RequestMapping(path="/perfilesModificar")
	public ModelAndView modificarPerfil(@ModelAttribute("perfil") PerfilDTO perfil) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "modificarPerfil");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("perfil", perfil);
		model.addObject("listaPermisos",listaPermisos);
		model.addObject("tablaPermisos", permisoServicio.listar());
		model.addObject("tablaPermisosUsuario",((PerfilDTO)perfilServicio.buscar(Long.parseLong(perfil.getId()))).getListaPermisos());
		model.addObject("listaOperaciones",EnumOperacion.values());
		model.addObject("listaModulos",EnumModulo.values());
		model.addObject("pageToLoad", Constantes.PERFILES_MODIFICAR_VIEW);
		return model;
	}

	@RequestMapping(path="/perfilesProcesarModificar")
	public ModelAndView perfilesProcesarModificar(@ModelAttribute("perfil") @Validated PerfilDTO perfil,
			BindingResult result,HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "perfilesProcesarModificar");
		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView("redirect:/perfilesModificar");
			redirectAttributes.addFlashAttribute("perfil", perfil);
			return model;
		}
		setPermisos(request,perfil);
		perfilServicio.modificar(perfil);
		return new ModelAndView("redirect:/perfiles");
	}

	private void setPermisos(HttpServletRequest request,PerfilDTO perfil) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilControlador.class, "setPermisos");
		List<PermisoDTO> listaNuevaPermisos = new ArrayList<>();
		Collection<DTO> listaPermisos = permisoServicio.listar();
		for (DTO dto : listaPermisos) {
			PermisoDTO permisoDto = (PermisoDTO) dto; 
			String id = (String) request.getParameter(permisoDto.getId());
			if (id!= null && !id.isEmpty()) {
				listaNuevaPermisos.add(permisoDto);
			}
		}
		perfil.setListaPermisos(listaNuevaPermisos);
	}
}