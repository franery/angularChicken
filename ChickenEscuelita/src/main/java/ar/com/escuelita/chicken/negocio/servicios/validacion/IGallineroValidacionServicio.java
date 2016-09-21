package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IGallineroValidacionServicio {

	void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion;
	void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion;
	void validacionStockSuperiorMinimo(String stockMaximo) throws ValidacionExcepcion;
	void validacionUsuarioExiste(String usuarioId) throws ValidacionExcepcion;
	
}