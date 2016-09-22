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
import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;
import ar.com.escuelita.chicken.presentacion.validacion.DepositoValidacion;

@RestController
public class DepositosControladorRest{
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	@Autowired
	private DepositoValidacion depositoValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositosControladorRest.class, "initBinder");
		if (binder.getTarget() instanceof DepositoDTO){
		binder.setValidator(depositoValidacion);
		}
    }
	
	@RequestMapping("/depositosJson")
	public HashMap<String, List<DTO>> depositosJson() {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositosControladorRest.class, "depositosJson");
		HashMap<String, List<DTO>> depositosJson = new HashMap<String, List<DTO>>();
		depositosJson.put(Constantes.DATA, (List<DTO>)depositoServicio.listar());
		return depositosJson;
	}
	
	@RequestMapping(path="/depositosNuevoJson")
	public Object depositosNuevoJson(@RequestBody @Validated DepositoDTO deposito,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositosControladorRest.class, "depositosNuevoJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		depositoServicio.crear(deposito);
		return null;
	}
	
	@RequestMapping(path="/depositosBorrarJson")
	public void depositosBorrarJson(@RequestBody @Validated DepositoDTO deposito,
			BindingResult result) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositosControladorRest.class, "depositosBorrarJson");
		if(!result.hasErrors()) {
			depositoServicio.borrar(deposito);
		}
	}
	
	@RequestMapping(path="/depositosModificarJson")
	public Object depositosModificarJson(@RequestBody @Validated DepositoDTO deposito,
			BindingResult result) throws NegocioExcepcion {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositosControladorRest.class, "depositosModificarJson");
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		depositoServicio.modificar(deposito);
		return null;
	}
}