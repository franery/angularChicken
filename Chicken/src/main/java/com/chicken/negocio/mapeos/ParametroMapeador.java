package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.ParametroModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.presentacion.bean.dto.ParametroDTO;

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
