package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.IVentaServicio;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

@Controller
public class ContableControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private IProveedorServicio proveedorServicio;
	
	@Autowired
	private IVentaServicio ventaServicio;
	
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String PROVEEDORES_NUEVO_VIEW = "contable/proveedoresNuevo";
	private static final String GALLINEROS_VIEW = "contable/gallineros";
	private static final String DEPOSITOS_VIEW = "contable/depositos";
	private static final String VENTAS_VIEW = "contable/ventas";
	private static final String VENTAS_NUEVO_VIEW = "contable/ventasNuevo";
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
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresNuevoContable")
	public ModelAndView proveedoresNuevoContable(@RequestParam("flag") int flag) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", flag);
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", PROVEEDORES_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresModificarContable")
	public ModelAndView proveedoresModificarContable(@ModelAttribute("proveedor") ProveedorDTO proveedor, @RequestParam("flag") int flag) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", flag);
		model.addObject("proveedor", proveedor);
		model.addObject("pageToLoad", PROVEEDORES_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresModificarCrearNuevoContable")
	public ModelAndView proveedoresCrearNuevoContable(@ModelAttribute("proveedor") ProveedorDTO proveedor, @RequestParam("flag") int flag) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		if(flag == 0) {
			proveedorServicio.modificar(proveedor);
		}
		else {
			proveedorServicio.crear(proveedor);
		}
		List<DTO> listaProveedores = (List<DTO>)proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresBorrarContable")
	public ModelAndView proveedoresBorrarContable(@ModelAttribute("proveedor") ProveedorDTO proveedor) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		proveedorServicio.borrar(proveedor);
		List<DTO> listaProveedores = (List<DTO>)proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("proveedor", new ProveedorDTO());
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
	public ModelAndView ventasContable(@ModelAttribute("filtro") VentaFiltro filtro) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		List<DTO> listaVentas = (List<DTO>) ventaServicio.listar(filtro);
		List<DTO> listaProveedores = (List<DTO>) proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaVentas", listaVentas);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("venta", new VentaDTO());
		model.addObject("pageToLoad", VENTAS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ventasNuevoContable")
	public ModelAndView ventasNuevoContable() {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		List<DTO> listaProveedores = (List<DTO>) proveedorServicio.listar();
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("usuarioActual", usuario);
		model.addObject("venta", new VentaDTO());
		model.addObject("pageToLoad", VENTAS_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ventasCrearNuevoContable")
	public ModelAndView ventasCrearNuevoContable(@ModelAttribute("venta") VentaDTO venta) {
		ModelAndView model;
		if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			model = new ModelAndView(CONTABLE_VIEW);
		}
		else {
			model = new ModelAndView(ADMIN_VIEW);
		}
		ventaServicio.crear(venta);
		List<DTO> listaVentas= (List<DTO>)ventaServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaVentas", listaVentas);
		model.addObject("proveedor", new VentaDTO());
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
