package ar.com.escuelita.chicken.presentacion.controlador;

import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class Controlador {
	
	public static final String PRINCIPAL_VIEW = "template/principal";
	public static final String VACIA_VIEW = "vacia";
	
	protected static UsuarioDTO usuario;
	
	public static void setUsuario(UsuarioDTO user) {
		usuario = user;
	}
	
	public static UsuarioDTO getUsuario() {
		return usuario;
	}
}