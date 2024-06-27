package com.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.services.HealthCheckService;

@RestController
@RequestMapping("/healthcheck")
public class HealthcheckController {
	@Autowired
	private HealthCheckService healthCheckService;
	
	@GetMapping("/paymentHealth")
    public String checkPaymentServiceHealth() {
        healthCheckService.checkHealth();
        return "Payment Service Health Check Triggered";
    }
    @GetMapping("/databaseHealth")
    public String checkDatabaseServiceHealth() {
        healthCheckService.checkHealth();
        return "Database Service Health Check Triggered";
    }
    
//    //Exposed To test the downtime scenario
//	@GetMapping("/paymentHealthdown")
//    public String checkPaymentServiceHealthDown() {
//        healthCheckService.checkPaymentServiceHealthDown();
//        return "Payment Service Health Check Down Triggered";
//    }
}
