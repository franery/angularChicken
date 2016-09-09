package ar.com.escuelita.chicken.persistencia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Perfil")
public class PerfilModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="permiso")
	private String permiso;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return nombre;
	}

	public void setDescripcion(String descripcion) {
		this.nombre = descripcion;
	}

	public String getValor() {
		return permiso;
	}

	public void setValor(String valor) {
		this.permiso = valor;
	}
	
}
