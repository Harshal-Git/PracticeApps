/**
 * 
 */
package com.hqlDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Harshal
 *
 */
public class RetrieveData2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();

		// create session & transaction 
		session.beginTransaction();

		Query q1 = session.createQuery("select student_id, student_name, marks from Student where student_id = 110");

		Object[] stData = (Object[]) q1.uniqueResult();

		System.out.println(stData[0]+" : "+stData[1]+" : "+stData[2]);

		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
