package ar.com.escuelita.chicken.negocio.servicios;

import java.util.HashMap;

import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

public interface IUsuarioServicio extends IServicio {

	HashMap<UsuarioDTO, Long> getTotalesProduccion(UsuarioFiltro usuarioFiltro);
}
