package ar.com.escuelita.chicken.base.enumerador;

public enum EnumOperacion {
	
	Crear("Crear"),
	Listar("Listar"),
	Modificar("Modificar"),
	Borrar("Borrar"),
	Exportar("Exportar");
	
	private String name;
	
	private EnumOperacion(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
