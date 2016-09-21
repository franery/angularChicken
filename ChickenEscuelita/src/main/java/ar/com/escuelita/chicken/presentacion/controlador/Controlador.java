package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.List;

import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controlador {

	
	public static final Logger chickenLog =
	LoggerFactory.getLogger(LoginControlador.class);
	
	public static final String PRINCIPAL_VIEW = "template/principal";
	public static final String VACIA_VIEW = "vacia";
	
	public static UsuarioDTO usuario;
	public static List<String> listaPermisos;
	
	public static void setUsuario(UsuarioDTO user) {
		usuario = user;
	}
	
	public static UsuarioDTO getUsuario() {
		return usuario;
	}

	public static List<String> getListaPermisos() {
		return listaPermisos;
	}

	public static void setListaPermisos(List<String> listaPermisos) {
		Controlador.listaPermisos = listaPermisos;
	}
}