package com.chicken.negocio.servicios;

import java.util.Collection;

import com.chicken.base.dto.DTO;

public interface IServicio {
	
	DTO buscar(long id);
	
	Collection<DTO> listar();
	
	void crear(DTO dto);
	
	void modificar(DTO dto);
	
	void borrar(DTO dto);
	
}
