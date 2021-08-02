/**
 * 
 */
package com.test.demo.services;

/**
 * @author Harshal
 *
 */
public class TwitterService implements MessageService {

	public TwitterService() {
		System.out.println("TwitterService constructor called.");
	}
	
	/**
	 * 
	 */
	public boolean sendMessage(String messageContent, String recipientAddress) {
		System.out.println("Twitter message: "+messageContent+" is sent to: "+recipientAddress);
		return true;
	}
}
