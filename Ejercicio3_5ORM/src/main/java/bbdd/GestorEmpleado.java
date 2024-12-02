package bbdd;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bbdd.pojos.Empleados;


public class GestorEmpleado {
	public ArrayList<Empleados> getEmpleDepar(int id){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		sesion.openSession();
		Empleados empleado;
		
		return null;
	}
}
