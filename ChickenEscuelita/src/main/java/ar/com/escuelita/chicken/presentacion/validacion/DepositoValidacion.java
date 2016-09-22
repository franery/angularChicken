package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IDepositoValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

public class DepositoValidacion implements Validator{
	
	@Autowired
	private IDepositoValidacionServicio depositoValidacionServicio;
	
	public DepositoValidacion() {
		
	}
	
	public boolean supports(Class<?> clazz) {
		return DepositoDTO.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errores) {
		Constantes.CHICKEN_LOG.info("Controlador: {} ; Metodo: {} ;", DepositoValidacion.class, "validate");
		DepositoDTO deposito = (DepositoDTO) target;
		try {
			depositoValidacionServicio.validacionNombreNoVacio(deposito.getNombre());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			depositoValidacionServicio.validacionNombreUnico(deposito.getNombre(), deposito.getId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("nombre", e.getMessage(),"Mesnaje default");
		}
		try {
			depositoValidacionServicio.validacionStockMaximoNumero(deposito.getStockMaximo());;
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("stockMaximo", e.getMessage(),"Mesnaje default");
			return;
		}
		try {
			depositoValidacionServicio.validacionStockMaximoSuperiorMinimo(deposito.getStockMaximo());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("stockMaximo", e.getMessage(),"Mesnaje default");
		}
		try {
			depositoValidacionServicio.validacionStockMaximoMayorActual(deposito.getStockMaximo(), deposito.getStockHuevos());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("stockMaximo", e.getMessage(),"Mesnaje default");
		}
	}
}
