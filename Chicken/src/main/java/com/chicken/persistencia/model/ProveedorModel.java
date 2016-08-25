package com.chicken.persistencia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="Proveedor")
public class ProveedorModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="telefono")
	private String telefono;
	
	@OneToMany(mappedBy="proveedor",fetch=FetchType.EAGER)
	private List<VentaModel> listaVentas = new ArrayList<>();
	
	public ProveedorModel() {
		
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<VentaModel> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<VentaModel> listaVentas) {
		this.listaVentas = listaVentas;
	}
	
	
}
