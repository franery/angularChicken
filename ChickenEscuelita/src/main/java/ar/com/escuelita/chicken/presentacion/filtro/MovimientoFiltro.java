package ar.com.escuelita.chicken.presentacion.filtro;

public class MovimientoFiltro extends Filtro {

	private long productorId = -1;
	
	private String fechaDesde;
	
	private String fechaHasta;
	
	private String cantidadDesde;
	
	private String cantidadHasta;

	public MovimientoFiltro() {
	}
	
	public long getProductorId() {
		return productorId;
	}

	public void setProductorId(long productorId) {
		this.productorId = productorId;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getCantidadDesde() {
		return cantidadDesde;
	}

	public void setCantidadDesde(String cantidadDesde) {
		this.cantidadDesde = cantidadDesde;
	}

	public String getCantidadHasta() {
		return cantidadHasta;
	}

	public void setCantidadHasta(String cantidadHasta) {
		this.cantidadHasta = cantidadHasta;
	}

}
