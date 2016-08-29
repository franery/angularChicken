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
	
	private static final String CONTABLE_VIEW = "contable/principal";
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String GALLINEROS_VIEW = "contable/gallineros";
	private static final String DEPOSITOS_VIEW = "contable/depositos";
	private static final String VENTAS_VIEW = "contable/ventas";
	private static final String PRODUCCION_VIEW = "contable/produccion";
	
	@RequestMapping(path="/principal")
	public ModelAndView inicioContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(CONTABLE_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	@RequestMapping(path="/proveedores")
	public ModelAndView proveedoresContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PROVEEDORES_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	@RequestMapping(path="/gallineros")
	public ModelAndView gallinerosContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(GALLINEROS_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	@RequestMapping(path="/depositos")
	public ModelAndView depositosContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(DEPOSITOS_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	@RequestMapping(path="/ventas")
	public ModelAndView ventasContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(VENTAS_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	@RequestMapping(path="/produccion")
	public ModelAndView produccionContable(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRODUCCION_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
}
