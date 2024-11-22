package ejercicio1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ejercicio1 {
	private static Connection conexion = null;

	public static void main(String[] args) {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://54.86.232.140/ejercicioADT?useSSL=false", "root",
					"Elorrieta00");

			ArrayList<Empleado> empleadosDep = getEmpleadosDep(10);

			for (Empleado empleado : empleadosDep) {
				System.out.println("Apellido: " + empleado.getApellido());
				System.out.println("Oficio: " + empleado.getOficio());
				System.out.println("Salario: " + empleado.getSalario());
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static ArrayList<Empleado> getEmpleadosDep(int dep) {
		ArrayList<Empleado> ret = new ArrayList<>();
		String sql = "SELECT apellido, oficio, salario FROM empleados WHERE dept_no = ?";

		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			callableStatement = conexion.prepareCall(sql);
			callableStatement.setInt(1, dep);

			resultSet = callableStatement.executeQuery();

			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setApellido(resultSet.getString("apellido"));
				empleado.setOficio(resultSet.getString("oficio"));
				empleado.setSalario(resultSet.getFloat("salario"));

				ret.add(empleado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (callableStatement != null)
					callableStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
	
}
