package ar.com.escuelita.chicken.presentacion.dto;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.base.enumerador.EnumModulo;
import ar.com.escuelita.chicken.base.enumerador.EnumOperacion;

public class PermisoDTO extends DTO {
	
	private String id;
	private EnumOperacion operacion;
	private EnumModulo modulo;
	
	
	/**
	 * Devuelve la descripcion del enumerador Operacion
	 * @return
	 */
	public String getNombreOperacion() {
		if (this.operacion != null) {
			return this.operacion.getNombre();
		}
		return "";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombreModulo() {
		if (this.modulo != null) {
			return this.modulo.name();
		}
		return "";
	}
	
	
	/***
	 * Getters & setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnumModulo getModulo() {
		return modulo;
	}

	public void setModulo(EnumModulo modulo) {
		this.modulo = modulo;
	}
	
	public EnumOperacion getOperacion() {
		return operacion;
	}

	public void setOperacion(EnumOperacion operacion) {
		this.operacion = operacion;
	}
}