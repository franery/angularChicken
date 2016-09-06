package ar.com.escuelita.chicken.presentacion.dto;

import java.sql.Date;

import ar.com.escuelita.chicken.base.dto.DTO;

public class MovimientoDTO extends DTO {
	
	private String id;
	
	private Date fecha;
	
	private long cantidad;

	private String gallineroId;
	
	private String gallineroNombre;

	private String depositoId;
	
	private String depositoNombre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getGallineroId() {
		return gallineroId;
	}

	public void setGallineroId(String gallineroId) {
		this.gallineroId = gallineroId;
	}

	public String getDepositoId() {
		return depositoId;
	}

	public void setDepositoId(String depositoId) {
		this.depositoId = depositoId;
	}

	public String getGallineroNombre() {
		return gallineroNombre;
	}

	public void setGallineroNombre(String gallineroNombre) {
		this.gallineroNombre = gallineroNombre;
	}

	public String getDepositoNombre() {
		return depositoNombre;
	}

	public void setDepositoNombre(String depositoNombre) {
		this.depositoNombre = depositoNombre;
	}

}
