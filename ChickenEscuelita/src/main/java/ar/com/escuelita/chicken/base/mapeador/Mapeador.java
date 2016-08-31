package ar.com.escuelita.chicken.base.mapeador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import ar.com.escuelita.chicken.base.dto.DTO;
import ar.com.escuelita.chicken.persistencia.modelo.Modelo;

public abstract class Mapeador {

	public abstract DTO map(Modelo vo);
	
	public abstract Modelo map(DTO dto, Modelo vo);
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection map(Collection sourceLista) {
		Collection newCol;
		
		if (sourceLista instanceof Set) {
			newCol = new HashSet();
		} else {
			newCol = new ArrayList();
		}
		
		for (Object obj: sourceLista) {
			if (obj instanceof DTO) {
				Modelo modelo = map((DTO) obj, null);
				newCol.add(modelo);
			} else if (obj instanceof Modelo) {
				DTO dto = map((Modelo) obj);
				newCol.add(dto);
			}
		}
		
		return newCol;
	}

}
