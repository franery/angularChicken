package ar.com.escuelita.chicken.presentacion.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;

@RestController
public class DepositosControladorRest{
	
	private static final String DATA = "data";
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	@RequestMapping("/depositosJson")
	public HashMap<String, List<DTO>> depositosJson() {
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
}
