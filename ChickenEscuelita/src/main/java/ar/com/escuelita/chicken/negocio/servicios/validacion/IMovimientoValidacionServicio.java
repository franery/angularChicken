package ar.com.escuelita.chicken.negocio.servicios.validacion;

import java.sql.Date;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IMovimientoValidacionServicio {

	void validacionStockDeposito(String depositoId, long cantidad) throws ValidacionExcepcion;
	void validacionCantidadNoVacia(long cantidad) throws ValidacionExcepcion;
	void validacionCantidadNoNegativa(long cantidad) throws ValidacionExcepcion;
	void validacionFechaNoVacia(Date fecha) throws ValidacionExcepcion;
	void validacionGallineroId(String gallineroId) throws ValidacionExcepcion;
	void validacionDepositoId(String depositoId) throws ValidacionExcepcion;
}
