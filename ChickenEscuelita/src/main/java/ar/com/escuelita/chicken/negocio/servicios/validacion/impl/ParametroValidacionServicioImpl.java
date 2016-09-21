package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IParametroServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IParametroValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;

public class ParametroValidacionServicioImpl implements IParametroValidacionServicio {
	
	@Autowired 
	private IParametroServicio parametroServicio;
	
	public ParametroValidacionServicioImpl() {
		
	}
	
	@Override
	public void validacionDescripcionParametro(String descripcionParametro, String parametroId) throws ValidacionExcepcion {
		List<DTO> listaParametros = (List<DTO>) parametroServicio.listar();
		for(DTO dto : listaParametros) {
			if (((ParametroDTO)dto).getDescripcion().equals(descripcionParametro) && !((ParametroDTO)dto).getId().equals(parametroId)) {
				throw new ValidacionExcepcion("mensajeErrorParametro");
			}
		}
	}
	
	public void validacionNombreNoVacio(String descripcion) throws ValidacionExcepcion {
		if (descripcion == null || descripcion.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorNombreVacio");
		}
	}
}
