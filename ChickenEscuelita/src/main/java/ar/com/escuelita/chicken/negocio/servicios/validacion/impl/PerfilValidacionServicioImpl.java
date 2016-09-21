package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IPerfilServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IPerfilValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.PerfilDTO;

public class PerfilValidacionServicioImpl implements IPerfilValidacionServicio {
	
	@Autowired
	IPerfilServicio perfilServicio;
	
	public PerfilValidacionServicioImpl(){
		
	}
	
	@Override
	public void validacionPerfilRoot(String perfilId) throws ValidacionExcepcion {
		if(String.valueOf(Constantes.PERFIL_ROOT_ID).equals(perfilId)) {
			throw new ValidacionExcepcion("mensajeErrorPerfilRoot");
		}
	}

	@Override
	public void validacionNombreUnico(String nombre,String id) throws ValidacionExcepcion {
		for (DTO dto : perfilServicio.listar()) {
			PerfilDTO perfilDTO = (PerfilDTO) dto;
			if (perfilDTO.getNombre().equals(nombre) && !perfilDTO.getId().equals(id)) {
				throw new ValidacionExcepcion("mensajeErrorPerfil");
			}
		}
	}
	
	@Override
	public void validacionNombreNoVacio(String nombre) throws ValidacionExcepcion {
		if (nombre == null || nombre.isEmpty()) {
			throw new ValidacionExcepcion("mensajeErrorNombreVacio");
		}
	}
}
