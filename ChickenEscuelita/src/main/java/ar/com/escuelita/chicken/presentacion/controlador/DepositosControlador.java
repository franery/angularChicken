package ar.com.escuelita.chicken.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.negocio.servicios.IDepositoServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;
import ar.com.escuelita.chicken.presentacion.validacion.DepositoValidacion;

@Controller
public class DepositosControlador extends Controlador {
	
	@Autowired
	private IDepositoServicio depositoServicio;
	
	@Autowired
	private DepositoValidacion depositoValidacion;
	
	private static final String DEPOSITOS_VIEW = "depositos/depositos";
	private static final String DEPOSITOS_NUEVO_VIEW = "depositos/depositosNuevo";
	private static final String DEPOSITOS_MODIFICAR_VIEW = "depositos/depositosModificar";
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof DepositoDTO){
		binder.setValidator(depositoValidacion);
		}
    }
	
	@RequestMapping(path="/depositos")
	public ModelAndView depositos() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("deposito",new DepositoDTO());
		//model.addObject("listaDepositos",depositoServicio.listar());
		model.addObject("pageToLoad", DEPOSITOS_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping("depositosNuevo")
	public ModelAndView depositosNuevo() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("deposito", new DepositoDTO());
		model.addObject("pageToLoad", DEPOSITOS_NUEVO_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/depositosModificar")
	public ModelAndView depositosModificar(@ModelAttribute("deposito") DepositoDTO deposito) {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("deposito", deposito);
		model.addObject("pageToLoad", DEPOSITOS_MODIFICAR_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping(path="/depositosBorrar")
	public ModelAndView depositosBorrar(@ModelAttribute("deposito") DepositoDTO deposito) {
		depositoServicio.borrar(deposito);
		return new ModelAndView("redirect:/depositos");
	}
		
	
	@RequestMapping(path="/depositosProcesarNuevo")
	public ModelAndView depositosProcesarNuevo(@ModelAttribute("deposito") DepositoDTO deposito) throws Exception {
		depositoServicio.crear(deposito);
		return new ModelAndView("redirect:/depositos");
	}
	
	@RequestMapping(path="/depositosProcesarModificar")
	public ModelAndView depositosProcesarModificar(@ModelAttribute("deposito") DepositoDTO deposito) throws Exception {
		depositoServicio.modificar(deposito);
		return new ModelAndView("redirect:/depositos");
	}
}