package com.chicken.persistencia.model;

import java.sql.Date;

import javax.persistence.*;

@Entity(name="Venta")
public class VentaModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="cantidad")
	private long cantidad;
	
	@Column(name="precio")
	private float precio;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="idUsuario")
	private UsuarioModel usuario;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="idProveedor")
	private ProveedorModel proveedor;
	
	public VentaModel() {
		
	}

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

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public ProveedorModel getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorModel proveedor) {
		this.proveedor = proveedor;
	}
}
