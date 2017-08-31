package org.springboot.batch01.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisallowConcurrentExecution
public class JobTwo implements Job
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException 
	{
		try
		{
			JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
			JobKey jobKey = ctx.getJobDetail().getKey();
			logger.debug("SchedulerName: {}, JobKey: {}, DataMap: {}", ctx.getScheduler().getMetaData(), jobKey, dataMap);
		}
		catch(Exception ex)
		{
			logger.error("Error: {}", ex);
		}
		
	}
	
	
	
}
