package org.springboot.batch01.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class JobListenerOne implements JobListener 
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private String name;

	public JobListenerOne(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void jobToBeExecuted(JobExecutionContext context) 
	{
		logger.debug("jobToBeExecuted");
	}
	
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) 
	{
		logger.debug("jobWasExecuted");
	}
	
	public void jobExecutionVetoed(JobExecutionContext context) 
	{
		logger.debug("jobExecutionVetoed");
	}
}