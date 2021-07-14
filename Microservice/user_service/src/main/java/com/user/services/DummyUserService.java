/**
 * 
 */
package com.user.services;

import java.util.List;

import com.user.entity.User;

/**
 * @author hcharadava
 *
 */
public class DummyUserService {

	public static List<User> usersList = List.of(new User(11L, "User1", "99999999"),
												new User(12L, "User2", "8888888"), 
												new User(13L, "User3", "44444"));
	
}
