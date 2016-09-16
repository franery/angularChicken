package ar.com.escuelita.chicken.presentacion.controlador.rest;

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
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	
	@RequestMapping("/depositosJsonVista")
	public ModelAndView depositosJsonVista() {
		ModelAndView model = new ModelAndView(DEPOSITOS_JSON_VIEW);
		return model;
	}
	
	@RequestMapping("/depositosJson")
	public List<DTO> depositosJson() {
		return (List<DTO>)depositoServicio.listar();
	}
}
