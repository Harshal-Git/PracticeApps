/**
 * 
 */
package com.user.services;

import org.springframework.stereotype.Service;

import com.user.entity.User;

/**
 * @author hcharadava
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(long userID) {
		return DummyUserService.usersList.stream().
					filter(user -> user.getUserID().equals(userID)).
					findAny().
					orElse(null);
	}
	
	
}
