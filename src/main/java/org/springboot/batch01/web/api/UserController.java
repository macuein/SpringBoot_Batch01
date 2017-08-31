package org.springboot.batch01.web.api;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.model.User;
import org.springboot.batch01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(
			value="/api/users",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getUsers()
	{
		logger.debug("Rest getUsers start ... ");
		Collection<User> users = userService.findAll(); 
		logger.debug("Rest getUsers end ... ");
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}	

	
}
