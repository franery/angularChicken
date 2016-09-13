package ar.com.escuelita.chicken.base.enumerador;

public enum EnumPermiso {
	
	C("crear"),
	R("listar"),
	U("modificar"),
	D("borrar"),
	E("exportar");
	
	private String name;
	
	private EnumPermiso(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
