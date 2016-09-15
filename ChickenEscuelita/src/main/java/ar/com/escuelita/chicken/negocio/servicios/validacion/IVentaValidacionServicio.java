package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IVentaValidacionServicio {
	
	void validacionCantidad(long cantidad) throws ValidacionExcepcion;
}
