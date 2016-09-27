package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IProveedorValidacionServicio {
	
	void validacionNombreUnico(String nombre, String id) throws ValidacionExcepcion;
	void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion;
	void validacionDireccionNoVacio(String direccion) throws ValidacionExcepcion;
	void validacionMail(String mail) throws ValidacionExcepcion;
	void validacionTelefono(String telefono) throws ValidacionExcepcion;
}
