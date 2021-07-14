/**
 * 
 */
package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.services.UserService;

/**
 * @author hcharadava
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping("/{userID}")
	public User getUser(@PathVariable("userID") long userID) {

		// retrieve user 
		User userObj = this.service.getUser(userID);
		/*
		 * using the URL below; contact details associated with particular user can be accessed.
		 * 
		 * http://localhost:8092/contact/user/11
		 * 
		 * So this association will be done with the help of RestTemplate.
		 */
		String requestURL = "http://contact-service/contact/user/";
		String id = null;
		List<Contact> contactList = null;

		if(userObj != null) {
			id = userObj.getUserID().toString();
		} else {
			// empty contact list
			contactList = new ArrayList<>(); 
		}
		// access object from different service
		System.out.println("accessed URL: "+(requestURL+id));
		contactList = ((List<Contact>) this.restTemplate.getForObject(requestURL+id, List.class));
		userObj.setContacts(contactList);
		return userObj;
	}
}
