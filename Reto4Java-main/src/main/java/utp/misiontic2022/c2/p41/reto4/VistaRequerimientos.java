package utp.misiontic2022.c2.p41.reto4;
import java.sql.SQLException;
import java.util.ArrayList;

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
