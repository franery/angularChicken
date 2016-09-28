package ar.com.escuelita.chicken.presentacion.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IVentaValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.VentaDTO;

public class VentaValidacion implements Validator{
	
	@Autowired
	private IVentaValidacionServicio ventaValidacionServicio;
	
	public VentaValidacion() {
		
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return VentaDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errores) {
		VentaDTO venta = (VentaDTO) target;
		try {
			ventaValidacionServicio.validacionCantidad(venta.getCantidad());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("cantidad", e.getMessage(),"Mesnaje default");
		}
		try {
			ventaValidacionServicio.validacionProveedor(venta.getProveedorId());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("proveedorId", e.getMessage(),"Mesnaje default");
		}
		try {
			ventaValidacionServicio.validacionFechaNoVacia(venta.getFecha());
		} catch (ValidacionExcepcion e) {
			errores.rejectValue("fecha", e.getMessage(),"Mesnaje default");
		}
	}
}
