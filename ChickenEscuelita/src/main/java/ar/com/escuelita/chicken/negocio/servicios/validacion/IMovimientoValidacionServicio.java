package ar.com.escuelita.chicken.negocio.servicios.validacion;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;

public interface IMovimientoValidacionServicio {

	void validacionStockDeposito(String depositoId, long cantidad) throws ValidacionExcepcion;
}
