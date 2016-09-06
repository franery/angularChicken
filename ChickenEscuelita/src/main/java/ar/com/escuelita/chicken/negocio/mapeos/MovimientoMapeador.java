package ar.com.escuelita.chicken.negocio.mapeos;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.dao.IGallineroDAO;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;
import ar.com.escuelita.chicken.presentacion.dto.MovimientoDTO;

public class MovimientoMapeador extends Mapeador {
	
	@Autowired
	private IDepositoDAO depositoDAO;
	
	@Autowired
	private IGallineroDAO gallineroDAO;
	
	@Override
	public DTO map(Modelo vo) {
		MovimientoModel model = (MovimientoModel) vo;
		MovimientoDTO dto = new MovimientoDTO();
		
		dto.setId(String.valueOf(model.getId()));
		dto.setCantidad(model.getCantidad());
		dto.setDepositoId(String.valueOf(model.getDeposito().getId()));
		dto.setDepositoNombre(model.getDeposito().getNombre());
		dto.setFecha(model.getFecha());
		dto.setGallineroId(String.valueOf(model.getGallinero().getId()));
		dto.setGallineroNombre(model.getGallinero().getNombre());
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		MovimientoDTO movimientoDTO = (MovimientoDTO) dto;
		MovimientoModel movimientoModel = (MovimientoModel) (vo != null ? vo : new MovimientoModel());

		movimientoModel.setCantidad(movimientoDTO.getCantidad());
		movimientoModel.setDeposito(depositoDAO.get(Long.parseLong(movimientoDTO.getDepositoId())));
		movimientoModel.setFecha(movimientoDTO.getFecha());
		movimientoModel.setGallinero(gallineroDAO.get(Long.parseLong(movimientoDTO.getGallineroId())));
		
		return movimientoModel;
	}
}
