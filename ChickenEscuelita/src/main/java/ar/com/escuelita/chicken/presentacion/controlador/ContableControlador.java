package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class ContableControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String PRINCIPAL_VIEW = "contable/principal";
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String GALLINEROS_VIEW = "contable/gallineros";
	private static final String DEPOSITOS_VIEW = "contable/depositos";
	private static final String VENTAS_VIEW = "contable/ventas";
	private static final String PRODUCCION_VIEW = "contable/produccion";
	private static final String VACIA_VIEW = "vacia";
	
	@RequestMapping(path="/principal")
	public ModelAndView inicioContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", VACIA_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresContable")
	public ModelAndView proveedoresContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	
	@RequestMapping(path="/gallinerosContable")
	public ModelAndView gallinerosContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", GALLINEROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/depositosContable")
	public ModelAndView depositosContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", DEPOSITOS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ventasContable")
	public ModelAndView ventasContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", VENTAS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/produccionContable")
	public ModelAndView produccionContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", PRODUCCION_VIEW);
		return model;
	}
}
