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
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;
import ar.com.escuelita.chicken.presentacion.validacion.ParametroValidacion;

@RestController
public class ParametrosControladorRest {
	
	@Autowired
	private IParametroServicio parametroServicio;
	
	@Autowired
	private ParametroValidacion parametroValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ParametrosControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof ParametroDTO){
		binder.setValidator(parametroValidacion);
		}
    }
	
	@RequestMapping("/parametrosJson")
	public HashMap<String, List<DTO>> parametrosJson() {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ParametrosControladorRest.class, "parametrosJson");
		HashMap<String, List<DTO>> parametrosJson = new HashMap<String, List<DTO>>();
		parametrosJson.put(Constantes.DATA, (List<DTO>)parametroServicio.listar());
		return parametrosJson;
	}
	
	@RequestMapping(path="/parametrosNuevoJson")
	public Object parametrosNuevoJson(@RequestBody @Validated ParametroDTO parametro,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ParametrosControladorRest.class, "parametrosNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		parametroServicio.crear(parametro);
		return null;
	}
	
	@RequestMapping(path="/parametrosBorrarJson")
	public void parametrosBorrarJson(@RequestBody @Validated ParametroDTO parametro,
			BindingResult result) {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ParametrosControladorRest.class, "parametrosBorrarJson");
		if(!result.hasErrors()) {
			parametroServicio.borrar(parametro);
		}
	}
	
	@RequestMapping(path="/parametrosModificarJson")
	public Object parametrosModificarJson(@RequestBody @Validated ParametroDTO parametro,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.error("Controlador: {} ; Metodo: {} ;", ParametrosControladorRest.class, "parametrosModificarJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		parametroServicio.modificar(parametro);
		return null;
	}
}
