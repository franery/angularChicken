package ar.com.escuelita.chicken.base.constantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constantes {
	
	public static final String PRINCIPAL_VIEW = "template/principal";
	public static final String VACIA_VIEW = "vacia";
	public static final String LOGIN_VIEW = "login/login";
	public static final String DEPOSITOS_VIEW = "depositos/depositos";
	public static final String DEPOSITOS_NUEVO_VIEW = "depositos/depositosNuevo";
	public static final String DEPOSITOS_MODIFICAR_VIEW = "depositos/depositosModificar";
	public static final String GALLINEROS_VIEW = "gallineros/gallineros";
	public static final String GALLINEROS_NUEVO_VIEW = "gallineros/gallinerosNuevo";
	public static final String GALLINEROS_MODIFICAR_VIEW = "gallineros/gallinerosModificar";
	public static final String PRODUCCION_VIEW = "produccion/produccion";
	public static final String REPORTES_VIEW = "movimientos/reportes";
	public static final String NUEVO_MOVIMIENTO_VIEW = "movimientos/movimientosNuevo";
	public static final String PARAMETROS_VIEW = "parametros/parametros";
	public static final String PARAMETRO_NUEVO_VIEW = "parametros/parametrosNuevo";
	public static final String PARAMETRO_MODIFICAR_VIEW = "parametros/parametrosModificar";
	public static final String PERFILES_VIEW = "perfiles/perfiles";
	public static final String PERFILES_NUEVO_VIEW = "perfiles/perfilNuevo";
	public static final String PERFILES_MODIFICAR_VIEW = "perfiles/perfilModificar";
	public static final String PROVEEDORES_VIEW = "proveedores/proveedores";
	public static final String PROVEEDORES_NUEVO_VIEW = "proveedores/proveedoresNuevo";
	public static final String PROVEEDORES_MODIFICAR_VIEW = "proveedores/proveedoresModificar";
	public static final String USUARIOS_VIEW = "usuarios/usuarios";
	public static final String USUARIO_NUEVO_VIEW = "usuarios/usuariosNuevo";
	public static final String USUARIO_MODIFICAR_VIEW = "usuarios/usuariosModificar";
	public static final String VENTAS_VIEW = "ventas/ventas";
	public static final String VENTAS_NUEVO_VIEW = "ventas/ventasNuevo";
	public static final String EXCEPCION_VIEW = "login/excepcion";
	public static final String AYUDA_VIEW = "template/ayuda";
	public static final long USUARIO_ROOT_ID = 1;
	public static final long PERFIL_ROOT_ID = 1;
	public static final long STOCK_MINIMO = 0;
	public static final long NUMERO_MINIMO_TELEFONO = 8;
	public static final String DATA = "data";
	public static final String LOG_MASTER = "LogMaster";
	public static final Logger CHICKEN_LOG = LoggerFactory.getLogger(LOG_MASTER);

	public static final List<String> PERMISOS_ADMINISTRADOR = Collections.unmodifiableList(
		    new ArrayList<String>() {{
		        add("usuarios");
		        add("parametros");
		        add("perfiles");
		    }});
	public static final List<String> PERMISOS_CONTABLE = Collections.unmodifiableList(
		    new ArrayList<String>() {{
		        add("gallineros");
		        add("depositos");
		        add("proveedores");
		        add("produccion");
		        add("ventas");
		    }});
	public static final List<String> PERMISOS_PRODUCTOR = Collections.unmodifiableList(
		    new ArrayList<String>() {{
		        add("movimientos");
		    }});

}
