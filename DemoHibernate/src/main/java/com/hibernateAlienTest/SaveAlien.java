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
public class SaveAlien {

	public static void main(String[] args) {

		AlienName aName = new AlienName();
		aName.setFirst_name("Baby");
		aName.setLast_name("Yoda");
		
		Alien al = new Alien();
		al.setAlien_id(103);
		al.setAlien_name(aName);
		al.setColor("Green");
		al.setOrigin("UF##1221");

		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(al);
		transaction.commit();
		session.close();
	}
}
