package com.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.services.DataCollectionService;

@RestController
@RequestMapping("/dataCollection")
public class DataCollectionController {
	
	@Autowired
	DataCollectionService datacollectionService;
	
    @GetMapping("/collect-data")
    public String collectData() {
        
    	datacollectionService.collectData();
        return "Data collected and logged to Logstash";
    }
}
