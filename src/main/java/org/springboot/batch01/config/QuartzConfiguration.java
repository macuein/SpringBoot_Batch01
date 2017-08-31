package org.springboot.batch01.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.jobs.JobListenerOne;
import org.springboot.batch01.jobs.JobOne;
import org.springboot.batch01.jobs.SchedulerListenerOne;
import org.springboot.batch01.jobs.TriggerListenerOne;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@ConditionalOnProperty(name = "quartz.enabled")
public class QuartzConfiguration
{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${quartz.propfile}")
	String quartzPropFile;
	
	@Bean
	public Properties quartzProperties() throws IOException
	{
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource(quartzPropFile));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean()
	{
		try
		{
			SchedulerFactoryBean schedulerFB = new SchedulerFactoryBean();
			logger.debug("schedulerFactoryBean - setting quartz properties");
			schedulerFB.setQuartzProperties(quartzProperties());
			
			SchedulerListenerOne schedListOne = new SchedulerListenerOne("GlobalSchedulerListener01");
			schedulerFB.setSchedulerListeners(schedListOne);
			TriggerListenerOne triggListOne = new TriggerListenerOne("GlobalTriggerListener01");
			schedulerFB.setGlobalTriggerListeners(triggListOne);
			JobListenerOne jobListOne = new JobListenerOne("GlobalJobListener01");
			schedulerFB.setGlobalJobListeners(jobListOne);
		
			//schedulerFB.setGlobalJobListeners(globalJobListeners);
			//schedulerFB.setTriggers(cronTriggerFactoryBean().getObject());
			return schedulerFB;
		}
		catch(Exception ex)
		{
			logger.error("ERROR schedulerFactoryBean: {}", ex);
			return null;
		}
	}

	
/*	
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean()
	{
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(JobOne.class);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "JobOne");
		map.put(JobOne.COUNT, 1);
		factory.setJobDataAsMap(map);
		factory.setGroup("mygroup");
		factory.setName("myjob");
		return factory;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean()
	{
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(jobDetailFactoryBean().getObject());
		stFactory.setStartDelay(1000);
		stFactory.setName("mytrigger");
		stFactory.setGroup("mygroup");
		stFactory.setCronExpression("0/30 * * * * ?");
		return stFactory;
	}		
*/	
}
