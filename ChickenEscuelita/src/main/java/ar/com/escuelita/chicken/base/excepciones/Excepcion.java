package ar.com.escuelita.chicken.base.excepciones;

public class Excepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public Excepcion() {
		super();
	}
	
	public Excepcion(String message) {
		super(message);
	}
}
