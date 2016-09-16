package ar.com.escuelita.chicken.presentacion.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.presentacion.controlador.Controlador;

@RestController
public class DepositosControladorRest extends Controlador{
	
	private static final String DEPOSITOS_JSON_VIEW = "depositos/depositosJson";
	private static final String DATA = "data";
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	
	@RequestMapping("/depositosJsonVista")
	public ModelAndView depositosJsonVista() {
		ModelAndView model = new ModelAndView(DEPOSITOS_JSON_VIEW);
		return model;
	}
	
	@RequestMapping("/depositosJson")
	public HashMap<String, List<DTO>> depositosJson() {
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
}
