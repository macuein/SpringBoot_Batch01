package org.springboot.batch01.web.api;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.batch01.model.BatchJob;
import org.springboot.batch01.model.User;
import org.springboot.batch01.service.BatchJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchJobController 
{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BatchJobService batchJobService;

	@RequestMapping(
			value="/api/batchjobs",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<BatchJob>> getBatchJobs()
	{
		logger.debug("Rest getBatchJobs start ... ");
		Collection<BatchJob> batchJobs = batchJobService.findAll(); 
		logger.debug("Rest getBatchJobs end ... ");
		return new ResponseEntity<Collection<BatchJob>>(batchJobs, HttpStatus.OK);
	}		

	@RequestMapping(
			value="/api/schedbatchjobs",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<BatchJob>> schedBatchJobs()
	{
		logger.debug("Rest schedBatchJobs start ... ");
		Collection<BatchJob> batchJobs = batchJobService.scheduleAll();
		logger.debug("Rest schedBatchJobs end ... ");
		return new ResponseEntity<Collection<BatchJob>>(batchJobs, HttpStatus.OK);
	}	
	
}
