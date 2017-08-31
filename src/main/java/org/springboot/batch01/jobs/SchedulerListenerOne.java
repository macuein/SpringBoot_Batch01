package org.springboot.batch01.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Trigger;
import org.quartz.listeners.SchedulerListenerSupport;

public class SchedulerListenerOne extends SchedulerListenerSupport 
{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private String name;

	public SchedulerListenerOne(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	
	@Override
	public void schedulerStarted() 
	{
		logger.debug("schedulerStarted");
	}

	@Override
	public void schedulerShutdown() 
	{
		logger.debug("schedulerShutdown");
	}

	@Override
	public void jobScheduled(Trigger trigger) 
	{
		logger.debug("jobScheduled");
	}

}