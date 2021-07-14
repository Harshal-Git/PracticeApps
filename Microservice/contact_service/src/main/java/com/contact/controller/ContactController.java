/**
 * 
 */
package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.services.ContactService;

/**
 * @author hcharadava
 *
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService service;

	@GetMapping("/user/{userID}")
	public List<Contact> getContactsForUser(@PathVariable("userID") long userID) {
		return this.service.getContactsForUser(userID);
	}
}
