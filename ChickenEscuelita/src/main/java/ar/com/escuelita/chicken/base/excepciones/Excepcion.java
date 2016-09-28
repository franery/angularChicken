package ar.com.escuelita.chicken.base.excepciones;

import java.util.Date;

public class Excepcion extends Exception {

	private static final long serialVersionUID = 1L;

	private long timeError;

	public Excepcion() {
		super();
		this.timeError = new Date().getTime();
	}
	
	public Excepcion(String message) {
		super(message);
	}
	
	public Excepcion(Throwable cause) {
		super(cause);
	}

	public long getTimeError() {
		return timeError;
	}

	public void setTimeError(long timeError) {
		this.timeError = timeError;
	}
}
