package com.chicken.presentacion.bean.dto;

import com.chicken.base.dto.DTO;

public class DepositoDTO extends DTO {

	private long id;
	
	private String nombre;
	
	private long stockHuevos;
	
	private long stockMaximo;

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

	public long getStockHuevos() {
		return stockHuevos;
	}

	public void setStockHuevos(long stockHuevos) {
		this.stockHuevos = stockHuevos;
	}

	public long getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(long stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

}
