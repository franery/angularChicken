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
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;
import ar.com.escuelita.chicken.presentacion.validacion.GallineroValidacion;

@RestController
public class GallinerosControladorRest {
	
	@Autowired
	private IGallineroServicio gallineroServicio;
	
	@Autowired
	private GallineroValidacion gallineroValidacion;
		
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof GallineroDTO){
			binder.setValidator(gallineroValidacion);
		}
    }
	
	@RequestMapping("/gallinerosJson")
	public HashMap<String, List<DTO>> gallinerosJson() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControladorRest.class, "gallinerosJson");
		HashMap<String, List<DTO>> gallinerosJson = new HashMap<String, List<DTO>>();
		gallinerosJson.put(Constantes.DATA, (List<DTO>)gallineroServicio.listar());
		return gallinerosJson;
	}
	
	@RequestMapping(path="/gallinerosNuevoJson")
	public Object gallinerosNuevoJson(@RequestBody @Validated GallineroDTO gallinero,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControladorRest.class, "gallinerosNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		gallineroServicio.crear(gallinero);
		return null;
	}
	
	@RequestMapping(path="/gallinerosBorrarJson")
	public void gallinerosBorrarJson(@RequestBody @Validated GallineroDTO gallinero,
			BindingResult result) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControladorRest.class, "gallinerosBorrarJson");
		if(!result.hasErrors()) {
			gallineroServicio.borrar(gallinero);
		}
	}
	
	@RequestMapping(path="/gallinerosModificarJson")
	public Object gallinerosModificarJson(@RequestBody @Validated GallineroDTO gallinero,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", GallinerosControladorRest.class, "gallinerosModificarJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		gallineroServicio.modificar(gallinero);
		return null;
	}
}