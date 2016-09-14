package ar.com.escuelita.chicken.presentacion.filtro;

public class PerfilFiltro extends Filtro {
	
	private long perfilId;
	
	public PerfilFiltro(){
	}
	
	public PerfilFiltro(long id){
		this.perfilId = id;
	}

	public long getPerfilId() {
		return perfilId;
	}
	
	public void setPerfilId(long perfilId) {
		this.perfilId = perfilId;
	}
}
