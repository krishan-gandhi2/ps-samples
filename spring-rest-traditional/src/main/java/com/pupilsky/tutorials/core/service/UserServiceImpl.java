/**
 * 
 */
package com.pupilsky.tutorials.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupilsky.tutorials.core.dao.UserRepositories;
import com.pupilsky.tutorials.core.entity.EUser;
import com.pupilsky.tutorials.core.model.User;

/**
 * @author krishan.gandhi
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositories userRepositories;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pupilsky.tutorials.core.service.UserService#createUser(com.pupilsky.
	 * tutorials.core.model.User)
	 */
	@Override
	public User createUser(User user) {
		EUser eUser = new EUser();
		BeanUtils.copyProperties(user, eUser);
		eUser = userRepositories.save(eUser);
		BeanUtils.copyProperties(eUser, user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pupilsky.tutorials.core.service.UserService#updateUser(com.pupilsky.
	 * tutorials.core.model.User)
	 */
	@Override
	public User updateUser(User user) {
		EUser eUser = new EUser();
		BeanUtils.copyProperties(user, eUser);
		eUser = userRepositories.save(eUser);
		BeanUtils.copyProperties(eUser, user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pupilsky.tutorials.core.service.UserService#fetchUserById(java.lang.
	 * Integer)
	 */
	@Override
	public User fetchUserById(Integer userId) {
		User user = new User();
		EUser eUser =userRepositories.findOne(userId);
		BeanUtils.copyProperties(eUser, user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pupilsky.tutorials.core.service.UserService#deleteUser(java.lang.
	 * Integer)
	 */
	@Override
	public void deleteUser(Integer userId) {
		userRepositories.delete(userId);
	}

}
