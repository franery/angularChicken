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
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.validacion.UsuarioValidacion;

@RestController
public class UsuariosControladorRest {
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private IPerfilServicio perfilServicio;
	
	@Autowired
	private UsuarioValidacion usuarioValidacion;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		if (binder.getTarget() instanceof UsuarioDTO){
		binder.setValidator(usuarioValidacion);
		}
    }
	
	@RequestMapping("/usuariosJson")
	public HashMap<String, List<DTO>> usuariosJson() {
		HashMap<String, List<DTO>> usuariosJson = new HashMap<String, List<DTO>>();
		usuariosJson.put(Constantes.DATA, (List<DTO>)usuarioServicio.listar());
		return usuariosJson;
	}
	
	@RequestMapping(path="/usuariosNuevoJson")
	public Object usuariosNuevoJson(@RequestBody @Validated UsuarioDTO usuario,
			BindingResult result) throws NegocioExcepcion {
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		usuarioServicio.crear(usuario);
		return null;
	}
	
	@RequestMapping(path="/usuariosBorrarJson")
	public void usuariosBorrarJson(@RequestBody @Validated UsuarioDTO usuario,
			BindingResult result) {
		if(!result.hasErrors()) {
			usuarioServicio.borrar(usuario);
		}
	}
	
	@RequestMapping(path="/usuariosModificarJson")
	public Object usuariosModificarJson(@RequestBody @Validated UsuarioDTO usuario,
			BindingResult result) throws NegocioExcepcion {
		if(result.hasErrors()) {
			return result.getAllErrors();
		}
		usuarioServicio.modificar(usuario);
		return null;
	}
}