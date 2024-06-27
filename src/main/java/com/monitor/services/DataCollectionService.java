package com.monitor.services;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.monitor.objects.ServiceInfo;
import com.monitor.utilities.DataSensitivityCheck;
import com.monitor.utilities.ModifyResponse;

@Service
public class DataCollectionService {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.monitor.controller.DataCollectionService");

	@Autowired
	ServiceRegistryService serviceRegistryService;
    
	@Value("${mock.baseurl}")
    private String mockBaseUrl;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public void collectData() {
		//get the service details
    	Map<String, ServiceInfo> services = serviceRegistryService.getAllRegisteredServices();
    	for(Entry<String,ServiceInfo> serviceEntry:services.entrySet()) {
    		String serviceName=serviceEntry.getValue().getName();
    		 String metricsEndpoint = mockBaseUrl + "/" + serviceName + "/metrics";

             // Make HTTP request to mock endpoint
             ResponseEntity<String> responseEntity = makeRequest(metricsEndpoint);

             // Process the response as needed
             if (responseEntity.getStatusCode() == HttpStatus.OK) {
                 String metricsData = responseEntity.getBody();
                 // Process metricsData as needed
                 System.out.println(metricsData);
                 ModifyResponse.modifyData(metricsData);
             } else {
                 LOGGER.error("Failed to retrieve metrics data for service: {}", serviceName);
             }
    	}
    	
    	
	}
	private ResponseEntity<String> makeRequest(String url) {
        return restTemplate.getForEntity(url, String.class);
    }
	
}
