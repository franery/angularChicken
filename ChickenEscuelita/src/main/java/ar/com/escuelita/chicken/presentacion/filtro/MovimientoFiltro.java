package ar.com.escuelita.chicken.presentacion.filtro;

public class MovimientoFiltro extends Filtro {

	private long productorId = -1;
	
	private String fecha;
	
	private String cantidad;

	public MovimientoFiltro() {
	}
	
	public long getProductorId() {
		return productorId;
	}

	public void setProductorId(long productorId) {
		this.productorId = productorId;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}
