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
	public void depositosNuevoJson(@RequestBody DepositoDTO deposito) throws NegocioExcepcion {
		depositoServicio.crear(deposito);
	}
	
	@RequestMapping(path="/depositosBorrarJson")
	public void depositosBorrarJson(@RequestBody DepositoDTO deposito) {
		depositoServicio.borrar(deposito);
	}
	
	@RequestMapping(path="/depositosModificarJson")
	public void depositosModificarJson(@RequestBody DepositoDTO deposito) throws NegocioExcepcion {
		depositoServicio.modificar(deposito);
	}
}