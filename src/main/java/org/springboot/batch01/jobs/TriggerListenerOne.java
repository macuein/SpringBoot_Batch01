package org.springboot.batch01.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.quartz.Trigger.CompletedExecutionInstruction;

public class TriggerListenerOne implements TriggerListener 
{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private String name;

	public TriggerListenerOne(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}

	public void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode) 
	{
		logger.debug("triggerComplete");
	}

	public void triggerFired(Trigger trigger, JobExecutionContext context) 
	{
		logger.debug("triggerFired");
	}

	public void triggerMisfired(Trigger trigger) 
	{
		logger.debug("triggerMisfired");
	}

	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) 
	{
		logger.debug("vetoJobExecution");
		return false;
	}

}
