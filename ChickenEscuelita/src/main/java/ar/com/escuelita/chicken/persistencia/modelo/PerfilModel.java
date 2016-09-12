package ar.com.escuelita.chicken.persistencia.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Perfil")
public class PerfilModel extends Modelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name="PerfilUsuario",//bd
	joinColumns={@JoinColumn(name="idPerfil")},//bd
	inverseJoinColumns={@JoinColumn(name="idUsuario")})//bd		
	private List<UsuarioModel> listaUsuarios = new ArrayList<UsuarioModel>();
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name="PerfilPermiso",//bd
	joinColumns={@JoinColumn(name="idPerfil")},//bd
	inverseJoinColumns={@JoinColumn(name="idPermiso")})//bd		
	private List<PermisoModel> listaPermisos = new ArrayList<PermisoModel>();
	
	public PerfilModel(){
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

	public List<UsuarioModel> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioModel> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<PermisoModel> getListaPermisos() {
		return listaPermisos;
	}

	public void setListaPermisos(List<PermisoModel> listaPermisos) {
		this.listaPermisos = listaPermisos;
	}
}