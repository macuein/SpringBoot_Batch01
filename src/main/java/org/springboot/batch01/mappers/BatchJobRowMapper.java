package org.springboot.batch01.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.model.BatchJob;
import org.springframework.jdbc.core.RowMapper;

public class BatchJobRowMapper  implements RowMapper<BatchJob>
{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
    public BatchJob mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		BatchJob batchJob = new BatchJob();

		batchJob.setId(rs.getInt("id"));
		batchJob.setJobName(rs.getString("jobname"));
		batchJob.setJobClass(rs.getString("jobclass"));
		batchJob.setJobCron(rs.getString("jobcron"));

        logger.debug("batchjob information: id:{}, JobName:{}, JobClass:{}, JobCron:{}", batchJob.getId(), batchJob.getJobName(), batchJob.getJobClass(), batchJob.getJobCron());
        
        return batchJob;
    }
	
	
}
