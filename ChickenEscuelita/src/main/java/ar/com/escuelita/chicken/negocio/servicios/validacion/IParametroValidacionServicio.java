package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IParametroValidacionServicio {

	void validacionDescripcionParametro(String descripcionParametro, String parametroId) throws ValidacionExcepcion;
	void validacionNombreNoVacio(String descripcion) throws ValidacionExcepcion;
}
