package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.HashMap;
import java.util.List;

import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class Controlador {
	
	public static UsuarioDTO usuario;
	public static HashMap<String,List<String>> listaPermisos;
	
	public static void setUsuario(UsuarioDTO user) {
		usuario = user;
	}
	
	public static UsuarioDTO getUsuario() {
		return usuario;
	}

	public static HashMap<String,List<String>> getListaPermisos() {
		return listaPermisos;
	}

	public static void setListaPermisos(HashMap<String,List<String>> listaPermisos) {
		Controlador.listaPermisos = listaPermisos;
	}
}