package com.monitor.objects;

public class Metrics {
    private String serviceName;
    private String timestamp;
    private String status;
    private double responseTime;
    private int heartbeat;
    private int requestRate;
    private double cpuUtilization;
    
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}
	public int getHeartbeat() {
		return heartbeat;
	}
	public void setHeartbeat(int heartbeat) {
		this.heartbeat = heartbeat;
	}
	public int getRequestRate() {
		return requestRate;
	}
	public void setRequestRate(int requestRate) {
		this.requestRate = requestRate;
	}
	public double getCpuUtilization() {
		return cpuUtilization;
	}
	public void setCpuUtilization(double cpuUtilization) {
		this.cpuUtilization = cpuUtilization;
	}
    
    
}
