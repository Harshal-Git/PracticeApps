/**
 * 
 */
package com.hibernateMapping;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Harshal
 *
 *	-> Second level Caching with query 
 *	
 *	-> How to verify it: the same request will execute twice for a new session.
 */
public class CacheDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// get student reference
		Student st1 = null;
		Query quObj = null;
		
		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class).
				addAnnotatedClass(Student.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);

		// create session 1
		Session s1 = sf.openSession();
		s1.beginTransaction();

		// get student via query (given entity class name)
		quObj = s1.createQuery(" FROM Student WHERE student_id=1001");
		quObj.setCacheable(true);
		
		st1 = (Student) quObj.uniqueResult();
		System.out.println("Student 1: "+st1.toString());

		// complete the session
		s1.getTransaction().commit();
		s1.close();

		// create session 2
		Session s2 = sf.openSession();
		s2.beginTransaction();

		// get student via query (given entity class name)
		quObj = s2.createQuery(" FROM Student WHERE student_id=1001");
		quObj.setCacheable(true);
		
		st1 = (Student) quObj.uniqueResult();
		System.out.println("Student 1: "+st1.toString());

		// complete the session
		s2.getTransaction().commit();
		s2.close();
		
		sf.close();
	}
}
