package org.springboot.batch01.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

//@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobOne extends QuartzJobBean 
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String COUNT = "count";

	private String name;
     
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException 
	{

		try
		{
			JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
			int cnt = dataMap.getInt(COUNT);
			JobKey jobKey = ctx.getJobDetail().getKey();
			logger.debug("SchedulerName: {}, JobKey: {}, JobName: {}, count: {}", ctx.getScheduler().getMetaData(), jobKey, name, cnt);
			cnt++;
			dataMap.put(COUNT, cnt);
		}
		catch(Exception ex)
		{
			logger.error("Error: {}", ex);
		}

	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
} 
