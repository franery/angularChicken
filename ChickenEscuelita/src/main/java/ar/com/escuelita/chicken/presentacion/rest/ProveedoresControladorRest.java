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
import ar.com.escuelita.chicken.negocio.servicios.IProveedorServicio;
import ar.com.escuelita.chicken.presentacion.controlador.Controlador;
import ar.com.escuelita.chicken.presentacion.dto.ProveedorDTO;
import ar.com.escuelita.chicken.presentacion.validacion.ProveedorValidacion;

@RestController
public class ProveedoresControladorRest extends Controlador {

	@Autowired
	private IProveedorServicio proveedorServicio;
	
	@Autowired
	private ProveedorValidacion proveedorValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof ProveedorDTO){
			binder.setValidator(proveedorValidacion);
		}
    }
	
	@RequestMapping("/proveedoresJson")
	public HashMap<String, List<DTO>> proveedorsJson() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControladorRest.class, "proveedoresJson");
		HashMap<String, List<DTO>> proveedorsJson = new HashMap<String, List<DTO>>();
		proveedorsJson.put(Constantes.DATA, (List<DTO>)proveedorServicio.listar());
		return proveedorsJson;
	}
	
	@RequestMapping(path="/proveedoresNuevoJson")
	public Object proveedorsNuevoJson(@RequestBody @Validated ProveedorDTO proveedor,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControladorRest.class, "proveedoresNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		proveedorServicio.crear(proveedor);
		return null;
	}
	
	@RequestMapping(path="/proveedoresBorrarJson")
	public void proveedorsBorrarJson(@RequestBody @Validated ProveedorDTO proveedor,
			BindingResult result) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControladorRest.class, "proveedoresBorrarJson");
		if(!result.hasErrors()) {
			proveedorServicio.borrar(proveedor);
		}
	}
	
	@RequestMapping(path="/proveedoresModificarJson")
	public Object proveedorsModificarJson(@RequestBody @Validated ProveedorDTO proveedor,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ProveedoresControladorRest.class, "proveedoresModificarJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		proveedorServicio.modificar(proveedor);
		return null;
	}
}