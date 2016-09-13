package ar.com.escuelita.chicken.base.enumerador;

public enum EnumPermiso {
	
	C("Crear"),
	R("Listar"),
	U("Modificar"),
	D("Borrar"),
	E("Exportar");
	
	private String name;
	
	private EnumPermiso(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
