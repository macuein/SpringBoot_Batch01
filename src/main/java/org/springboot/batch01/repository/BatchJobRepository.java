package org.springboot.batch01.repository;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.mappers.BatchJobRowMapper;
import org.springboot.batch01.model.BatchJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BatchJobRepository 
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	public Collection<BatchJob> findAll() 
	{
	   	Collection<BatchJob> batchJobList;

	   	batchJobList = jdbcTemplate.query("select id, jobname, jobclass, jobcron from batchjobs;", new BatchJobRowMapper());
    	logger.debug("batchJobList: {}", batchJobList.toString());
        
    	return batchJobList;
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
