package com.hibernateAlienTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 */
public class GetAlien {

	public static void main(String[] args) {

		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		int id = 103;
		
		Alien al = (Alien) session.get(Alien.class, id);
		
		transaction.commit();
		session.close();
		
		if(al != null) {
			System.out.println("Alien with ID: "+id+" => "+al.toString());
		} else {
			System.out.println("No alien exist with ID: "+id);
		}
	}
}
