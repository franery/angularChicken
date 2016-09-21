package ar.com.escuelita.chicken.presentacion.dto;

import ar.com.escuelita.chicken.base.dto.DTO;

public class GallineroDTO extends DTO {
	
	private String id;
	
	private String nombre;
	
	private String usuarioId;
	
	private String usuarioNombre;	
	
	private String stockGallinas;
	
	private String borrado;

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

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getStockGallinas() {
		return stockGallinas;
	}

	public void setStockGallinas(String stockGallinas) {
		this.stockGallinas = stockGallinas;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getBorrado() {
		return borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}
}
