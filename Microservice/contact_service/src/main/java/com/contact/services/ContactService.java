/**
 * 
 */
package com.contact.services;

import java.util.List;

import com.contact.entity.Contact;

/**
 * @author hcharadava
 *
 */
public interface ContactService {

	public List<Contact> getContactsForUser(long userID);
}
