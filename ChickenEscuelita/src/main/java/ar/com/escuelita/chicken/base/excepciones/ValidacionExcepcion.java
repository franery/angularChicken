package ar.com.escuelita.chicken.base.excepciones;

public class ValidacionExcepcion extends NegocioExcepcion {

	private static final long serialVersionUID = 2525664988234516584L;
	
	public ValidacionExcepcion() {
		super();
	}
	
	public ValidacionExcepcion(String message) {
		super(message);
	}
	
}
