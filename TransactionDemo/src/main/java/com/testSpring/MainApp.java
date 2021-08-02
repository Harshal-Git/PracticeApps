/**
 * 
 */
package com.testSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hcharadava
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "Beans.xml";
		
		// get application context from an XML file 
		ApplicationContext context = new ClassPathXmlApplicationContext(fileName);
		Message msgObj = (Message) context.getBean("message");
		// close the resource
		((ClassPathXmlApplicationContext)context).close();

		// print data from bean
		System.out.println("Message from Bean: "+msgObj.getMessage());
	}
}
