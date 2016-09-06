package ar.com.escuelita.chicken.presentacion.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class Controlador {
	
	public static final String CONTABLE_VIEW = "contable/principal";
	public static final String PRODUCTOR_VIEW = "productor/principal";
	public static final String ADMIN_VIEW = "administrador/principal";
	public static final String VACIA_VIEW = "vacia";
	
	protected static int NUEVO = 0;
	protected static int MODIFICAR = 1;
	
	protected static UsuarioDTO usuario;
	
	public static void setUsuario(UsuarioDTO user) {
		usuario = user;
	}
	
	public static UsuarioDTO getUsuario() {
		return usuario;
	}
	
	protected String obtenerVista() {
		if(usuario.getPerfil().equals(EnumPerfil.ADMINISTRADOR)) {
			return ADMIN_VIEW;
		}
		else if(usuario.getPerfil().equals(EnumPerfil.CONTABLE)) {
			return CONTABLE_VIEW;
		}
		else {
			return PRODUCTOR_VIEW;
		}
	}





}
