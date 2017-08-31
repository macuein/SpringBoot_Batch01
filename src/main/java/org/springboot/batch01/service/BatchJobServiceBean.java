package org.springboot.batch01.service;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Collection;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.config.QuartzConfiguration;
import org.springboot.batch01.model.BatchJob;
import org.springboot.batch01.repository.BatchJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.quartz.CronTrigger;


@Service
@Transactional(
		propagation=Propagation.SUPPORTS, 
		readOnly=true)
public class BatchJobServiceBean implements BatchJobService 
{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BatchJobRepository batchJobRepository;	
	
    @Autowired
    private QuartzConfiguration quartzConfig; 
	
	@Override
	public Collection<BatchJob> findAll() 
	{
		Collection<BatchJob> batchJobs = batchJobRepository.findAll();
		return batchJobs;
	}
	
	public Collection<BatchJob> scheduleAll() 
	{
		
		try
		{
			Collection<BatchJob> batchJobs = batchJobRepository.findAll();
			
			
			SchedulerFactoryBean sf = quartzConfig.schedulerFactoryBean(); //new SchedulerFactoryBean();
			Scheduler sched = sf.getScheduler();
			if (sched==null)
			{
				logger.error("Scheduler is null");
			}
			
			for(BatchJob batchJob : batchJobs)
			{
				Class jobClass = Class.forName(batchJob.getJobClass());
				JobDetail job = newJob(jobClass)
					    				.withIdentity("JOB_" + batchJob.getJobName(), "GROUP_" + batchJob.getJobName())
					    				.build();

				CronTrigger trigger = newTrigger()
					    				.withIdentity("TRIGGER_" + batchJob.getJobName(), "GROUP_" + batchJob.getJobName())
					    				.withSchedule(cronSchedule(batchJob.getJobCron()))
					    				.build();

				sched.scheduleJob(job, trigger);
			}
			
			return batchJobs;
			
		}
		catch(Exception ex)
		{
			logger.error("ERROR: {}", ex.toString(), ex);
			return null;
		}
	}

}
