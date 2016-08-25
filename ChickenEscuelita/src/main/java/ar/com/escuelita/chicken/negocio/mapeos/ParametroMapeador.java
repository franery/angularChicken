package ar.com.escuelita.chicken.negocio.mapeos;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.ParametroModel;
import ar.com.escuelita.chicken.presentacion.dto.ParametroDTO;

public class ParametroMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		ParametroModel parametroModel = (ParametroModel) vo;
		ParametroDTO dto = new ParametroDTO();
		
		dto.setId(parametroModel.getId());
		dto.setDescripcion(parametroModel.getDescripcion());
		dto.setValor(parametroModel.getValor());
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		ParametroDTO parametroDTO = (ParametroDTO) dto;	
		ParametroModel parametroModel = (ParametroModel) (vo != null ? vo : new ParametroModel());
		
		parametroModel.setDescripcion(parametroDTO.getDescripcion());
		parametroModel.setValor(parametroDTO.getValor());
		
		return parametroModel;
	}

}
