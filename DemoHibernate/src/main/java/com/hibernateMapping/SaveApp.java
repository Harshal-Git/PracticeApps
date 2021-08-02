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
public class SaveApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Laptop lp1= new Laptop();
		lp1.setLaptop_id(111);
		lp1.setName("Dell");
		
		Laptop lp2= new Laptop();
		lp2.setLaptop_id(122);
		lp2.setName("Macbook");
		
		Laptop lp3= new Laptop();
		lp3.setLaptop_id(121);
		lp3.setName("Lenovo");
		
		Student st1 = new Student();
		st1.setStudent_id(1001);
		st1.setStudent_name("Harshal");
		st1.setMarks(80);
		//st.setLaptop(lp);
		st1.getLaptops().add(lp1);
		st1.getLaptops().add(lp2);
		
		lp1.getStudents().add(st1);
		lp2.getStudents().add(st1);

		Student st2 = new Student();
		st2.setStudent_id(1002);
		st2.setStudent_name("Sonal");
		st2.setMarks(80);
		st2.getLaptops().add(lp3);
		lp3.getStudents().add(st2);
		
		
		// hibernate configuration with default file name needs not to be specified
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class).
				addAnnotatedClass(Student.class);

		ServiceRegistry reg = (ServiceRegistry) new ServiceRegistryBuilder().
				applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(lp1);
		session.save(lp2);
		session.save(st1);

		session.save(lp3);
		session.save(st2);
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
