/**
 * 
 */
package com.test.demo.services;

/**
 * @author Harshal
 *
 */
public class EMailService implements MessageService {

	public EMailService() {
		System.out.println("EMailService constructor called.");
	}
		
	/**
	 * 
	 */
	public boolean sendMessage(String messageContent, String recipientAddress) {
		System.out.println("Email: "+messageContent+" is sent to: "+recipientAddress);
		return true;
	}
}
