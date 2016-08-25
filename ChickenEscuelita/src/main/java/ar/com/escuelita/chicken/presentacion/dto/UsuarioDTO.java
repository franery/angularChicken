package ar.com.escuelita.chicken.presentacion.dto;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;

public class UsuarioDTO extends DTO {
	private long id;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private EnumPerfil perfil;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public EnumPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(EnumPerfil perfil) {
		this.perfil = perfil;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
