package ejercicio1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	private Connection conexion = null;
	private boolean fin = false;

	public void mostrarMenu() {
		Scanner teclado = new Scanner(System.in);
		int opcion = -1;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://54.90.239.12/ejercicioADT?useSSL=false", "root",
					"Elorrieta00");

			do {
				System.out.println("");
				System.out.println("MENU");
				System.out.println("");
				System.out.println("Elige una opcion");
				System.out.println(".0- Salir");
				System.out.println(".1- Mostrar departamentos");
				System.out.println(".2- Mostrar empleados departamento 10");
				System.out.println(".3- Mostrar empleSalMax");
				System.out.println("");
				opcion = teclado.nextInt();

				if (opcion >= 0 && opcion <= 3) {
					selector(opcion);
				} else {
					System.out.println("Opción no válida. Intenta de nuevo.");
				}

			} while (!fin);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void selector(int opcion) throws SQLException {
		switch (opcion) {
		case 0:
			fin = true;
			conexion.close();
			System.out.println("Programa finalizado.");
			break;
		case 1:
			mostrarDepartamentos();
			break;
		case 2:
			mostrarEmpleados();
			break;
		case 3:
			mostrarEmple();
			break;
		default:
			System.out.println("Opción inválida.");
		}
	}
	
	private void mostrarEmple() {
		Empleado empleado = getEmpleadosSalario();
		
		System.out.println("Apellido: " + empleado.getApellido());
		System.out.println("Salario: " + empleado.getSalario());
		System.out.println("Dnombre: " + empleado.getDnombre());

	}

	private void mostrarDepartamentos() {
		ArrayList<Departamento> departamentos = getAllDeparts();

		for (Departamento departamento : departamentos) {
			System.out.println("");
			System.out.println("Dept_no " + departamento.getDept_no());
			System.out.println("Dnombre " + departamento.getDnombre());
			System.out.println("Loc " + departamento.getLoc());
			System.out.println("--------------------------");
			System.out.println("");

		}
	}

	private void mostrarEmpleados() {
		ArrayList<Empleado> empleadosDep = getEmpleadosDep(10);

		for (Empleado empleado : empleadosDep) {
			System.out.println("");
			System.out.println("Apellido: " + empleado.getApellido());
			System.out.println("Oficio: " + empleado.getOficio());
			System.out.println("Salario: " + empleado.getSalario());
			System.out.println("-------------------------");
			System.out.println("");
		}
	}

	private ArrayList<Empleado> getEmpleadosDep(int dep) {
		ArrayList<Empleado> ret = new ArrayList<Empleado>();
		String sentencia = "call empleDepart(?)";

		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			callableStatement = conexion.prepareCall(sentencia);
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
				if (resultSet != null) {
					resultSet.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	private Empleado getEmpleadosSalario() {
		Empleado ret = new Empleado();
		String sentencia = "call empleSalMax()";

		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			callableStatement = conexion.prepareCall(sentencia);

			resultSet = callableStatement.executeQuery();

			while (resultSet.next()) {

				ret.setApellido(resultSet.getString("apellido"));
				ret.setSalario(resultSet.getFloat("salario"));
				ret.setDnombre(resultSet.getString("dnombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	private ArrayList<Departamento> getAllDeparts() {
		ArrayList<Departamento> ret = new ArrayList<Departamento>();
		String sentencia = "call departamentos()";

		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			callableStatement = conexion.prepareCall(sentencia);

			resultSet = callableStatement.executeQuery();

			while (resultSet.next()) {
				Departamento departamento = new Departamento();
				departamento.setDept_no(resultSet.getInt("dept_no"));
				departamento.setDnombre(resultSet.getString("dnombre"));
				departamento.setLoc(resultSet.getString("loc"));

				ret.add(departamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
}
