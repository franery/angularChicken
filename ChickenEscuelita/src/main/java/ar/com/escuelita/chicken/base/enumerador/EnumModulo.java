package ar.com.escuelita.chicken.base.enumerador;

public enum EnumModulo {
	
	USUARIOS("usuarios"),
	PROVEEDORES("proveedores"),
	PARAMETROS("parametros"),
	VENTAS("ventas"),
	MOVIMIENTOS("movimientos"),
	GALLINEROS("gallineros"),
	DEPOSITOS("depositos"),
	PERFILES("perfiles"),
	PRODUCCION("produccion");
	
	private String nombre;
	
	private EnumModulo(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}