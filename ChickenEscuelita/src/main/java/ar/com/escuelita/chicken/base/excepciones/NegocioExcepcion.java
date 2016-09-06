package ar.com.escuelita.chicken.base.excepciones;

public class NegocioExcepcion extends Exception {
	
	private static final long serialVersionUID = 1658413577187121146L;

	public NegocioExcepcion() {
		super();
	}
	
	public NegocioExcepcion(String message) {
		super(message);
	}	
}