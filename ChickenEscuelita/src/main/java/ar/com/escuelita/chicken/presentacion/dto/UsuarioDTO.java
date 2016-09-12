package ar.com.escuelita.chicken.presentacion.dto;

import java.util.ArrayList;
import java.util.List;

import ar.com.escuelita.chicken.base.dto.DTO;

public class UsuarioDTO extends DTO {
	
	private String id;
	
	private String nombreUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private String contrasenia;
	
	private List<PerfilDTO> listaPerfiles = new ArrayList<PerfilDTO>();
	
	private String borrado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<PerfilDTO> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<PerfilDTO> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}

	public String getBorrado() {
		return borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}
}