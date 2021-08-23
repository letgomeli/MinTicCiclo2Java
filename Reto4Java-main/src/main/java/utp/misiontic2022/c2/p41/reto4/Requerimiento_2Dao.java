package utp.misiontic2022.c2.p41.reto4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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