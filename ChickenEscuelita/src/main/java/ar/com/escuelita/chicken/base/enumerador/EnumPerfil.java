package ar.com.escuelita.chicken.base.enumerador;

public enum EnumPerfil {
	ADMINISTRADOR("ADMINISTRADOR"),
	CONTABLE("CONTABLE"),
	PRODUCTOR("PRODUCTOR");
	
	private EnumPerfil(String name){
		this.name = name;
	}
	private String name;
	
	public String getName() {
		return name;
	}
}
