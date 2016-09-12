package ar.com.escuelita.chicken.presentacion.dto;

import java.util.ArrayList;
import java.util.List;

import ar.com.escuelita.chicken.base.dto.DTO;

public class PerfilDTO extends DTO {
	
	private String id;
	
	private String nombre;
	
	private List<PermisoDTO> listaPermisos = new ArrayList<PermisoDTO>() ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PermisoDTO> getListaPermisos() {
		return listaPermisos;
	}

	public void setListaPermisos(List<PermisoDTO> listaPermisos) {
		this.listaPermisos = listaPermisos;
	}
}