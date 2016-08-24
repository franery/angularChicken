package com.chicken.persistencia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="Gallinero")
public class GallineroModel extends Modelo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="idUsuario")
	private UsuarioModel usuario;
	
	@OneToMany(mappedBy="gallinero",fetch=FetchType.EAGER)
	private List<MovimientoModel> listaMovimientos = new ArrayList<>();	
	
	@Column(name="stockGallinas")
	private long stockGallinas;
	
	public GallineroModel() {		
	}

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

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public List<MovimientoModel> getListaMovimientos() {
		return listaMovimientos;
	}

	public void setListaMovimientos(List<MovimientoModel> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}

	public long getStockGallinas() {
		return stockGallinas;
	}

	public void setStockGallinas(long stockGallinas) {
		this.stockGallinas = stockGallinas;
	}
	
}
