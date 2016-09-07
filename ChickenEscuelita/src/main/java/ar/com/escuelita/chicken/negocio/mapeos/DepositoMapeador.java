package ar.com.escuelita.chicken.negocio.mapeos;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.presentacion.dto.DepositoDTO;

public class DepositoMapeador extends Mapeador {

	@Override
	public DTO map(Modelo vo) {
		DepositoModel depositoModel = (DepositoModel) vo;
		DepositoDTO dto = new DepositoDTO();
		
		dto.setId(String.valueOf(depositoModel.getId()));
		dto.setNombre(depositoModel.getNombre());
		dto.setStockHuevos(depositoModel.getStockHuevos());
		dto.setStockMaximo(depositoModel.getStockMaximo());
		dto.setBorrado(depositoModel.isBorrado());
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		DepositoDTO depositoDTO = (DepositoDTO) dto;	
		DepositoModel depositoModel = (DepositoModel) (vo != null ? vo : new DepositoModel());
		
		depositoModel.setNombre(depositoDTO.getNombre());
		depositoModel.setStockHuevos(depositoDTO.getStockHuevos());
		depositoModel.setStockMaximo(depositoDTO.getStockMaximo());
		depositoModel.setBorrado(depositoDTO.isBorrado());
		
		return depositoModel;
	}

}
