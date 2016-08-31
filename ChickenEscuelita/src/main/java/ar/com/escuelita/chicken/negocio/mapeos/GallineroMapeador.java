package ar.com.escuelita.chicken.negocio.mapeos;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.mapeador.Mapeador;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;
import ar.com.escuelita.chicken.presentacion.dto.GallineroDTO;
import ar.com.escuelita.chicken.presentacion.dto.UsuarioDTO;

public class GallineroMapeador extends Mapeador {

	//private UsuarioMapeador usuarioMapeador = new UsuarioMapeador();
	@Autowired 
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public DTO map(Modelo vo) {
		GallineroModel gallineroModel = (GallineroModel) vo;
		GallineroDTO dto = new GallineroDTO();
		
		dto.setId(gallineroModel.getId());
		dto.setNombre(gallineroModel.getNombre());
		dto.setStockGallinas(gallineroModel.getStockGallinas());
		//dto.setUsuario((UsuarioDTO)usuarioMapeador.map(gallineroModel.getUsuario()));
		dto.setUsuarioId(gallineroModel.getUsuario().getId());
		dto.setUsuarioNombre(gallineroModel.getUsuario().getNombre());
		return dto;
	}

	@Override
	public Modelo map(DTO dto, Modelo vo) {
		GallineroDTO gallineroDTO = (GallineroDTO) dto;
		GallineroModel gallineroModel = (GallineroModel) (vo != null ? vo : new GallineroModel());
		
		gallineroModel.setNombre(gallineroDTO.getNombre());
		gallineroModel.setStockGallinas(gallineroDTO.getStockGallinas());
//		gallineroModel.setUsuario((UsuarioModel)usuarioMapeador.map(gallineroDTO.getUsuario(),gallineroModel.getUsuario()));
		gallineroModel.setUsuario(usuarioDAO.get(gallineroDTO.getUsuarioId()));
		return gallineroModel;
	}
}
