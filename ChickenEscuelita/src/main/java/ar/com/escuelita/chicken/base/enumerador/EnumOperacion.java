package ar.com.escuelita.chicken.base.enumerador;

public enum EnumOperacion {
	
	CREAR("Crear"),
	LISTAR("Listar"),
	MODIFICAR("Modificar"),
	BORRAR("Borrar"),
	EXPORTAR("Exportar");
	
	private String nombre;
	
	private EnumOperacion(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
