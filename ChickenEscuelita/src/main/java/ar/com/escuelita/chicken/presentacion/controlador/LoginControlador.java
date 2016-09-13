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
				if(permiso.getModulo().getName().equals(EnumModulo.USUARIOS.getName())) {
					if(!listaPermisos.contains(EnumModulo.USUARIOS.getName())) {
						listaPermisos.add(EnumModulo.USUARIOS.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.PARAMETROS.getName())) {
					if(!listaPermisos.contains(EnumModulo.PARAMETROS.getName())) {
						listaPermisos.add(EnumModulo.PARAMETROS.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.PROVEEDORES.getName())) {
					if(!listaPermisos.contains(EnumModulo.PROVEEDORES.getName())) {
						listaPermisos.add(EnumModulo.PROVEEDORES.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.DEPOSITOS.getName())) {
					if(!listaPermisos.contains(EnumModulo.DEPOSITOS.getName())) {
						listaPermisos.add(EnumModulo.DEPOSITOS.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.GALLINEROS.getName())) {
					if(!listaPermisos.contains(EnumModulo.GALLINEROS.getName())) {
						listaPermisos.add(EnumModulo.GALLINEROS.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.VENTAS.getName())) {
					if(!listaPermisos.contains(EnumModulo.VENTAS.getName())) {
						listaPermisos.add(EnumModulo.VENTAS.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.MOVIMIENTOS.getName())) {
					if(!listaPermisos.contains(EnumModulo.MOVIMIENTOS.getName())) {
						listaPermisos.add(EnumModulo.MOVIMIENTOS.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.PERFILES.getName())) {
					if(!listaPermisos.contains(EnumModulo.PERFILES.getName())) {
						listaPermisos.add(EnumModulo.PERFILES.getName());
					}
				}
				if(permiso.getModulo().getName().equals(EnumModulo.PRODUCCION.getName())) {
					if(!listaPermisos.contains(EnumModulo.PRODUCCION.getName())) {
						listaPermisos.add(EnumModulo.PRODUCCION.getName());
					}
				}
			}
		}
		Collections.sort(listaPermisos);
		return listaPermisos;
	}
}
