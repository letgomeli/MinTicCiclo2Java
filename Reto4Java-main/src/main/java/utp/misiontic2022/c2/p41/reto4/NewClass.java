
//package utp.misiontic2022.c2.p41.reto4;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.File;
import java.sql.DriverManager;


public class App {

    public static void main(String[] args) throws SQLException {
        System.out.println("Requerimiento 1");
        VistaRequerimientos.requerimiento1();

        System.out.println("\nRequerimiento 2");
        VistaRequerimientos.requerimiento2();

        System.out.println("\nRequerimiento 3");
        VistaRequerimientos.requerimiento3();
    }

}

//Vista
public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1() throws SQLException{
        ArrayList<Requerimiento_1> numLideresCiudad = controlador.consultarRequerimiento1();

        //Encabezado del resultado
        System.out.println("Nro_Lideres Ciudad_Residencia");
        try {
            for(Requerimiento_1 requerimiento : numLideresCiudad){
                System.out.println(requerimiento.getNumLideres()+ "  " +
                                   requerimiento.getCiudadResidencia());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento2()throws SQLException{
        ArrayList<Requerimiento_2> materialesNoPagados = controlador.consultarRequerimiento2();

        //Encabezado del resultado
        System.out.println("ID_Proyecto Proveedor Pagado  ID_MaterialConstruccion  Nombre_Material");
        try {
            for(Requerimiento_2 requerimiento : materialesNoPagados){
                System.out.println(requerimiento.getIdProyecto()+ "  " +
                                   requerimiento.getProveedor()+ "  " +
                                   requerimiento.getPagado()+ "  " +
                                   requerimiento.getIdMaterialConstruccion()+ "  " +
                                   requerimiento.getMaterialConstruccion());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3()throws SQLException{
        ArrayList<Requerimiento_3> lideresDebenDinero = controlador.consultarRequerimiento3();

        //Encabezado del resultado
        System.out.println("ID_Lider Nombre Primer_Apellido Segundo_Apellido");
        try {
            for(Requerimiento_3 requerimiento : lideresDebenDinero){
                System.out.println(requerimiento.getIdLider()+ "  " +
                                   requerimiento.getNombre()+ "  " +
                                   requerimiento.getPrimerApellido()+ "  " +
                                   requerimiento.getSegundoApellido());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}

//Controlador
public class ControladorRequerimientos {
    private final Requerimiento_1Dao requerimiento1;
    private final Requerimiento_2Dao requerimiento2;
    private final Requerimiento_3Dao requerimiento3;    
    
    public ControladorRequerimientos() {
        this.requerimiento1 = new Requerimiento_1Dao();
        this.requerimiento2 = new Requerimiento_2Dao();
        this.requerimiento3 = new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento_1> consultarRequerimiento1() throws SQLException{
        return this.requerimiento1.requerimiento1();
    }

    public ArrayList<Requerimiento_2> consultarRequerimiento2() throws SQLException{
        return this.requerimiento2.requerimiento2();
    }

    public ArrayList<Requerimiento_3> consultarRequerimiento3() throws SQLException{
        return this.requerimiento3.requerimiento3();
    }
}

//DAO's
public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException{
        ArrayList<Requerimiento_1> resultado = new ArrayList<Requerimiento_1>();
        Connection conexion = JDBCUtilities.getConnection();
        try{       

            String consulta = "select count(l.ID_Lider) numLideres, "+
                              "l.Ciudad_Residencia"+
                              " from Lider l "+
                              "group by l.Ciudad_Residencia;";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Requerimiento_1 requerimiento = new Requerimiento_1();
                requerimiento.setNumLideres(resultSet.getInt("numLideres"));
                requerimiento.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));
                resultado.add(requerimiento);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando Número de lideres por ciudad: "+e);
        
        }
        return resultado;
    }
}

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException{
        ArrayList<Requerimiento_2> resultado = new ArrayList<Requerimiento_2>();
        Connection conexion = JDBCUtilities.getConnection();
        try{       

            String consulta = "select c.ID_Proyecto, c.Proveedor, c.Pagado, mc.ID_MaterialConstruccion, mc.Nombre_Material"+
             " from compra c "+
            "inner join MaterialConstruccion mc on c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion "+
            "where c.Proveedor = 'Homecenter' and c.Pagado = 'No' order by c.ID_Proyecto;";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Requerimiento_2 requerimiento = new Requerimiento_2();
                requerimiento.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento.setProveedor(resultSet.getString("Proveedor"));
                requerimiento.setPagado(resultSet.getString("Pagado"));
                requerimiento.setIdMaterialConstruccion(resultSet.getInt("ID_MaterialConstruccion"));
                requerimiento.setMaterialConstruccion(resultSet.getString("Nombre_Material"));
                resultado.add(requerimiento);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando Materiales no pagados al proveedor Homecenter: "+e);
        
        }
        return resultado;
    }
}

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException{
        ArrayList<Requerimiento_3> resultado = new ArrayList<Requerimiento_3>();
        Connection conexion = JDBCUtilities.getConnection();
        try{  
            String consulta = "select distinct l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Segundo_Apellido"+
                              " from proyecto p "+
                              "inner join lider l on p.ID_Lider = l.ID_Lider";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Requerimiento_3 requerimiento = new Requerimiento_3();
                requerimiento.setIdLider(resultSet.getInt("ID_Lider"));
                requerimiento.setNombre(resultSet.getString("Nombre"));
                requerimiento.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                requerimiento.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                resultado.add(requerimiento);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando Proyectos que deben dinero por compra de materiales: "+e);
        
        }
        return resultado;
    }    
}

//VO's
public class Requerimiento_1 {
    private int numLideres;
    private String ciudadResidencia;  
    
    public Requerimiento_1(){

    }

    public Requerimiento_1(int numLideres, String ciudadResidencia) {
        this.numLideres = numLideres;
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getNumLideres() {
        return numLideres;
    }

    public void setNumLideres(int numLideres) {
        this.numLideres = numLideres;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
}

public class Requerimiento_2 {
    private int idProyecto;
    private String proveedor;
    private String pagado;
    private int idMaterialConstruccion;
    private String materialConstruccion;

    public Requerimiento_2() {

    }

    public Requerimiento_2(int idProyecto, String proveedor, String pagado, int idMaterialConstruccion,
            String materialConstruccion) {
        this.idProyecto = idProyecto;
        this.proveedor = proveedor;
        this.pagado = pagado;
        this.idMaterialConstruccion = idMaterialConstruccion;
        this.materialConstruccion = materialConstruccion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public int getIdMaterialConstruccion() {
        return idMaterialConstruccion;
    }

    public void setIdMaterialConstruccion(int idMaterialConstruccion) {
        this.idMaterialConstruccion = idMaterialConstruccion;
    }

    public String getMaterialConstruccion() {
        return materialConstruccion;
    }

    public void setMaterialConstruccion(String materialConstruccion) {
        this.materialConstruccion = materialConstruccion;
    } 
}

public class Requerimiento_3 {
    private int idLider;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    
    public Requerimiento_3() {
    }

    public Requerimiento_3(int idLider, String nombre, String primerApellido, String segundoApellido) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public int getIdLider() {
        return idLider;
    }

    public void setIdLider(int idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
}

public class JDBCUtilities {
    private static final String DATABASE_LOCATION = "ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException{
        String url = "jdbc:sqlite:"+DATABASE_LOCATION;

        return DriverManager.getConnection(url);
    }
}