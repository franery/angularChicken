package ar.com.escuelita.chicken.negocio.servicios.validacion;

import java.sql.Date;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IVentaValidacionServicio {
	
	void validacionCantidad(long cantidad) throws ValidacionExcepcion;
	void validacionProveedor(String proveedorId) throws ValidacionExcepcion;
	void validacionFechaNoVacia(Date fecha) throws ValidacionExcepcion;
}
