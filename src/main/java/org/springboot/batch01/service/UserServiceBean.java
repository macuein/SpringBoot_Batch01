package org.springboot.batch01.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.model.User;
import org.springboot.batch01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
		propagation=Propagation.SUPPORTS, 
		readOnly=true)
public class UserServiceBean implements UserService 
{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;	
	
	@Override
	public Collection<User> findAll() 
	{
		Collection<User> users = userRepository.findAll();
		return users;
	}
	

}
