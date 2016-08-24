package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.DepositoModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.presentacion.bean.dto.DepositoDTO;

public class DepositoMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		DepositoModel depositoModel = (DepositoModel) vo;
		DepositoDTO dto = new DepositoDTO();
		
		dto.setId(depositoModel.getId());
		dto.setNombre(depositoModel.getNombre());
		dto.setStockHuevos(depositoModel.getStockHuevos());
		dto.setStockMaximo(depositoModel.getStockMaximo());
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		DepositoDTO depositoDTO = (DepositoDTO) dto;	
		DepositoModel depositoModel = (DepositoModel) (vo != null ? vo : new DepositoModel());
		
		depositoModel.setNombre(depositoDTO.getNombre());
		depositoModel.setStockHuevos(depositoDTO.getStockHuevos());
		depositoModel.setStockMaximo(depositoDTO.getStockMaximo());
		
		return depositoModel;
	}

}
