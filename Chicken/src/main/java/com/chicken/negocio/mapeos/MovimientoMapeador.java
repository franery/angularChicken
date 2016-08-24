package com.chicken.negocio.mapeos;

import com.chicken.base.dto.DTO;
import com.chicken.base.mapeadores.Mapeador;
import com.chicken.persistencia.model.DepositoModel;
import com.chicken.persistencia.model.GallineroModel;
import com.chicken.persistencia.model.Modelo;
import com.chicken.persistencia.model.MovimientoModel;
import com.chicken.presentacion.bean.dto.DepositoDTO;
import com.chicken.presentacion.bean.dto.GallineroDTO;
import com.chicken.presentacion.bean.dto.MovimientoDTO;

public class MovimientoMapeador extends Mapeador {

	private DepositoMapeador depositoMapeador = new DepositoMapeador();
	private GallineroMapeador gallineroMapeador = new GallineroMapeador();
	
	@Override
	public DTO map(Modelo vo) {
		MovimientoModel model = (MovimientoModel) vo;
		MovimientoDTO dto = new MovimientoDTO();
		
		dto.setId(model.getId());
		dto.setCantidad(model.getCantidad());
		dto.setDeposito((DepositoDTO)depositoMapeador.map(model.getDeposito()));
		dto.setFecha(model.getFecha());
		dto.setGallinero((GallineroDTO)gallineroMapeador.map(model.getGallinero()));
		
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		MovimientoDTO movimientoDTO = (MovimientoDTO) dto;
		MovimientoModel movimientoModel = (MovimientoModel) (vo != null ? vo : new MovimientoModel());

		movimientoModel.setCantidad(movimientoDTO.getCantidad());
		movimientoModel.setDeposito((DepositoModel)depositoMapeador.map(movimientoDTO.getDeposito(),movimientoModel.getDeposito()));
		movimientoModel.setFecha(movimientoDTO.getFecha());
		movimientoModel.setGallinero((GallineroModel)gallineroMapeador.map(movimientoDTO.getGallinero(),movimientoModel.getGallinero()));
		
		return movimientoModel;
	}
}
