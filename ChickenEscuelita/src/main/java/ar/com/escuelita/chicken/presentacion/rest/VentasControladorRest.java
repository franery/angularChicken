package ar.com.escuelita.chicken.presentacion.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.NegocioExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IVentaServicio;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;
import ar.com.escuelita.chicken.presentacion.validacion.VentaValidacion;

@RestController
public class VentasControladorRest {
	
	@Autowired
	private IVentaServicio ventaServicio;
	
	@Autowired
	private VentaValidacion ventaValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentasControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof VentaDTO){
		binder.setValidator(ventaValidacion);
		}
    }
	
	@RequestMapping("/ventasJson")
	public HashMap<String, List<DTO>> ventasJson() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentasControladorRest.class, "ventasJson");
		HashMap<String, List<DTO>> ventasJson = new HashMap<String, List<DTO>>();
		ventasJson.put(Constantes.DATA, (List<DTO>)ventaServicio.listar());
		return ventasJson;
	}
	
	@RequestMapping(path="/ventasNuevoJson")
	public Object ventasNuevoJson(@RequestBody @Validated VentaDTO venta,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", VentasControladorRest.class, "ventasNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		ventaServicio.crear(venta);
		return null;
	}
}
