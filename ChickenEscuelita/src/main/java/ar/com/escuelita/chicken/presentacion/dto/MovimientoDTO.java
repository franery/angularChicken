package ar.com.escuelita.chicken.presentacion.dto;

import java.sql.Date;

import ar.com.escuelita.chicken.base.dto.DTO;

public class MovimientoDTO extends DTO {
	
	private long id;
	
	private Date fecha;
	
	private long cantidad;

	private long gallineroId;
	private String gallineroNombre;

	private long depositoId;
	private String depositoNombre;

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

	public long getGallineroId() {
		return gallineroId;
	}

	public void setGallineroId(long gallineroId) {
		this.gallineroId = gallineroId;
	}

	public long getDepositoId() {
		return depositoId;
	}

	public void setDepositoId(long depositoId) {
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
