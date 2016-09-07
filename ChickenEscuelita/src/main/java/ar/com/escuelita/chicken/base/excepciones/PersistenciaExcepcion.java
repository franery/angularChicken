package ar.com.escuelita.chicken.base.excepciones;

public class PersistenciaExcepcion extends Excepcion {

	private static final long serialVersionUID = -295681890231255878L;

	private static final String MENSAJE_ERROR ="Hubo un error al intentar persistir los datos";
	
	public PersistenciaExcepcion() {
		super(MENSAJE_ERROR);
	}
	
	public PersistenciaExcepcion(String message) {
		super(message);
	}
	
}
