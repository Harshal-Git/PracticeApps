/**
 * 
 */
package com.hibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Harshal
 *
 */
public class GetApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class).
				addAnnotatedClass(Student.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Student st = (Student) session.get(Student.class, 1001);
		System.out.println("Student: "+st.toString());
		System.out.println("Students laptop: "+st.getLaptops().toString());
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
