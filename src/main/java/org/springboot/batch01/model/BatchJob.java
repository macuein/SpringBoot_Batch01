package org.springboot.batch01.model;

public class BatchJob 
{
	private Integer id;
    private String jobName;
    private String jobClass;
    private String jobCron;
    
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getJobName() 
	{
		return jobName;
	}
	public void setJobName(String jobName) 
	{
		this.jobName = jobName;
	}
	
	public String getJobClass() 
	{
		return jobClass;
	}
	public void setJobClass(String jobClass) 
	{
		this.jobClass = jobClass;
	}
	
	public String getJobCron() 
	{
		return jobCron;
	}
	public void setJobCron(String jobCron) 
	{
		this.jobCron = jobCron;
	}
    
}
