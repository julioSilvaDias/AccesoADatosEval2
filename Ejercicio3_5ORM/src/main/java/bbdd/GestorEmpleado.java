package bbdd;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bbdd.pojos.Departamentos;
import bbdd.pojos.Empleados;

public class GestorEmpleado {

    public ArrayList<Empleados> getEmpleDepar(Departamentos departamentos) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        ArrayList<Empleados> ret = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Departamentos dept = session.get(Departamentos.class, departamentos.getDeptNo());

            if (null != dept) {
                ret = new ArrayList<Empleados>(dept.getEmpleadoses());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return ret;
    }

    public Empleados getEmpleMaxSal() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Empleados ret = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            String hql = "FROM Empleados e WHERE e.salario = (SELECT MAX(e2.salario) FROM Empleados e2)";
            Query query = session.createQuery(hql);

            ret = (Empleados) query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return ret;
    }
}
