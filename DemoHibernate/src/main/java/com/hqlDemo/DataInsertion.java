/**
 * 
 */
package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Harshal
 *
 */
public class DataInsertion {

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
		
		// insert data
		Student st = null;
		for(int i = 1; i <= 10; i++) {
			st = new Student();
			st.setStudent_id(i+100);
			st.setMarks((int)(Math.random()*100));
			st.setStudent_name("Name-"+i);
			session.save(st);
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
