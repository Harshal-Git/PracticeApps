/**
 * 
 */
package com.user.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hcharadava
 *
 */
public class User {

	private Long userID;
	private String name;
	private String phoneNumber;
	private List<Contact> contacts;
	
	/**
	 * @param userID
	 * @param name
	 * @param phoneNumber
	 * @param contacts
	 */
	public User(Long userID, String name, String phoneNumber, List<Contact> contacts) {
		super();
		setUserID(userID);
		setName(name);
		setPhoneNumber(phoneNumber);
		setContacts(contacts);
	}

	/**
	 * @param userID
	 * @param name
	 * @param phoneNumber
	 */
	public User(Long userID, String name, String phoneNumber) {
		super();
		setUserID(userID);
		setName(name);
		setPhoneNumber(phoneNumber);
		setContacts(new ArrayList<Contact>());
	}

	/**
	 * 
	 */
	public User() {
		super();
		this.contacts = new ArrayList<>();
	}

	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
