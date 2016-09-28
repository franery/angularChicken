package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IMovimientoValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;

public class MovimientoValidacion implements Validator {

	@Autowired
	IMovimientoValidacionServicio movimientoValidacionServicio;
	
	public MovimientoValidacion() {
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MovimientoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errores) {
		MovimientoDTO movimiento = (MovimientoDTO) target;
		try {
			movimientoValidacionServicio.validacionStockDeposito(movimiento.getDepositoId(),movimiento.getCantidad());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("cantidad", e.getMessage(),"Mesnaje default");
		}
		try {
			movimientoValidacionServicio.validacionCantidadNoVacia(movimiento.getCantidad());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("cantidad", e.getMessage(),"Mesnaje default");
		}
		try {
			movimientoValidacionServicio.validacionCantidadNoNegativa(movimiento.getCantidad());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("cantidad", e.getMessage(),"Mesnaje default");
		}
		try {
			movimientoValidacionServicio.validacionFechaNoVacia(movimiento.getFecha());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("fecha", e.getMessage(),"Mesnaje default");
		}
		try {
			movimientoValidacionServicio.validacionGallineroId(movimiento.getGallineroId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("gallineroId", e.getMessage(),"Mesnaje default");
		}
		try {
			movimientoValidacionServicio.validacionDepositoId(movimiento.getDepositoId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("depositoId", e.getMessage(),"Mesnaje default");
		}
	}

	public IMovimientoValidacionServicio getMovimientoValidacionServicio() {
		return movimientoValidacionServicio;
	}

	public void setMovimientoValidacionServicio(
			IMovimientoValidacionServicio movimientoValidacionServicio) {
		this.movimientoValidacionServicio = movimientoValidacionServicio;
	}
}