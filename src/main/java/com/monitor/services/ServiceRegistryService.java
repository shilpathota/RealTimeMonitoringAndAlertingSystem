package com.monitor.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.monitor.objects.ServiceInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ServiceRegistryService {

    private Map<String, ServiceInfo> registeredServices = new ConcurrentHashMap<>();
    @Value("${server.port}")
    private String port;
    
    public void registerService(String serviceName) {
        ServiceInfo serviceInfo = new ServiceInfo(serviceName, "localhost", 8088);
        registeredServices.put(serviceName, serviceInfo);
    }

    public void deregisterService(String serviceName) {
        registeredServices.remove(serviceName);
    }

    public ServiceInfo getServiceInfo(String serviceName) {
        return registeredServices.get(serviceName);
    }

    public Map<String, ServiceInfo> getAllRegisteredServices() {
        return registeredServices;
    }

}


