package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IDepositoValidacionServicio {
	
	void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion;
	void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion;
	void validacionStockMaximoSuperiorMinimo(long stockMaximo) throws ValidacionExcepcion;
	void validacionStockMaximoMayorActual(long stockMaximo, long stockActual) throws ValidacionExcepcion;
}
