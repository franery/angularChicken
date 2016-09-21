package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IGallineroValidacionServicio {

	void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion;
	void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion;
	void validacionStockSuperiorMinimo(long stockMaximo) throws ValidacionExcepcion;
	
}