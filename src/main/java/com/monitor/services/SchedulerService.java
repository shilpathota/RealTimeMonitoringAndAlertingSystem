package com.monitor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
	
	@Autowired
	public HealthCheckService healthCheckService;
	
	@Autowired
	public DataCollectionService dataCollectionService;
	
	@Scheduled(fixedRate = 300000) // 300,000 milliseconds = 5 minutes
    public void initiateHealthCheck() {
		healthCheckService.checkHealth();
		
	}
	
	@Scheduled(fixedRate = 300000) // 300,000 milliseconds = 5 minutes
    public void initiateMetricsCheck() {
		dataCollectionService.collectData();		
	}
}
