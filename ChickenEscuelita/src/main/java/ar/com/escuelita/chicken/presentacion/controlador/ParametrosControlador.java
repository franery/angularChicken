package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;

@Controller
public class ParametrosControlador extends Controlador {
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@RequestMapping(path="/parametros")
	public ModelAndView parametrosList() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametrosControlador.class, "parametrosList");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		ParametroDTO parametro = new ParametroDTO();
		List<DTO> listaParametros = (List<DTO>)parametroServicio.listar();
		model.addObject("listaParametros",listaParametros);
		model.addObject("parametro", parametro);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", Constantes.PARAMETROS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/parametrosBorrar")
	public ModelAndView borrarParametro(@ModelAttribute("parametro") ParametroDTO parametro ) {
		parametroServicio.borrar(parametro);
		return new ModelAndView("redirect:/parametros");
	}
	
	@RequestMapping(path="/parametrosModificar")
	public ModelAndView modificarParametro(@ModelAttribute("parametro") ParametroDTO parametro) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametrosControlador.class, "modificarParametro");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("parametro", parametro);
		model.addObject("pageToLoad", Constantes.PARAMETRO_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping("/parametrosNuevo")
	public ModelAndView nuevoParametro( ){
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", ParametrosControlador.class, "nuevoParametro");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		ParametroDTO parametro = new ParametroDTO();
		model.addObject("parametro", parametro);
		model.addObject("pageToLoad", Constantes.PARAMETRO_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/parametrosProcesarNuevo")
	public ModelAndView parametrosNuevo(@ModelAttribute("parametro") ParametroDTO parametro) throws Exception {
		parametroServicio.crear(parametro);
		return new ModelAndView("redirect:/parametros");
	}
	
	@RequestMapping(path="/parametrosProcesarModificar")
	public ModelAndView parametrosModificar(@ModelAttribute("parametro") ParametroDTO parametro) throws Exception {
		parametroServicio.modificar(parametro);
		return new ModelAndView("redirect:/parametros");
	}
}