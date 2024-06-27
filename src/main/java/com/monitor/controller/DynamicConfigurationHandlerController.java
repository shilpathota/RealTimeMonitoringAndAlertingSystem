package com.monitor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.objects.ServiceInfo;
import com.monitor.services.ServiceRegistryService;

@RestController
public class DynamicConfigurationHandlerController {
	
	@Autowired
	ServiceRegistryService serviceRegistryService;
	
    @PostMapping("/register/{serviceName}")
    public String registerService(@PathVariable String serviceName) {
        // Register the service
    	serviceRegistryService.registerService(serviceName);
        return "Service " + serviceName + " registered successfully.";
    }

    @DeleteMapping("/deregister/{serviceName}")
    public String deregisterService(@PathVariable String serviceName) {
        // Deregister the service
    	serviceRegistryService.deregisterService(serviceName);
        return "Service " + serviceName + " deregistered successfully.";
    }

    @GetMapping("/registered-services")
    public Map<String, ServiceInfo> getRegisteredServices() {
    	Map<String, ServiceInfo> services = serviceRegistryService.getAllRegisteredServices();
        return services;
    }
}
