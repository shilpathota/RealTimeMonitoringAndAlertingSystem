package com.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.mock.component.MockEndPoints;

@SpringBootApplication
@ComponentScan({"com.monitor"})
@EnableScheduling
public class MonitoringServiceApplication {

	public static void main(String[] args) {
		System.out.println("Application Started");
		SpringApplication.run(MonitoringServiceApplication.class, args);
	}
	@Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {

	        WireMockServer server = new WireMockServer(8088);
	        return server;
	    }
    @Bean
    public MockEndPoints mockendPoints(WireMockServer wireMockServer) {
        return new MockEndPoints(wireMockServer);
    }
}
