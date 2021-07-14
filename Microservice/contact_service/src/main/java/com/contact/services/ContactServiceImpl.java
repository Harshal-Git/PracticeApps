/**
 * 
 */
package com.contact.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

/**
 * @author hcharadava
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Override
	public List<Contact> getContactsForUser(long userID) {
		return DummyContactService.contacts.stream().filter(contact -> contact.getUserID().equals(userID)).
				collect(Collectors.toList());
	}

}
