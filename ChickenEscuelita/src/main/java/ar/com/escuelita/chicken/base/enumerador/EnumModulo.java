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
	
	private EnumModulo(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
}