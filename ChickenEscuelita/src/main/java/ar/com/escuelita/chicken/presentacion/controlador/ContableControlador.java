package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.negocio.servicios.IMovimientoServicio;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.IVentaServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;
import ar.com.escuelita.chicken.presentacion.filtro.DepositoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.MovimientoFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;

@Controller
public class ContableControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private IProveedorServicio proveedorServicio;
	
	@Autowired
	private IVentaServicio ventaServicio;
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	@Autowired
	private IMovimientoServicio movimientoServicio;
	
	@Autowired
	private IGallineroServicio gallineroServicio;
	
	private static final String PROVEEDORES_VIEW = "contable/proveedores";
	private static final String PROVEEDORES_NUEVO_VIEW = "contable/proveedoresNuevo";
	private static final String GALLINEROS_VIEW = "contable/gallineros";
	private static final String GALLINEROS_NUEVO_VIEW = "contable/gallinerosNuevo";
	private static final String DEPOSITOS_VIEW = "contable/depositos";
	private static final String DEPOSITOS_NUEVO_VIEW = "contable/depositosNuevo";
	private static final String VENTAS_VIEW = "contable/ventas";
	private static final String VENTAS_NUEVO_VIEW = "contable/ventasNuevo";
	private static final String PRODUCCION_VIEW = "contable/produccion";
	
	@RequestMapping(path="/principal")
	public ModelAndView inicioContable() {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", VACIA_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresContable")
	public ModelAndView proveedoresContable() {
		ModelAndView model = new ModelAndView(obtenerVista());
		List<DTO> listaProveedores = (List<DTO>)proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", PROVEEDORES_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresNuevoContable")
	public ModelAndView proveedoresNuevoContable(@RequestParam("flag") int flag) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", flag);
		model.addObject("proveedor", new ProveedorDTO());
		model.addObject("pageToLoad", PROVEEDORES_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresModificarContable")
	public ModelAndView proveedoresModificarContable(@ModelAttribute("proveedor") ProveedorDTO proveedor, @RequestParam("flag") int flag) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", flag);
		model.addObject("proveedor", proveedor);
		model.addObject("pageToLoad", PROVEEDORES_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/proveedoresModificarCrearNuevoContable")
	public ModelAndView proveedoresCrearNuevoContable(@ModelAttribute("proveedor") ProveedorDTO proveedor, @RequestParam("flag") int flag) {
		ModelAndView model = new ModelAndView(obtenerVista());
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
		ModelAndView model = new ModelAndView(obtenerVista());
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
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("gallinero",new GallineroDTO());
		model.addObject("listaGallineros",gallineroServicio.listar());
		model.addObject("pageToLoad", GALLINEROS_VIEW);
		return model;
	}

	@RequestMapping(path="/gallinerosNuevoContable")
	public ModelAndView gallinerosNuevoContable() {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", NUEVO);
		model.addObject("gallinero", new GallineroDTO());
		model.addObject("pageToLoad", GALLINEROS_NUEVO_VIEW);
		return model;
	}
	

	@RequestMapping(path="/gallinerosModificarContable")
	public ModelAndView gallinerosModificarContable(@ModelAttribute("gallinero") GallineroDTO gallinero) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("flag", MODIFICAR);
		model.addObject("gallinero", gallinero);
		model.addObject("pageToLoad", GALLINEROS_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/gallinerosBorrarContable")
	public ModelAndView gallinerosBorrarContable(@ModelAttribute("gallinero") GallineroDTO gallinero) {
		gallineroServicio.borrar(gallinero);
		return new ModelAndView("redirect:/gallineroContable");
	}
	
	@RequestMapping(path="/depositosContable")
	public ModelAndView depositosContable() {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("deposito",new DepositoDTO());
		model.addObject("listaDepositos",depositoServicio.listar());
		model.addObject("pageToLoad", DEPOSITOS_VIEW);
		return model;
	}
	
	@RequestMapping(path="depositosNuevoContable")
	public ModelAndView depositosNuevoContable() {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", NUEVO);
		model.addObject("deposito", new DepositoDTO());
		model.addObject("pageToLoad", DEPOSITOS_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/depositosModificarContable")
	public ModelAndView depositosModificarContable(@ModelAttribute("deposito") DepositoDTO deposito) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		model.addObject("flag", MODIFICAR);
		model.addObject("deposito", deposito);
		model.addObject("pageToLoad", DEPOSITOS_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/depositosBorrarContable")
	public ModelAndView depositosBorrarContable(@ModelAttribute("deposito") DepositoDTO deposito) {
		depositoServicio.borrar(deposito);
		return new ModelAndView("redirect:/depositosContable");
	}
		
	
	@RequestMapping(path="/depositosModificarCrearNuevoContable")
	public ModelAndView depositosCrearNuevoContable(@ModelAttribute("deposito") DepositoDTO deposito, @RequestParam("flag") int flag) {
		if(flag == MODIFICAR) {
			depositoServicio.modificar(deposito);
		}
		else {
			depositoServicio.crear(deposito);
		}
		return new ModelAndView("redirect:/depositosContable");
	}
	
	@RequestMapping(path="/ventasContable")
	public ModelAndView ventasContable(@ModelAttribute("filtro") VentaFiltro filtro) {
		ModelAndView model = new ModelAndView(obtenerVista());
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
		ModelAndView model = new ModelAndView(obtenerVista());
		List<DTO> listaProveedores = (List<DTO>) proveedorServicio.listar();
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("usuarioActual", usuario);
		model.addObject("venta", new VentaDTO());
		model.addObject("pageToLoad", VENTAS_NUEVO_VIEW);
		return model;
	}
	
	@RequestMapping(path="/ventasCrearNuevoContable")
	public ModelAndView ventasCrearNuevoContable(@ModelAttribute("venta") VentaDTO venta) {
		ModelAndView model = new ModelAndView(obtenerVista());
		ventaServicio.crear(venta);
		List<DTO> listaVentas= (List<DTO>)ventaServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaVentas", listaVentas);
		model.addObject("proveedor", new VentaDTO());
		model.addObject("filtro", new VentaFiltro());
		model.addObject("pageToLoad", VENTAS_VIEW);
		return model;
	}
	
	@RequestMapping(path="/produccionContable")
	public ModelAndView produccionContable(@ModelAttribute("usuarioFiltro") UsuarioFiltro usuarioFiltro, @ModelAttribute("depositoFiltro") 
	DepositoFiltro depositoFiltro) {
		ModelAndView model = new ModelAndView(obtenerVista());
		model.addObject("usuarioActual", usuario);
		
		// Tabla Depositos | Stock Huevos
		model.addObject("listaDepositos", depositoServicio.listar(depositoFiltro));
		model.addObject("listaDepositosDropDown", depositoServicio.listar());

		
		// Tabla Productores | Total Produccion
		model.addObject("hashTotales", usuarioServicio.getTotalesProduccion(usuarioFiltro));
		model.addObject("listaProductoresDropDown", usuarioServicio.listarProductores());

		model.addObject("pageToLoad", PRODUCCION_VIEW);
		return model;
	}
	

	
}
