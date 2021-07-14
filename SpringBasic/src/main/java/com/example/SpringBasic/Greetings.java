/**
 * 
 */
package com.example.SpringBasic;

/**
 * @author Harshal-Git
 *
 */
public class Greetings {

	private final int id;
	
	private final String message;
	
	/**
	 * 
	 * @param l
	 * @param message
	 */
	public Greetings(long count, String message) {
		this.id = (int) count;
		this.message = message;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
}
