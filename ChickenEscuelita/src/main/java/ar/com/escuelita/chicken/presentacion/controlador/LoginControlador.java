package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
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

	@RequestMapping("/inicio")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView(Constantes.LOGIN_VIEW);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		model.addObject("usuario", usuarioDto);
		if (error != null) {
			model.addObject("error","mensajeErrorLogin");
		}
		return model;
	}
	
	@RequestMapping("atras")
	public ModelAndView volver(@RequestParam("url") String  url) {
		String[] spliteado = url.split("/");
		String str = spliteado[spliteado.length - 1];
		str = str.replace("Nuevo", "");
		str = str.replace("Modificar", "");
		str = str.replace("Procesar", "");
		str = str.replace("Borrar", "");
		return new ModelAndView("redirect:/"+str);
	}
	
	@RequestMapping("ayuda")
	public ModelAndView ayuda() {
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("pageToLoad", Constantes.AYUDA_VIEW);
		model.addObject("listaPermisos", listaPermisos);
		return model;
	}
	
	@RequestMapping("/403")
	public ModelAndView accesoDenegado() {
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
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
		ModelAndView model = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		model.addObject("usuarioActual",usuario);
		model.addObject("listaPermisos", listaPermisos);
		model.addObject("pageToLoad",Constantes.VACIA_VIEW);
		return model;
	}
	
	private HashMap<String, List<String>> obtenerPermisos() {
		Set<String> listaPermisosSet = new LinkedHashSet<String>();
		for(PerfilDTO perfil : usuario.getListaPerfiles()) {
			for(PermisoDTO permiso : perfil.getListaPermisos()) {
				listaPermisosSet.add(permiso.getNombreModulo().toLowerCase());
			}
		}
		List<String> listaPermisos = new ArrayList<String>(listaPermisosSet);
		Collections.sort(listaPermisos);
		
		List<String> listaAdmin = new ArrayList<String>();
		List<String> listaProductor = new ArrayList<String>();
		List<String> listaContable = new ArrayList<String>();
		
		HashMap<String, List<String>> hashPermisos = new HashMap<String, List<String>>();
		
		for(String permiso : Constantes.PERMISOS_ADMINISTRADOR) {
			if(listaPermisos.contains(permiso)){
				listaAdmin.add(permiso);
			}
		}
		for(String permiso : Constantes.PERMISOS_PRODUCTOR) {
			if(listaPermisos.contains(permiso)){
				listaProductor.add(permiso);
			}
		}
		for(String permiso : Constantes.PERMISOS_CONTABLE) {
			if(listaPermisos.contains(permiso)){
				listaContable.add(permiso);
			}
		}
		
		if(!(listaAdmin.isEmpty())){
			hashPermisos.put("administrador", listaAdmin);
		}
		if(!(listaContable.isEmpty())){
			hashPermisos.put("contable", listaContable);
		}
		if(!(listaProductor.isEmpty())){
			hashPermisos.put("productor", listaProductor);
		}
		
		return hashPermisos;
	}
}
