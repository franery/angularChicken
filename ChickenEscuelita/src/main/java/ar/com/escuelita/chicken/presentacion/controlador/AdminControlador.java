package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class AdminControlador extends Controlador{
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String USUARIOS_VIEW = "administrador/usuarios";
	private static final String PARAMETROS_VIEW = "administrador/parametros";
	private static final String PRINCIPAL_VIEW = "administrador/principal";
	private static final String VACIA_VIEW = "vacia";
//	links Contables
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String GALLINEROS_VIEW = "contable/gallineros";
	private static final String DEPOSITOS_VIEW = "contable/depositos";
	private static final String VENTAS_VIEW = "contable/ventas";
	private static final String PRODUCCION_VIEW = "contable/produccion";
//	links Productor
	private static final String REPORTES_VIEW = "productor/reportes";
	private static final String NUEVO_MOVIMIENTO_VIEW = "productor/nuevoMovimiento";
	
	
	@RequestMapping(path="/principalAdmin")
	public ModelAndView inicioAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("pageToLoad", VACIA_VIEW);
		model.addObject("usuarioActual", user);
		return model;
	}
	
	
	@RequestMapping(path="/parametros")
	public ModelAndView parametros(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		ParametroDTO parametroDto = new ParametroDTO();
		model.addObject("parametro", parametroDto);
		model.addObject("usuarioUsuarioActual", user);
		model.addObject("pageToLoad", PARAMETROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/usuarios")
	public ModelAndView usuarios(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuarioNuevo", usuarioDto);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", USUARIOS_VIEW);
		return model;
	}

//	Links a Contable
	@RequestMapping(path="/proveedoresAdmin")
	public ModelAndView proveedoresAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	

	@RequestMapping(path="/gallinerosAdmin")
	public ModelAndView gallinerosAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", GALLINEROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/depositosAdmin")
	public ModelAndView depositosAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", DEPOSITOS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ventasAdmin")
	public ModelAndView ventasAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", VENTAS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/produccionAdmin")
	public ModelAndView produccionAdmin(@ModelAttribute("usuarioActual") UsuarioDTO user) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", user);
		model.addObject("pageToLoad", PRODUCCION_VIEW);
		return model;
	}

//	Links Productor
	@RequestMapping("reportesAdmin")
	public ModelAndView reportesAdmin(@ModelAttribute("usuarioActual") UsuarioDTO usuario) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", REPORTES_VIEW);
		return model;
	}
	
	@RequestMapping("nuevoMovimientoAdmin")
	public ModelAndView nuevoMovimientoAdmin(@ModelAttribute("usuarioActual") UsuarioDTO usuario) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", NUEVO_MOVIMIENTO_VIEW);
		return model;
	}

}
