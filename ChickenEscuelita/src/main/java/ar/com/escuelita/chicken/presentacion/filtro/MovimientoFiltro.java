package ar.com.escuelita.chicken.presentacion.filtro;

import java.sql.Date;

public class MovimientoFiltro extends Filtro {

	private long productorId = -1;
	
	private Date fecha;
	
	private long cantidad = -1;

	public MovimientoFiltro() {
	}
	
	public long getProductorId() {
		return productorId;
	}

	public void setProductorId(long productorId) {
		this.productorId = productorId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
}
