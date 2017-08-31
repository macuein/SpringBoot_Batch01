package org.springboot.batch01.service;

import java.util.Collection;

import org.springboot.batch01.model.User;

public interface UserService 
{
	Collection<User> findAll();
	
//	User findOne(Long id);
	
//	User create(User user);
	
}
