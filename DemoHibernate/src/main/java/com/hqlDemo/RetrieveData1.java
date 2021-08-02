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
public class RetrieveData1 {

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

		Query q1 = session.createQuery("from Student where marks > 50");
		@SuppressWarnings("unchecked")
		List<Student> stList = q1.list();
		
		for(Student st : stList) {
			System.out.println(st.toString());
		}
		
		
		Query q2 = session.createQuery("from Student where student_id=110");
		Student stObj = (Student) q2.uniqueResult();
		System.out.println("Student with ID = 110 => "+stObj.toString());
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
