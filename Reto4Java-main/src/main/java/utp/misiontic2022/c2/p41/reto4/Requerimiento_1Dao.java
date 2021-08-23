package utp.misiontic2022.c2.p41.reto4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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