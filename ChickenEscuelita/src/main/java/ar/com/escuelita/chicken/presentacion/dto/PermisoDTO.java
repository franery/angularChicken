package ar.com.escuelita.chicken.presentacion.dto;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
import ar.com.escuelita.chicken.base.enumerador.EnumPermiso;

public class PermisoDTO extends DTO {
	
	private String id;
	
	private EnumPermiso permiso;
	
	private EnumModulo modulo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnumPermiso getPermiso() {
		return permiso;
	}

	public void setPermiso(EnumPermiso permiso) {
		this.permiso = permiso;
	}

	public EnumModulo getModulo() {
		return modulo;
	}

	public void setModulo(EnumModulo modulo) {
		this.modulo = modulo;
	}
}