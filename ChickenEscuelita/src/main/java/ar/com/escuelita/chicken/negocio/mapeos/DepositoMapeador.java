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
		dto.setStockHuevos(String.valueOf(depositoModel.getStockHuevos()));
		dto.setStockMaximo(String.valueOf(depositoModel.getStockMaximo()));
		dto.setBorrado(String.valueOf(depositoModel.isBorrado()));
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		DepositoDTO depositoDTO = (DepositoDTO) dto;	
		DepositoModel depositoModel = (DepositoModel) (vo != null ? vo : new DepositoModel());
		
		depositoModel.setNombre(depositoDTO.getNombre());
		if(depositoDTO.getStockHuevos() != null) {
			depositoModel.setStockHuevos(Long.parseLong(depositoDTO.getStockHuevos()));
		}
		depositoModel.setStockMaximo(Long.parseLong(depositoDTO.getStockMaximo()));
		depositoModel.setBorrado(Boolean.parseBoolean(depositoDTO.getBorrado()));
		
		return depositoModel;
	}

}
