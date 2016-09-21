package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IUsuarioValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioValidacionServicioImpl implements IUsuarioValidacionServicio {
	
	@Autowired 
	private IUsuarioServicio usuarioServicio;
	
	public UsuarioValidacionServicioImpl() {
		
	}
	
	@Override
	public void validacionNombreUsuario(String nombreUsuario, String usuarioId) throws ValidacionExcepcion {
		List<DTO> listaUsuarios = (List<DTO>) usuarioServicio.listar();
		for(DTO dto : listaUsuarios) {
			if (((UsuarioDTO)dto).getNombreUsuario().equals(nombreUsuario) && !((UsuarioDTO)dto).getId().equals(usuarioId)) {
				throw new ValidacionExcepcion("mensajeErrorUsuario");
			}
		}
	}
	
	public void validacionUsuarioRoot(String usuarioId) throws ValidacionExcepcion {
		if(String.valueOf(Constantes.USUARIO_ROOT_ID).equals(usuarioId)) {
			throw new ValidacionExcepcion("mensajeErrorUsuarioRoot");
		}
	}
	
	public IUsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}

	public void setUsuarioServicio(IUsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}
}
