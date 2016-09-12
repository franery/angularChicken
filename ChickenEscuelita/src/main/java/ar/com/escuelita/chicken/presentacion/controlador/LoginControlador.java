package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;
import ar.com.escuelita.chicken.presentacion.dto.PermisoDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

@Controller
public class LoginControlador extends Controlador{
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	private static final String LOGIN_VIEW = "login/login";
	
	@RequestMapping("/inicio")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
		return model;
	}
	
	@RequestMapping("/403")
	public ModelAndView accesoDenegado() {
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual", usuario);
		model.addObject("pageToLoad", "login/403");
		return model;
	}
	@RequestMapping(path="/ingresar")
	public ModelAndView loginVerificacion() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDTO usuarioDto = null;
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNombreUsuario(auth.getName());
		for (DTO usuarioDTO : usuarioServicio.listar(filtro)) {
			usuarioDto = (UsuarioDTO) usuarioDTO;
		}
		setUsuario(usuarioDto);
		setListaPermisos(obtenerPermisos());
		ModelAndView model = new ModelAndView(PRINCIPAL_VIEW);
		model.addObject("usuarioActual",usuario);
		model.addObject("listaPermisos", listaPermisos);
		model.addObject("pageToLoad",VACIA_VIEW);
		return model;
	}
	
	private List<String> obtenerPermisos() {
		List<String> listaPermisos = new ArrayList<String>();
		for(PerfilDTO perfil : usuario.getListaPerfiles()) {
			for(PermisoDTO permiso : perfil.getListaPermisos()) {
				if(permiso.getNombre().matches("usuarios(.*)")) {
					if(!listaPermisos.contains("usuarios")) {
						listaPermisos.add("usuarios");
					}
				}
				if(permiso.getNombre().matches("parametros(.*)")) {
					if(!listaPermisos.contains("parametros")) {
						listaPermisos.add("parametros");
					}
				}
				if(permiso.getNombre().matches("proveedores(.*)")) {
					if(!listaPermisos.contains("proveedores")) {
						listaPermisos.add("proveedores");
					}
				}
				if(permiso.getNombre().matches("depositos(.*)")) {
					if(!listaPermisos.contains("depositos")) {
						listaPermisos.add("depositos");
					}
				}
				if(permiso.getNombre().matches("gallineros(.*)")) {
					if(!listaPermisos.contains("gallineros")) {
						listaPermisos.add("gallineros");
					}
				}
				if(permiso.getNombre().matches("ventas(.*)")) {
					if(!listaPermisos.contains("ventas")) {
						listaPermisos.add("ventas");
					}
				}
				if(permiso.getNombre().matches("movimientos(.*)")) {
					if(!listaPermisos.contains("movimientos")) {
						listaPermisos.add("reportes");
					}
				}
				if(permiso.getNombre().matches("perfiles(.*)")) {
					if(!listaPermisos.contains("perfiles")) {
						listaPermisos.add("perfiles");
					}
				}
				if(permiso.getNombre().matches("produccion(.*)")) {
					if(!listaPermisos.contains("produccion")) {
						listaPermisos.add("produccion");
					}
				}
			}
		}
		Collections.sort(listaPermisos);
		return listaPermisos;
	}
}
