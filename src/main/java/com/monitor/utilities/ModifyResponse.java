package com.monitor.utilities;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.monitor.objects.Metrics;


public class ModifyResponse {
	
	@Autowired
	static DataSensitivityCheck dataCheck;
	
	public static void modifyData(String metricsstring) {
		 // Create a JSON object to hold both the metrics
        JsonObject modifiedResponse = new JsonObject();
        ObjectMapper objectMapper = new ObjectMapper();
        Metrics metrics=null;
		try {
			metrics = objectMapper.readValue(metricsstring, Metrics.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        // Add metrics data to the JSON object
        modifiedResponse.addProperty("serviceName", metrics.getServiceName());
        modifiedResponse.addProperty("timestamp", metrics.getTimestamp());
        modifiedResponse.addProperty("status", metrics.getStatus());
        modifiedResponse.addProperty("responseTime", metrics.getResponseTime());
        modifiedResponse.addProperty("heartbeat", metrics.getHeartbeat());
        modifiedResponse.addProperty("requestRate", metrics.getRequestRate());
        modifiedResponse.addProperty("cpuUtilization", metrics.getCpuUtilization());

        String modifiedData = modifiedResponse.toString();

        dataCheck.MaskData(modifiedData);
		
	}
}
