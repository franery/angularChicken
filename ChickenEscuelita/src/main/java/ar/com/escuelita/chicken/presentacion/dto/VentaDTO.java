package ar.com.escuelita.chicken.presentacion.dto;

import java.sql.Date;

import ar.com.escuelita.chicken.base.dto.DTO;

public class VentaDTO extends DTO {
	
	private long id;
	
	private Date fecha;
	
	private long cantidad;
	
	private float precio;
	
	private long usuarioId;
	private String usuarioNombre;

	private long proveedorId;
	private String proveedorNombre;

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public long getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(long proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getProveedorNombre() {
		return proveedorNombre;
	}

	public void setProveedorNombre(String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}

}
