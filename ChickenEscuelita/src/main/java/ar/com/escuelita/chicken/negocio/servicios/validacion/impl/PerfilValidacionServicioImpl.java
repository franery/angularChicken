package ar.com.escuelita.chicken.negocio.servicios.validacion.impl;

import ar.com.escuelita.chicken.base.excepciones.ValidacionExcepcion;
import ar.com.escuelita.chicken.negocio.servicios.validacion.IPerfilValidacionServicio;

public class PerfilValidacionServicioImpl implements IPerfilValidacionServicio {
	
	public static long PERFIL_ROOT_ID = 1;
	
	public PerfilValidacionServicioImpl(){
		
	}
	
	public void validacionPerfilRoot(String perfilId) throws ValidacionExcepcion {
		if(String.valueOf(PERFIL_ROOT_ID).equals(perfilId)) {
			throw new ValidacionExcepcion("mensajeErrorPerfilRoot");
		}
	}
}
