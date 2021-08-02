/**
 * 
 */
package com.hibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Harshal
 *
 *	-> Same session : executing same query twice : will result in invoking cache.
 *	
 *	-> How to verify it: the same request will not execute a new query. 
 */
public class CacheDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// get student reference
		Student st1 = null;
		Student st2 = null;

		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class).
				addAnnotatedClass(Student.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);

		// create session 1
		Session s1 = sf.openSession();
		s1.beginTransaction();

		// get student 1
		st1 = (Student) s1.get(Student.class, 1001);
		System.out.println("Student: "+st1.toString());

		// get same student again (it will not execute the query again)
		// this is first level caching; within same session
		st2 = (Student) s1.get(Student.class, 1001);
		System.out.println("Student: "+st2.toString());

		// complete the session 
		s1.getTransaction().commit();
		s1.close();
		sf.close();
	}
}
