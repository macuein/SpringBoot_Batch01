package org.springboot.batch01.service;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springboot.batch01.AbstractTest;
import org.springboot.batch01.model.User;
import org.springboot.batch01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceTest extends AbstractTest
{

    @Autowired
    private UserService userService;

    @Test
    public void findAllUsersTest() 
    {
    	logger.debug("Test findAllUsers");
    	
        Collection<User> users = userService.findAll();

        Assert.assertNotNull("FAIL - users expected to be not null", users);
        Assert.assertTrue("FAIL - users expected to have more than 0 users", users.size() > 0);
    }
	
	
}
