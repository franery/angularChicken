package com.chicken.presentacion.bean.dto;

import java.sql.Date;

import com.chicken.base.dto.DTO;

public class MovimientoDTO extends DTO {
	private long id;
	
	private Date fecha;
	
	private long cantidad;

	private GallineroDTO gallinero;

	private DepositoDTO deposito;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public GallineroDTO getGallinero() {
		return gallinero;
	}

	public void setGallinero(GallineroDTO gallinero) {
		this.gallinero = gallinero;
	}

	public DepositoDTO getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoDTO deposito) {
		this.deposito = deposito;
	}

}
