package org.springboot.batch01.repository;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.mappers.UserRowMapper;
import org.springboot.batch01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository 
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	public Collection<User> findAll() 
	{
	   	Collection<User> userList;

	   	userList = jdbcTemplate.query("select id, firstname, lastname, email from users;", new UserRowMapper());
    	logger.debug("userList: {}", userList.toString());
        
    	return userList;
	}
	

/*	
 	public User findOne(Long id) 
	{
		return null;
	}
*/
	
/*
	public User create(User user) 
	{
		return null;
	}
*/	

}
