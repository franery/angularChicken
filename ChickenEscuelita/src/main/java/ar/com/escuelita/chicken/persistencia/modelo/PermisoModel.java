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
	
	@Enumerated(EnumType.STRING)
	@Column(name="permiso")
	private String permiso;
	
	@Enumerated(EnumType.STRING)
	@Column(name="modulo")
	private String modulo;
	
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

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public List<PerfilModel> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<PerfilModel> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
}