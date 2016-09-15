package ar.com.escuelita.chicken.base.enumerador;

public enum EnumOperacion {
	
	Crear("Crear"),
	Listar("Listar"),
	Modificar("Modificar"),
	Borrar("Borrar"),
	Exportar("Exportar");
	
	private String nombre;
	
	private EnumOperacion(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
