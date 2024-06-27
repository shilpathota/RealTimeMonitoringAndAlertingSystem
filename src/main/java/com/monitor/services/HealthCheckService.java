package com.monitor.services;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.monitor.objects.ServiceInfo;

@Service
public class HealthCheckService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckService.class);

    @Value("${paymentService.healthCheckUrl}")
    private String paymentServiceHealthCheckUrl;
    
    @Value("${paymentService.healthCheckDownUrl}")
    private String paymentServiceHealthCheckDownUrl;

    @Value("${databaseService.healthCheckUrl}")
    private String databaseServiceHealthCheckUrl;

    @Value("${healthCheck.timeout}")
    private int healthCheckTimeout;
    
	@Autowired
	ServiceRegistryService serviceRegistryService;
    
	@Value("${mock.baseurl}")
    private String mockBaseUrl;
	
    @Autowired
    private RestTemplate restTemplate;

//    public void checkPaymentServiceHealth() {
//        checkHealth("Payment Service", paymentServiceHealthCheckUrl);
//    }
////    public void checkPaymentServiceHealthDown() {
////        checkHealth("Payment Service", paymentServiceHealthCheckDownUrl);
////    }
//
//    public void checkDatabaseServiceHealth() {
//        checkHealth("Database Service", databaseServiceHealthCheckUrl);
//    }

    public void checkHealth() {
    	String healthCheckURL="";
    	//get the service details
    	Map<String, ServiceInfo> services = serviceRegistryService.getAllRegisteredServices();
    	for(Entry<String,ServiceInfo> serviceEntry:services.entrySet()) {
    		String serviceName=serviceEntry.getValue().getName();
    		if(serviceName=="Payment Service") {
    			healthCheckURL=paymentServiceHealthCheckUrl;
    			
    		}else if(serviceName=="Database Service") {
    			healthCheckURL=databaseServiceHealthCheckUrl;
    			
    		}
    	
        try {
            String healthStatus = restTemplate.getForObject(healthCheckURL, String.class);
            LOGGER.info(healthStatus);
        } catch (Exception e) {
            LOGGER.error("Error checking {} health: {}", serviceName, e.getMessage());
        }
    	}
    }
}
