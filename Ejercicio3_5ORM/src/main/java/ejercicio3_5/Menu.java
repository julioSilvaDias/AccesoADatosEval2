package ejercicio3_5;

import java.util.ArrayList;
import java.util.Scanner;

import bbdd.GestorDepartamento;
import bbdd.GestorEmpleado;
import bbdd.pojos.Departamentos;
import bbdd.pojos.Empleados;

public class Menu {
	private boolean fin = false;
	private GestorEmpleado gestorEmpleado = new GestorEmpleado();
	private GestorDepartamento gestorDepartamento = new GestorDepartamento();

	public void mostrarMenu() {

		Scanner teclado = new Scanner(System.in);
		int opcion = -1;

		try {

			do {
				System.out.println("");
				System.out.println("MENU");
				System.out.println("");
				System.out.println("Elige una opcion");
				System.out.println(".0- Salir");
				System.out.println(".1- Mostrar empleados departamento 10");
				System.out.println(".2- Mostrar empleado salario mas alto");
				System.out.println(".3- Mostrar departamento Contabilidad y Investigacion");
				System.out.println(".4- Mostrar empleado Director Contabilidad");
				System.out.println(".5- Mostrar empleados fecha alta 17-12-1990");
				System.out.println(".6- Mostrar empleado con mejor sueldo de madrid");
				System.out.println(".7- Mostrar salario del director cuyo empleado tiene la comision mas alta");
				System.out.println(".8- Mostrar fecha de alta del empleado que mas salario tiene en Barcelona");
				System.out.println(".9- Insertar nuevo Departamento informatica");
				System.out.println(".10- Insertar director a informatica");
				System.out.println(".11- Modificar salario GIL");
				System.out.println(".12- Eliminar empleados de Madrid");
				System.out.println(".13- Eliminar empleado de Contabilidad");

				System.out.println("");
				opcion = teclado.nextInt();

				if (opcion >= 0 && opcion <= 13) {
					selector(opcion);
				} else {
					System.out.println("Opción no válida. Intenta de nuevo.");
				}

			} while (!fin);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void selector(int opcion) {
		switch (opcion) {
		case 0:
			fin = true;
			System.out.println("Programa finalizado.");
			break;
			
		case 1:
			getEmpleDepar10();
			break;
			
		case 2:
			getEmpleMaxSal();
			break;
			
		case 3:
			getDeptContaInve();
			break;
			
		case 4:
			getEmpleDepartConta();
			break;
			
		case 5:

		case 6:

		case 7:

		case 8:

		case 9:

		case 10:

		case 11:

		case 12:

		case 13:

		}
	}

	private void getEmpleDepartConta() {
		ArrayList<Empleados> emples = gestorEmpleado.getEmpleDepartConta("Director", "CONTABILIDAD");
	    if (emples != null && !emples.isEmpty()) {
	        mostrarEmpleados(emples);
	    } else {
	        System.out.println("No se encontraron empleados para el criterio especificado.");
	    }
		
	}

	private void getDeptContaInve() {
		Departamentos dept1 = new Departamentos();
		Departamentos dept2 = new Departamentos();
		dept1.setDnombre("CONTABILIDAD");
		dept2.setDnombre("INVESTIGACION");
		
		ArrayList<Departamentos> departs = gestorDepartamento.getDepartContaInve(dept1, dept2);
		mostrarDeparts(departs);
	}

	private void mostrarDeparts(ArrayList<Departamentos> departs) {
			for(Departamentos departamento : departs) {
				mostrarDepart(departamento);
			}
	}

	private void mostrarDepart(Departamentos departamento) {
		System.out.println("");
		System.out.println(departamento.toString());		
	}

	private void getEmpleMaxSal() {
		Empleados empleado = gestorEmpleado.getEmpleMaxSal();
		mostrarEmpleado(empleado);
	}

	private void getEmpleDepar10() {
		byte numDepart = 10;
		Departamentos dept = new Departamentos();
		dept.setDeptNo(numDepart);
		ArrayList<Empleados> empleados = gestorEmpleado.getEmpleDepar(dept);
		mostrarEmpleados(empleados);
	}

	private void mostrarEmpleados(ArrayList<Empleados> empleados) {
		for (Empleados empleado : empleados) {
			mostrarEmpleado(empleado);
		}
	}

	private void mostrarEmpleado(Empleados empleado) {
		System.out.println("");
		System.out.println(empleado.toString());
	}

}
