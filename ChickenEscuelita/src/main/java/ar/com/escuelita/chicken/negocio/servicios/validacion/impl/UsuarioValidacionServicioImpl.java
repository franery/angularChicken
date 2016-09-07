package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IUsuarioValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioValidacionServicioImpl implements IUsuarioValidacionServicio {

	@Autowired 
	IUsuarioServicio usuarioServicio;
	
	@Override
	public void validacionNombreUsuario(String nombreUsuario) throws ValidacionExcepcion {
		List<DTO> listaUsuarios = (List<DTO>) usuarioServicio.listar();
		for(DTO dto : listaUsuarios) {
			if (((UsuarioDTO)dto).getNombreUsuario().equals(nombreUsuario)) {
				System.out.println("LALALALALALALALALALALALALA");
				throw new ValidacionExcepcion("mensajeErrorUsuario");	
			}
		}
	}
}
