package ar.com.escuelita.chicken.presentacion.dto;

import ar.com.escuelita.chicken.base.dto.DTO;

public class DepositoDTO extends DTO {

	private String id;
	
	private String nombre;
	
	private String stockHuevos;
	
	private String stockMaximo;
	
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

	public String getStockHuevos() {
		return stockHuevos;
	}

	public void setStockHuevos(String stockHuevos) {
		this.stockHuevos = stockHuevos;
	}

	public String getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(String stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public String getBorrado() {
		return borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}
	
}
