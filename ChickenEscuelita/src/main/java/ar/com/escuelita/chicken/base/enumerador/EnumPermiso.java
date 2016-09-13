package ar.com.escuelita.chicken.base.enumerador;

public enum EnumPermiso {
	
	Crear("Crear"),
	Listar("Listar"),
	Modificar("Modificar"),
	Borrar("Borrar"),
	Exportar("Exportar");
	
	private EnumPermiso(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
}
