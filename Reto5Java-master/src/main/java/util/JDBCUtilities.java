package util;

//Librerias para conexión a base de datos
import java.sql.Connection;
import util.JDBCUtilities;
import java.sql.DriverManager;
import java.sql.SQLException;
//Librería para archivos
import java.io.File;

public class JDBCUtilities {

	// Ubicación de la base de datos que soporta este SW
	private static final String UBICACION_BD = "ProyectosConstruccion.db";

	// Método para proveer conexión
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlite:" + UBICACION_BD;
		try {
			return DriverManager.getConnection(url);
		} catch (Exception e) {
			return null;
		}

	}

	// Metodo complementario -> sqlite si no existe la base de datos, la crea
	// (vacía)
	public static boolean estaVacia() {
		File archivo = new File(JDBCUtilities.UBICACION_BD);
		return archivo.length() == 0;

	}

	// Inicialización de la base de datos
	// ...

}
