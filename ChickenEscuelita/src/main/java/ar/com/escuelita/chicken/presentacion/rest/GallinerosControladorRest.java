package ar.com.escuelita.chicken.presentacion.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.NegocioExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IGallineroServicio;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;

public class GallinerosControladorRest {
	
	@Autowired
	private IGallineroServicio gallineroServicio;
	
	@RequestMapping("/gallinerosJson")
	public HashMap<String, List<DTO>> gallinerosJson() {
		HashMap<String, List<DTO>> gallinerosJson = new HashMap<String, List<DTO>>();
		gallinerosJson.put(Constantes.DATA, (List<DTO>)gallineroServicio.listar());
		return gallinerosJson;
	}
	
	@RequestMapping(path="/gallinerosNuevoJson")
	public HashMap<String, List<DTO>> gallinerosNuevoJson(@RequestBody GallineroDTO gallinero) throws NegocioExcepcion {
		gallineroServicio.crear(gallinero);
		HashMap<String, List<DTO>> gallinerosJson = new HashMap<String, List<DTO>>();
		gallinerosJson.put(Constantes.DATA, (List<DTO>)gallineroServicio.listar());
		return gallinerosJson;
	}
	
	@RequestMapping(path="/gallinerosBorrarJson")
	public HashMap<String, List<DTO>> gallinerosBorrarJson(@RequestBody GallineroDTO gallinero) {
		gallineroServicio.borrar(gallinero);
		HashMap<String, List<DTO>> gallinerosJson = new HashMap<String, List<DTO>>();
		gallinerosJson.put(Constantes.DATA, (List<DTO>)gallineroServicio.listar());
		return gallinerosJson;
	}
	
	@RequestMapping(path="/gallinerosModificarJson")
	public HashMap<String, List<DTO>> gallinerosModificarJson(@RequestBody GallineroDTO gallinero) throws NegocioExcepcion {
		gallineroServicio.modificar(gallinero);
		HashMap<String, List<DTO>> gallinerosJson = new HashMap<String, List<DTO>>();
		gallinerosJson.put(Constantes.DATA, (List<DTO>)gallineroServicio.listar());
		return gallinerosJson;
	}
}
