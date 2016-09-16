package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.negocio.servicios.IVentaServicio;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;
import ar.com.escuelita.chicken.presentacion.filtro.VentaFiltro;
import ar.com.escuelita.chicken.presentacion.validacion.VentaValidacion;

@Controller
public class VentasControlador extends Controlador {
	
	@Autowired
	private IVentaServicio ventaServicio;
	
	@Autowired
	private IProveedorServicio proveedorServicio;
	
	@Autowired
	private VentaValidacion ventaValidacion;
	
	private static final String VENTAS_VIEW = "ventas/ventas";
	private static final String VENTAS_NUEVO_VIEW = "ventas/ventasNuevo";
	
	@RequestMapping(path="/ventas")
	public ModelAndView ventas(@ModelAttribute("filtro") VentaFiltro filtro) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		List<DTO> listaVentas = (List<DTO>) ventaServicio.listar(filtro);
		List<DTO> listaProveedores = (List<DTO>) proveedorServicio.listar();
		model.addObject("usuarioActual", usuario);
		model.addObject("listaVentas", listaVentas);
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("venta", new VentaDTO());
		model.addObject("pageToLoad", VENTAS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof VentaDTO){
		binder.setValidator(ventaValidacion);
		}
    }
	
	@RequestMapping(path="/ventasNuevo")
	public ModelAndView ventasNuevo(@ModelAttribute("venta") VentaDTO venta) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		List<DTO> listaProveedores = (List<DTO>) proveedorServicio.listar();
		model.addObject("listaProveedores", listaProveedores);
		model.addObject("usuarioActual", usuario);
		model.addObject("venta", new VentaDTO());
		model.addObject("pageToLoad", VENTAS_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/ventasProcesarNuevo")
	public ModelAndView ventasProcesarNuevo(@ModelAttribute("venta") @Validated VentaDTO venta,
			BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return ventasNuevo(venta);
		}
		ventaServicio.crear(venta);
		ModelAndView model =  new ModelAndView("redirect:/ventas");
		model.addObject("filtro", new VentaFiltro());
		return model;
	}
}