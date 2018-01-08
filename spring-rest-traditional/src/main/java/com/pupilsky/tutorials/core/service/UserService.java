/**
 * 
 */
package com.pupilsky.tutorials.core.service;

import com.pupilsky.tutorials.core.model.User;

/**
 * The Interface UserService.
 *
 * @author krishan.gandhi
 */
public interface UserService {

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User createUser(User user);
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User updateUser(User user);
	
	/**
	 * Fetch user by id.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	public User fetchUserById(Integer userId);
	
	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 */
	public void deleteUser(Integer userId);
}
