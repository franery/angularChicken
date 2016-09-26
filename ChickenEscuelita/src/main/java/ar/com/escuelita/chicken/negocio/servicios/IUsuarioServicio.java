package ar.com.escuelita.chicken.negocio.servicios;

import java.util.HashMap;
import java.util.List;

import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;
import ar.com.escuelita.chicken.presentacion.filtro.UsuarioFiltro;

public interface IUsuarioServicio extends IServicio {

	List<HashMap<String, String>> getTotalesProduccion(UsuarioFiltro usuarioFiltro);
}
