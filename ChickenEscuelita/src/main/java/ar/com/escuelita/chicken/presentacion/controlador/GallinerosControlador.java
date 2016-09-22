package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;

@Controller
public class GallinerosControlador extends Controlador {

	@Autowired
	private IGallineroServicio gallineroServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@RequestMapping(path="/gallineros")
	public ModelAndView gallineros() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControlador.class, "gallineros");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("gallinero",new GallineroDTO());
		model.addObject("listaGallineros",gallineroServicio.listar());
		model.addObject("pageToLoad", Constantes.GALLINEROS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}

	@RequestMapping(path="/gallinerosNuevo")
	public ModelAndView gallinerosNuevo() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControlador.class, "gallinerosNuevo");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("listaUsuarios",usuarioServicio.listar());
		model.addObject("gallinero", new GallineroDTO());
		model.addObject("pageToLoad", Constantes.GALLINEROS_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	

	@RequestMapping(path="/gallinerosModificar")
	public ModelAndView gallinerosModificar(@ModelAttribute("gallinero") GallineroDTO gallinero) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControlador.class, "gallinerosModificar");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("listaUsuarios",usuarioServicio.listar());
		model.addObject("gallinero", gallinero);
		model.addObject("pageToLoad", Constantes.GALLINEROS_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/gallinerosProcesarNuevo")
	public ModelAndView gallinerosProcesarNuevo(@ModelAttribute("gallinero") GallineroDTO gallinero) throws Exception {
		gallineroServicio.crear(gallinero);
		return new ModelAndView("redirect:/gallineros");
	}
	
	@RequestMapping(path="/gallinerosProcesarModificar")
	public ModelAndView gallinerosProcesarModificar(@ModelAttribute("gallinero") GallineroDTO gallinero) throws Exception {
		gallineroServicio.modificar(gallinero);
		return new ModelAndView("redirect:/gallineros");
	}
	
	@RequestMapping(path="/gallinerosBorrar")
	public ModelAndView gallinerosBorrar(@ModelAttribute("gallinero") GallineroDTO gallinero) {
		gallineroServicio.borrar(gallinero);
		return new ModelAndView("redirect:/gallineros");
	}
	
}
