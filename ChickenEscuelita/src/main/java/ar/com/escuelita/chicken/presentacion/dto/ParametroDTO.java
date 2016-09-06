package ar.com.escuelita.chicken.presentacion.dto;

import ar.com.escuelita.chicken.base.dto.DTO;

public class ParametroDTO extends DTO {
	
	private String id;
	
	private String descripcion;
	
	private String valor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
