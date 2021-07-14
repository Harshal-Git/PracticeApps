/**
 * 
 */
package com.contact.entity;

/**
 * @author hcharadava
 *
 */
public class Contact {

	private Long contactID;
	private String contactMail;
	private String contactName;
	private Long userID;	// mapping with User

	/**
	 * @param contactID
	 * @param contactMail
	 * @param contactName
	 * @param userID
	 */
	public Contact(Long contactID, String contactMail, String contactName, Long userID) {
		setContactID(contactID);
		setContactMail(contactMail);
		setContactName(contactName);
		setUserID(userID);
	}

	/**
	 * 
	 */
	public Contact() {
	}

	/**
	 * @return the contactID
	 */
	public Long getContactID() {
		return contactID;
	}

	/**
	 * @param contactID the contactID to set
	 */
	public void setContactID(Long contactID) {
		this.contactID = contactID;
	}

	/**
	 * @return the contactMail
	 */
	public String getContactMail() {
		return contactMail;
	}

	/**
	 * @param contactMail the contactMail to set
	 */
	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
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

}
