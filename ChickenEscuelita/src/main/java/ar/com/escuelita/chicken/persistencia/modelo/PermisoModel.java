package ar.com.escuelita.chicken.persistencia.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
import ar.com.escuelita.chicken.base.enumerador.EnumPermiso;

@Entity
@Table(name="Permiso")
public class PermisoModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="permiso")
	private EnumPermiso permiso;
	
	@Enumerated(EnumType.STRING)
	@Column(name="modulo")
	private EnumModulo modulo;
	
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

	public EnumPermiso getPermiso() {
		return permiso;
	}

	public void setPermiso(EnumPermiso permiso) {
		this.permiso = permiso;
	}

	public EnumModulo getModulo() {
		return modulo;
	}

	public void setModulo(EnumModulo modulo) {
		this.modulo = modulo;
	}

	public List<PerfilModel> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<PerfilModel> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
}