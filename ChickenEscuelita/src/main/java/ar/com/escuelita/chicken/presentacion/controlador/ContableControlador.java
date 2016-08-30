package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

@Controller
public class ContableControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private IProveedorServicio proveedorServicio;
	
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String GALLINEROS_VIEW = "contable/gallineros";
	private static final String DEPOSITOS_VIEW = "contable/depositos";
	private static final String VENTAS_VIEW = "contable/ventas";
	private static final String PRODUCCION_VIEW = "contable/produccion";
	
	@RequestMapping(path="/principal")
	public ModelAndView inicioContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", VACIA_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresContable")
	public ModelAndView proveedoresContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		List<DTO> listaProveedores = (List<DTO>)proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresBorrarContable")
	public ModelAndView proveedoresContable(@PathVariable("proveedorId") long proveedorId) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		List<DTO> listaProveedores = (List<DTO>)proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	
	@RequestMapping(path="/gallinerosContable")
	public ModelAndView gallinerosContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", GALLINEROS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/depositosContable")
	public ModelAndView depositosContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", DEPOSITOS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ventasContable")
	public ModelAndView ventasContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", VENTAS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/produccionContable")
	public ModelAndView produccionContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", PRODUCCION_VIEW);
		return model;
	}
}
