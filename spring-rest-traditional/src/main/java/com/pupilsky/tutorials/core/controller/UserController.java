package com.pupilsky.tutorials.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pupilsky.tutorials.core.model.User;
import com.pupilsky.tutorials.core.service.UserService;

@RestController
@RequestMapping("/admin/sample")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
    	User user=userService.fetchUserById(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId,@RequestBody User model) {
    	model.setId(userId);
    	User user=userService.updateUser(model);
    	return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) {
    	userService.deleteUser(userId);
    	return new ResponseEntity<User>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    	user=userService.createUser(user);
    	return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}
