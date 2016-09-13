package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.IUsuarioServicio;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IUsuarioValidacionServicio;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class UsuarioValidacionServicioImpl implements IUsuarioValidacionServicio {
	
	public static long USUARIO_ROOT_ID = 1;
	
	@Autowired 
	private IUsuarioServicio usuarioServicio;
	
	public UsuarioValidacionServicioImpl() {
		
	}
	
	@Override
	public void validacionNombreUsuario(String nombreUsuario) throws ValidacionExcepcion {
		List<DTO> listaUsuarios = (List<DTO>) usuarioServicio.listar();
		for(DTO dto : listaUsuarios) {
			if (((UsuarioDTO)dto).getNombreUsuario().equals(nombreUsuario)) {
				throw new ValidacionExcepcion("mensajeErrorUsuario");	
			}
		}
	}
	
	public void validacionBorrarUsuarioRoot(long usuarioId) throws ValidacionExcepcion {
		if(usuarioId == USUARIO_ROOT_ID) {
			throw new ValidacionExcepcion("mensajeErrorBorrarUsuarioRoot");
		}
	}
	
	public void validacionModificarUsuarioRoot(long usuarioActualId, long usuarioId) throws ValidacionExcepcion {
		if(usuarioId == USUARIO_ROOT_ID && usuarioActualId != USUARIO_ROOT_ID) {
			throw new ValidacionExcepcion("mensajeErrorModificarUsuarioRoot");
		}
	}
	
	public IUsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}

	public void setUsuarioServicio(IUsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}
}
