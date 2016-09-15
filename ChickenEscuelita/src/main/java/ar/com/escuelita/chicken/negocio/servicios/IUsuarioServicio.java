package ar.com.escuelita.chicken.negocio.servicios;

import java.util.Collection;
import java.util.HashMap;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.excepciones.NegocioExcepcion;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

public interface IUsuarioServicio extends IServicio {

	HashMap<UsuarioDTO, Long> getTotalesProduccion(UsuarioFiltro usuarioFiltro);

	Collection<DTO> listarProductores();
}
