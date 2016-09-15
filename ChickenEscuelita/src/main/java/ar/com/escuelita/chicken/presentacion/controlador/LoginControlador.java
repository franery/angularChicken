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
import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
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
				if(permiso.getModulo().getNombre().equals(EnumModulo.USUARIOS.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.USUARIOS.getNombre())) {
						listaPermisos.add(EnumModulo.USUARIOS.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.PARAMETROS.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.PARAMETROS.getNombre())) {
						listaPermisos.add(EnumModulo.PARAMETROS.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.PROVEEDORES.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.PROVEEDORES.getNombre())) {
						listaPermisos.add(EnumModulo.PROVEEDORES.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.DEPOSITOS.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.DEPOSITOS.getNombre())) {
						listaPermisos.add(EnumModulo.DEPOSITOS.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.GALLINEROS.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.GALLINEROS.getNombre())) {
						listaPermisos.add(EnumModulo.GALLINEROS.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.VENTAS.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.VENTAS.getNombre())) {
						listaPermisos.add(EnumModulo.VENTAS.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.MOVIMIENTOS.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.MOVIMIENTOS.getNombre())) {
						listaPermisos.add(EnumModulo.MOVIMIENTOS.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.PERFILES.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.PERFILES.getNombre())) {
						listaPermisos.add(EnumModulo.PERFILES.getNombre());
					}
				}
				if(permiso.getModulo().getNombre().equals(EnumModulo.PRODUCCION.getNombre())) {
					if(!listaPermisos.contains(EnumModulo.PRODUCCION.getNombre())) {
						listaPermisos.add(EnumModulo.PRODUCCION.getNombre());
					}
				}
			}
		}
		Collections.sort(listaPermisos);
		return listaPermisos;
	}
}
