package ar.com.escuelita.chicken.negocio.servicios;

import java.util.Collection;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.presentacion.filtro.Filtro;

public interface IServicio {
	
	DTO buscar(long id);
	
	Collection<DTO> listar();
	
	Collection<DTO> listar(Filtro filtro);
	
	void crear(DTO dto);
	
	void modificar(DTO dto);
	
	void borrar(DTO dto);
	
}
