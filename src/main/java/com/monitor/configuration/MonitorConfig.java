package com.monitor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.mock.component.MockEndPoints;
import com.monitor.services.DataCollectionService;
import com.monitor.services.HealthCheckService;
import com.monitor.services.SchedulerService;
import com.monitor.services.ServiceRegistryService;

@Configuration
public class MonitorConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}