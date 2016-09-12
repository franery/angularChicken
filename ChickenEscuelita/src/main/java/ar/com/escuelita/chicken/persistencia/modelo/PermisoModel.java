package ar.com.escuelita.chicken.persistencia.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Permiso")
public class PermisoModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name="PerfilPermiso",//bd
	joinColumns={@JoinColumn(name="idPermiso")},//bd
	inverseJoinColumns={@JoinColumn(name="idPerfil")})//bd		
	private List<PerfilModel> listaPerfiles = new ArrayList<PerfilModel>();
	
	public PermisoModel(){
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

	public List<PerfilModel> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<PerfilModel> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
}