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
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.validacion.PerfilValidacion;


@RestController
public class PerfilesControladorRest {
	
	@Autowired
	private IPerfilServicio perfilServicio;
	
	@Autowired
	private PerfilValidacion perfilValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilesControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof PerfilDTO){
		binder.setValidator(perfilValidacion);
		}
    }
	
	@RequestMapping("/perfilesJson")
	public HashMap<String, List<DTO>> perfilesJson() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilesControladorRest.class, "perfilesJSON");
		HashMap<String, List<DTO>> perfilesJson = new HashMap<String, List<DTO>>();
		perfilesJson.put(Constantes.DATA, (List<DTO>)perfilServicio.listar());
		return perfilesJson;
	}
	
	@RequestMapping(path="/perfilesNuevoJson")
	public Object perfilesNuevoJson(@RequestBody @Validated PerfilDTO perfil,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilesControladorRest.class, "perfilesNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		perfilServicio.crear(perfil);
		return null;
	}
	
	@RequestMapping(path="/perfilesBorrarJson")
	public void perfilesBorrarJson(@RequestBody @Validated PerfilDTO perfil,
			BindingResult result) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilesControladorRest.class, "perfilesBorrarJson");
		if(!result.hasErrors()) {
			perfilServicio.borrar(perfil);
		}
	}
	
	@RequestMapping(path="/perfilesModificarJson")
	public Object perfilesModificarJson(@RequestBody @Validated PerfilDTO perfil,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", PerfilesControladorRest.class, "perfilesModificarJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		perfilServicio.modificar(perfil);
		return null;
	}
}
