package ar.com.escuelita.chicken.presentacion.filtro;

public class VentaFiltro extends Filtro{
	
	private long proveedorId;
	private String fechaDesde;
	private String fechaHasta;
	private String cantidadDesde;
	private String cantidadHasta;
	
	public VentaFiltro(){
		
	}
	
	public long getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(long proveedorId) {
		this.proveedorId = proveedorId;
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
