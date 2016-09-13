package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;

@Controller
public class ParametrosControlador extends Controlador {
	
	@Autowired
	private IParametroServicio parametroServicio;
		
	private static final String PARAMETROS_VIEW = "parametros/parametros";
	private static final String PARAMETRO_NUEVO_VIEW = "parametros/parametroNuevo";
	private static final String PARAMETRO_MODIFICAR_VIEW = "parametros/parametroModificar";
	
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
	
	@RequestMapping(path="/parametrosBorrar")
	public ModelAndView borrarParametro(@ModelAttribute("parametro") ParametroDTO parametro ) {
		parametroServicio.borrar(parametro);
		return new ModelAndView("redirect:/parametros");
	}
	
	@RequestMapping("/parametrosNuevo")
	public ModelAndView nuevoParametro( ){
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		ParametroDTO parametro = new ParametroDTO();
		model.addObject("parametro", parametro);
		model.addObject("pageToLoad", PARAMETRO_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	
	@RequestMapping(path="/parametrosModificar")
	public ModelAndView modificarParametro(@ModelAttribute("parametro") ParametroDTO parametro) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("parametro", parametro);
		model.addObject("pageToLoad", PARAMETRO_MODIFICAR_VIEW);
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