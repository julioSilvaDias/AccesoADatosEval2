package bbdd;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bbdd.pojos.Departamentos;
import bbdd.pojos.Empleados;

public class GestorDepartamento {
	public ArrayList<Departamentos> getDepartContaInve(Departamentos dept1, Departamentos dept2){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        ArrayList<Departamentos> ret = null;
        Transaction tx = null;
        
        try {
        	session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            String hql = "FROM Departamentos d WHERE d.dnombre IN (:dept1, :dept2)";
            Query q = session.createQuery(hql);
            
            q.setParameter("dept1", dept1.getDnombre());
            q.setParameter("dept2", dept2.getDnombre());
            
            ret = (ArrayList<Departamentos>) q.list();
            
            tx.commit();
        }catch(Exception e) {
        	
        }
		
		return ret;
	}
}
