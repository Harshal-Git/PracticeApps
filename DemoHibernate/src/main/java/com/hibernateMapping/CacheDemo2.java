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
 *	-> Different session : executing same query twice : will result in invoking different cache for both sessions.
 *
 *	-> How to verify it: the same request will execute twice for a new session.
 *
 *	-> If second level cache is activated in hibernate.cfg.xml, then second request will be processed by cache.
 */
public class CacheDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// get student reference
		Student st1 = null;

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

		// complete the session
		s1.getTransaction().commit();
		s1.close();

		// create session 2
		Session s2 = sf.openSession();
		s2.beginTransaction();

		// get same student again (it will not execute the query again)
		// this is first level caching; within same session
		st1 = (Student) s2.get(Student.class, 1001);
		System.out.println("Student: "+st1.toString());

		// complete the session
		s2.getTransaction().commit();
		s2.close();		
		sf.close();
	}
}
