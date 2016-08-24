package com.chicken.persistencia.model;

import java.sql.Date;

import javax.persistence.*;

@Entity(name="Movimiento")
public class MovimientoModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="cantidad")
	private long cantidad;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="idGallinero")
	private GallineroModel gallinero;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="idDeposito")
	private DepositoModel deposito;
	
	public MovimientoModel() {
		
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

	public GallineroModel getGallinero() {
		return gallinero;
	}

	public void setGallinero(GallineroModel gallinero) {
		this.gallinero = gallinero;
	}

	public DepositoModel getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoModel deposito) {
		this.deposito = deposito;
	}	
}
