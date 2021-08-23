package model.dao;

import model.vo.Requerimiento_3;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Requerimiento_3Dao {
	public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
		ArrayList<Requerimiento_3> resultado = new ArrayList<Requerimiento_3>();
		Connection conexion = JDBCUtilities.getConnection();
		try {
			String consulta = "select distinct l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Segundo_Apellido"
					+ " from proyecto p " + "inner join lider l on p.ID_Lider = l.ID_Lider";
			PreparedStatement statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Requerimiento_3 requerimiento = new Requerimiento_3();
				requerimiento.setIdLider(resultSet.getInt("ID_Lider"));
				requerimiento.setNombre(resultSet.getString("Nombre"));
				requerimiento.setPrimerApellido(resultSet.getString("Primer_Apellido"));
				requerimiento.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
				resultado.add(requerimiento);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			System.err.println("Error consultando Proyectos que deben dinero por compra de materiales: " + e);
		} finally {
			if (conexion != null) {
				conexion.close();
			}

		}
		return resultado;
	}
}
