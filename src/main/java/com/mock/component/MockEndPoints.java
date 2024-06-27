package com.mock.component;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.monitor.services.ServiceRegistryService;

@Component
public class MockEndPoints implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.mock.component.MockEndpoints");

	@Autowired
    private ServiceRegistryService serviceRegistry;
	
	private final WireMockServer wireMockServer;
	
    public MockEndPoints(WireMockServer wireMockServer) {
        this.wireMockServer = wireMockServer;
    }
	
    public void setupMockEndPoints() {
    	
    	//check if the server instance is null
	    if (wireMockServer == null) {
	        LOGGER.error("WireMockServer bean is null");
	    }else {
	    	WireMock.configureFor("localhost", wireMockServer.port());
        LOGGER.info("port:"+wireMockServer.port());
        
        //registering the services
        serviceRegistry.registerService("paymentService");
        serviceRegistry.registerService("databaseService");
        
        //HealthCheck configuration
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/paymentService/health"))
        	    .willReturn(WireMock.aResponse()
        	        .withStatus(200)
        	        .withBody("{\"logtype\":\"health\",\"service\":\"Payment Service\",\"status\":\"UP\"}")));
        
        	LOGGER.info("Payment Service Called");

        	WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/databaseService/health"))
        	    .willReturn(WireMock.aResponse()
        	        .withStatus(200)
        	        .withBody("{\"logtype\":\"health\",\"service\":\"Database Service\",\"status\":\"UP\"}")));

        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String currentTimestamp = dateFormat.format(new Date());
        	
        	// Metrics configuration
        	WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/paymentService/metrics"))
        	    .willReturn(WireMock.aResponse()
        	        .withStatus(200)
        	        .withBody("{\"logtype\":\"metrics\",\"serviceName\":\"paymentService\",\"timestamp\":\"" + currentTimestamp + "\","
        	            + "\"status\":\"UP\","
        	            + "\"responseTime\":\"1000.0\","
        	            + "\"heartbeat\":\"2\","
        	            + "\"requestRate\":\"10\","
        	            + "\"cpuUtilization\":\"30\"}")));

        	WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/databaseService/metrics"))
        	    .willReturn(WireMock.aResponse()
        	        .withStatus(200)
        	        .withBody("{\"logtype\":\"metrics\",\"serviceName\":\"databaseService\",\"timestamp\":\"" + currentTimestamp + "\","
        	            + "\"status\":\"UP\","
        	            + "\"responseTime\":\"1000.0\","
        	            + "\"heartbeat\":\"2\","
        	            + "\"requestRate\":\"10\","
        	            + "\"cpuUtilization\":\"30\"}")));
        	
        	//To test downtime scenario
            WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/paymentService/healthdown"))
            	    .willReturn(WireMock.aResponse()
            	        .withStatus(200)
            	        .withBody("{\"logtype\":\"health\",\"service\":\"Payment Service\",\"status\":\"DOWN\"}")));
    }
	}
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Check if the event was triggered by the ApplicationContext being fully initialized
        if (event.getApplicationContext().getParent() == null) {
            // Ensure that setupMockEndpoints is called after the WireMockServer is started
            if (wireMockServer.isRunning()) {
            	setupMockEndPoints();
            }
        }
    }
}
