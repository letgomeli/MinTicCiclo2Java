
//import util.JDBCUtilities;
//import view.VistaRequerimientos;
//import java.sql.Connection;
import java.sql.SQLException;
import controller.ControladorRequerimientos;

/**
 * Aplicacion Proyectos Construcción
 *
 */
public class App {
  public static void main(String[] args) throws SQLException {

    // Inicio de la aplicación con GUI

    ControladorRequerimientos controlador = new ControladorRequerimientos();
    controlador.iniciarAplicacion();

    // System.out.println("Requerimiento 1");
    // VistaRequerimientos.requerimiento1();

    // System.out.println("\nRequerimiento 2");
    // VistaRequerimientos.requerimiento2();

    // System.out.println("\nRequerimiento 3");
    // VistaRequerimientos.requerimiento3();

    // Intentar conectarse a la base de datos

    // try (Connection conexion = JDBCUtilities.getConnection()) {

    // if (JDBCUtilities.estaVacia()) { System.out.println("Se encuentra vacía!"); }
    // else { System.out.println("No está vacía BD encontrada");

  } // Iniciariamos nuestra aplicación // Llamado al menú de inicio de la vista/view

  // } catch (SQLException e) {

  // System.err.println("Error iniciando conexión: " + e);

  // }

  // }
}
