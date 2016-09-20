package ar.com.escuelita.chicken.presentacion.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.NegocioExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

@RestController
public class DepositosControladorRest{
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	@RequestMapping("/depositosJson")
	public HashMap<String, List<DTO>> depositosJson() {
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(Constantes.DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
	
	@RequestMapping(path="/depositosNuevoJson")
	public HashMap<String, List<DTO>> depositosNuevoJson(@RequestBody DepositoDTO deposito) throws NegocioExcepcion {
		depositoServicio.crear(deposito);
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(Constantes.DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
	
	@RequestMapping(path="/depositosBorrarJson")
	public HashMap<String, List<DTO>> depositosBorrarJson(@RequestBody DepositoDTO deposito) {
		depositoServicio.borrar(deposito);
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(Constantes.DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
	
	@RequestMapping(path="/depositosModificarJson")
	public HashMap<String, List<DTO>> depositosModificarJson(@RequestBody DepositoDTO deposito) throws NegocioExcepcion {
		depositoServicio.modificar(deposito);
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(Constantes.DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
}