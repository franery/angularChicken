package com.chicken.presentacion.bean.dto;

import com.chicken.base.dto.DTO;

public class GallineroDTO extends DTO {
	private long id;
	private String nombre;
	
	private UsuarioDTO usuario;	
	
	private long stockGallinas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public long getStockGallinas() {
		return stockGallinas;
	}

	public void setStockGallinas(long stockGallinas) {
		this.stockGallinas = stockGallinas;
	}
	
}
