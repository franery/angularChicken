package ar.com.escuelita.chicken.presentacion.filtro;

public class DepositoFiltro extends Filtro{
	
	private String depositoNombre;
	private long depositoId;
	
	public DepositoFiltro(){
		
	}
	
	public long getDepositoId() {
		return depositoId;
	}

	public void setDepositoId(long depositoId) {
		this.depositoId = depositoId;
	}
	
	public String getDepositoNombre() {
		return depositoNombre;
	}

	public void setDepositoNombre(String depositoNombre) {
		this.depositoNombre = depositoNombre;
	}

}
