package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;

@Controller
public class ProveedoresControlador extends Controlador {
	
	@Autowired
	private IProveedorServicio proveedorServicio;
	
	@RequestMapping(path="/proveedores")
	public ModelAndView proveedores() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControlador.class, "proveedores");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		List<DTO> listaProveedores = (List<DTO>)proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", Constantes.PROVEEDORES_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/proveedoresNuevo")
	public ModelAndView proveedoresNuevo() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControlador.class, "proveedoresNuevo");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", Constantes.PROVEEDORES_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/proveedoresModificar")
	public ModelAndView proveedoresModificar(@ModelAttribute("proveedor") ProveedorDTO proveedor) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControlador.class, "proveedoresModificar");
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("proveedor", proveedor);
		model.addObject("pageToLoad", Constantes.PROVEEDORES_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	//Procesar Nuevo
	@RequestMapping(path="/proveedoresProcesarNuevo")
	public ModelAndView proveedoresProcesarNuevo(@ModelAttribute("proveedor") ProveedorDTO proveedor) throws Exception {
		proveedorServicio.crear(proveedor);
		return new ModelAndView("redirect:/proveedores");
	}
	
	//Procesar Modificar
	@RequestMapping(path="/proveedoresProcesarModificar")
	public ModelAndView proveedoresProcesarModificar(@ModelAttribute("proveedor") ProveedorDTO proveedor) throws Exception {
		proveedorServicio.modificar(proveedor);
		return new ModelAndView("redirect:/proveedores");
	}
	
	@RequestMapping(path="/proveedoresBorrar")
	public ModelAndView proveedoresBorrar(@ModelAttribute("proveedor") ProveedorDTO proveedor) {
		proveedorServicio.borrar(proveedor);
		return new ModelAndView("redirect:/proveedores");
	}
}
