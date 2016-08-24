package com.chicken.presentacion.bean.dto;

import com.chicken.base.dto.DTO;

public class ParametroDTO extends DTO {
	private long id;
	
	private String descripcion;
	
	private String valor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
