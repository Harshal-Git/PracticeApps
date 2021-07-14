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
public class DummyContactService {

	public static List<Contact> contacts = List.of(new Contact(101L, "abc@gmail.com", "ABC", 11L), 
											new Contact(102L, "zzz@gmail.com", "XZZ", 11L),
											new Contact(103L, "abc@gmail.com", "AAA", 12L),
											new Contact(104L, "ddd@gmail.com", "DDD", 13L));
	
}
