package org.springboot.batch01.service;

import java.util.Collection;

import org.springboot.batch01.model.BatchJob;

public interface BatchJobService 
{

	Collection<BatchJob> findAll();
	
	Collection<BatchJob> scheduleAll();
	
//	User findOne(Long id);
	
//	User create(User user);	
	
}
