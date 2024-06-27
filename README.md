# RealTime Monitoring And Alerting System
This Project integrates with ELK stack which is Elastic search, Logstash and Kibana to collect the logs and visualize them
## Summary
The system's core functionalities encompass the seamless collection of metrics, modification of responses, and visualization through an intuitive dashboard. Administrators have the capability to configure alert rules based on service-specific criteria, enabling prompt intervention in scenarios such as prolonged response times, service heartbeats reaching zero, or excessive service requests. With a target of maintaining a 99% service availability, reducing average resolution times by 40%, and mitigating the financial impact of downtime incidents, the system promises significant business value.<br>
Addressing special issues and constraints, the project prioritizes the secure handling of sensitive monitoring data, continuous system operation with backup provisions, autoscaling to accommodate varying traffic, and the prevention of false alerts through real-time threshold settings. The proposed framework, endorsed by security, infrastructure, and core development teams, is positioned as a complementary offering to clients. It provides cost-effective and secure monitoring solutions using approved tools such as Filebeat, Elasticsearch, Logstash, and Kibana.<br>
The functional requirements of the system include a comprehensive Monitoring Service responsible for data collection, response modification, sensitive data handling, and dynamic configuration. An advanced alerting mechanism is implemented, triggering timely alerts based on specified rules related to response times, service heartbeats, request rates, and CPU utilization. A user-friendly dashboard is integrated to allow visualization of real-time data and historical performance metrics on Kibana Dashboard. Administrators are empowered to configure alert rules based on service-specific criteria, ensuring adaptability to evolving monitoring needs. Additionally, an automatic email trigger is implemented to notify the Point of Contact (POC) and the team responsible for each dashboard separately.<br>
The non-functional requirements encompass operational aspects, including a minimum system uptime of 99.99%, and performance requirements such as real-time monitoring latency and handling high data volumes. Security measures are stringent, covering access control, data encryption, and dashboard access control. Scalability requirements address the system's ability to accommodate a growing number of monitored services and support horizontal scaling. Logging and auditing are prioritized, ensuring secure storage and swift retrieval of logs for troubleshooting and auditing purposes.<br>
In conclusion, this project endeavors to enhance service reliability, reduce downtime, and contribute to the strategic allocation of resources within HXX Technologies. The combination of cutting-edge technology, rigorous security measures, and a comprehensive monitoring framework positions this initiative as a key asset for organizations navigating the challenges of the modern digital<br>

## Table Of Contents
1.	System Proposal
2.	Functional Requirements
3.	Non-Functional Requirements
4.	Use Case Diagram
5.	Activity Diagram
6.	Sequence Diagram
7.	Class Diagram
8.	Object Diagram
9.	Package Diagram
10.	Project Construction
11.	Output
12.	API Documentation
13.	Future Scope
14.	Conclusion
## System Proposal
### Business Need
In today's fast-paced digital landscape, ensuring the uninterrupted operation of critical services such as databases and payment systems is essential for businesses. Any downtime or performance degradation in these services can lead to financial losses, customer dissatisfaction, and reputation damage. To address this need, I propose the development of a real-time critical service monitoring and alerting system.
### Business Requirements
1.	The Database service and Payment service should be monitored 24/7.
2.	The system should be capable of sending timely alerts for the following scenarios:
      when the response time for the service exceeds 20sec.
      when the service heartbeat is zero.
      when the number of requests for the service exceeds 200/sec.
3.	Dashboard to visualize the performance of the services.
4.	Allow administrators to configure alert rules based on service-specific criteria.
### Business Value
1.	Ensures the Important Key Performance Indicator to maintain 99% which is ideal.
2.	Proactively alerts the respective team and reduces the average resolution time for Critical services by 40%.
3.	Significant decrease in downtime incidents impact the cost of downtime estimated $10,000 per hour for the critical services like Payment and Database services.
4.	Reduces the Manpower in support team by 80% who monitor the critical services and can dedicate the resources on other innovations.
### Special Issues or Constraints
1.	Ensure that sensitive monitoring data is securely stored and transmitted.
2.	The monitoring tool should run continuously on a server and backup be provided in case of failures.
3.	Autoscaling be configured in case of huge traffic is identified and integrated with the environment.
4.	The alerts threshold should be set for real time otherwise there are chances for false alerts

## Functional Requirements
### 1.	Monitoring Service
#### 1.1 Data Collection
•	Develop a common service responsible for collecting metrics from multiple services, including the Database service and Payment service (developed as mocks for the demo).
•	The common service will initiate requests to the mock services for health checks and access the actuator of the mock service for monitoring.
•	The logs are stored on to the Logstash which should be linked to Elastic Search and shows results using visualization tool which is Kibana in this case
#### 1.2 Response Modification
•	Modify responses received from mock services by adding a timestamp, service name, and the status of the service being monitored.
•	Transmit the modified responses to the Dashboard for visualization.
#### 1.3 Sensitive Data Handling
•	Implement a sensitive data check for logs received from mock services before forwarding them to the Elasticsearch using Filebeats. Sensitive data, if present, should be masked.
#### 1.4 Dynamic Configuration
•	Enable the addition of new services for monitoring by simply adding the service's link to a configuration file.
### 2.	Alerting Mechanism
The alerting mechanism will send timely alerts based on the following rules:
#### 2.1	Response Time Exceeds Threshold
#### 2.1.1	Metric: 
Response time for a service
#### 2.1.2	Threshold: 
Response time exceeding 20 seconds.
#### 2.1.3	Alert Severity: 
Critical
#### 2.1.4	Notification Recipients: 
POC and the respective dashboard team responsible for the service.
#### 2.1.5	Escalation Policy: 
Notify relevant team members every 5 minutes until acknowledged.
#### 2.1.6	Alert Suppression: 
Do not trigger this alert for the same service within 5 minutes if it has already been alerted.
### 2.2	Service Heartbeat Is Lost
#### 2.2.1	Metric: 
Service heartbeat
#### 2.2.2	Threshold: 
Service heartbeat equals zero.
#### 2.2.3	Alert Severity: 
Critical
#### 2.2.4	Notification Recipients: 
POC and the respective dashboard team responsible for the service.
#### 2.2.5	Escalation Policy: 
Notify relevant team members every 2 minutes until acknowledged.
#### 2.2.6	Alert Suppression: 
Do not trigger this alert for the same service within 2 minutes if it has already been alerted.
### 2.3	Request Rate Exceeds Threshold
#### 2.3.1	Metric: 
Number of requests for a service per second
#### 2.3.2	Threshold: 
Number of requests exceeding 200 per second.
#### 2.3.3	Alert Severity: 
Warning
#### 2.3.4	Notification Recipients: 
POC and the respective dashboard team responsible for the service.
#### 2.3.5	Escalation Policy: 
Notify relevant team members every 10 minutes until acknowledged.
#### 2.3.6	Alert Suppression: 
Do not trigger this alert for the same service within 10 minutes if it has already been alerted.
### 2.4	High CPU Utilization
#### 2.4.1	Metric: 
CPU Utilization
#### 2.4.2	Threshold: 
CPU utilization exceeding 60%.
#### 2.4.3	Alert Severity: 
Warning
#### 2.4.4	Notification Recipients: 
POC and the IT Operations team.
#### 2.4.5	Escalation Policy: 
Notify IT Operations team every 5 minutes until acknowledged.
#### 2.4.6	Alert Suppression: 
Do not trigger this alert for the same service within 5 minutes if it has already been alerted.
### 3.	Dashboard
The system should provide a user-friendly dashboard that allows users to visualize the performance of the monitored services. The dashboard should display real-time data and historical performance metrics on Kibana Dashboard
### 4.	Alert Rule Configuration to Admin
Administrators should be able to configure alert rules based on service-specific criteria. This includes defining thresholds for response time, heartbeat, and request rates for each monitored service. The system should allow for easy modification and customization of these alert rules.
### 5.	Automatic Email Trigger
The email should be configured to be sent to the POC and the team responsible for each dashboard separately
## Non-Functional Requirements
### 1.	Operational Requirements
#### 1.1	Availability
##### 1.1.1	Metric: 
System Uptime
##### 1.1.2	Objective: 
The monitoring and alerting service should have a minimum availability of 99.99%.
##### 1.1.3	Measurement Interval: 
Availability should be measured and reported monthly.
### 2.	Performance Requirements
#### 2.1	Real-time Monitoring Latency:
##### 2.1.1	Metric: 
Latency in processing and responding to monitoring data.
##### 2.1.2	Objective: 
The system should provide real-time monitoring with a latency of less than 1 second.
##### 2.1.3	Measurement Interval: 
Latency should be measured and reported continuously.
#### 2.2	Handling Data Volume:
##### 2.2.1	Metric: 
Maximum number of monitoring data points processed per second.
##### 2.2.2	Objective: 
The system should be capable of handling a high volume of data without performance degradation, supporting a data rate of up to 100,000 requests per second.
##### 2.2.3	Measurement Interval: 
Data processing performance should be tested and reported quarterly.
### 3.	Security Requirements
#### 3.1	Access Control:
##### 3.1.1	Metric: 
Unauthorized access attempts.
##### 3.1.2	Objective: 
Access to the monitoring and alerting service should be restricted to authorized users and systems. Unauthorized access attempts should be minimized.
##### 3.1.3	Measurement Interval: 
Access attempts should be logged and monitored continuously.
#### 3.2	Data Encryption:
##### 3.2.1	Metric: 
Percentage of data transmitted between the common service and mock services that is encrypted.
##### 3.2.2	Objective: 
All data transmitted between the common service and mock services should be encrypted to maintain data integrity and confidentiality.
##### 3.2.3	Measurement Interval: 
Encryption compliance should be verified and reported monthly.
#### 3.3	Dashboard Access Control:
##### 3.3.1	Metric: 
Unauthorized access attempts to the dashboard.
##### 3.3.2	Objective: 
The dashboard should be hosted on a server with access restricted to internal employees. Unauthorized access attempts should be minimized.
##### 3.3.3	Measurement Interval: 
Access attempts to the dashboard should be logged and monitored continuously.
### 4.	Scalability Requirements
#### 4.1	Scaling Capacity:
##### 4.1.1	Metric: 
Maximum number of mock services that can be monitored simultaneously.
##### 4.1.2	Objective: 
The monitoring service should be designed to accommodate a growing number of mock services and should support monitoring of at least 500 services concurrently.
##### 4.1.3	Measurement Interval: 
Scalability should be tested and reported annually.
#### 4.2	Horizontal Scaling:
##### 4.2.1	Metric: 
Number of additional instances or nodes added to the monitoring system for workload distribution.
##### 4.2.2	Objective: 
The monitoring service should support horizontal scaling by adding new instances or nodes to distribute the workload efficiently.
##### 4.2.3	Measurement Interval: 
Horizontal scaling capacity should be tested and reported biannually.
### 5.	Logging and Auditing
#### 5.1 Log Access:
##### 5.1.1 Metric: 
Time to retrieve logs for troubleshooting or auditing purposes.
##### 5.1.2 Objective: 
Logs should be stored securely and be easily accessible for troubleshooting and auditing purposes. The time to retrieve logs should not exceed 5 seconds.
##### 5.1.3 Measurement Interval: 
Log retrieval time should be tested and reported quarterly
## Use Case Diagram
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/bdc54039-c8a5-493f-873e-93acfdc32257)


<i>Figure 5.1 – Use Case Diagram</i>

### Actors
Payment Service (Mock), Database Service(Mock), Support Team
### Pre Condition
-	Payment Service and Database Service should be up and running.
-	It should have actuator health check to be exposed.
### Description
In figure 1 - “Payment Service(Mock)” and “Database Service(Mock)” are the actors representing the user interacting with the Monitoring and Alerting System<br>
The “Dynamic Configuration Handler” use case represents the handling of the configuration dynamically by scanning the configuration file and add/delete the service monitoring<br>
The “Data Collection Service” Collects the data from the services listed in Configuration Handler and sends to Modify Response Service<br>
The “Modify Response service” takes input from data collection service and modify it to necessary format and send to Data Sensitivity Check Service<br>
The “Data Sensitivity Check” checks for any sensitive data based on the flags set in the database and masks them before sending to the logs<br>
The “Health Check Service” collects the heartbeats of the services listed in Configuration handler and collects the health metrics using the scheduler service and sends to logs<br>
The “LogStash” collects the logs as and when the log files are filled with data using Filebeats<br>
The “Elastic Search” stores the logs using indexing mechanism which is in turn visualized in Kibana and used by the user<br>
The “Support Team” visualizes the logs and gets the alerts from the Kibana<br>
## Activity Diagram
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/3c2b6a35-64e0-45f3-b41a-dc1c692288a0)

<i>Figure 6.1 – Activity Diagram</i><br>
In the Figure 2, the users register to the configuration handler which collects the logs data and other performance metrics from the users every 2 seconds and condition the data to its needs and sends to Kibana using Logstash and Elastic Search<br>
The users here are the mock services sends the heartbeat every 2 seconds to the Health check and the data is sent to File beats and then using Logstash it is moved to Elastic Search and then visualized in Kibana<br>
The user is down and the health check data send to kibana triggers the alert and sends mail to respective Support team <br>
The user responds to the heartbeat after 20 seconds of delay then the data sent to  Kibana there by triggering the respective Support Team<br>
The flow in figure 2 is exited on triggering the mail alert action or posting the data on to Kibana<br>
The user is continued to be monitored by the Data Collection Service and Health Check Service and the steps are repeated.<br>
## Sequence Diagram
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/1c8f12a4-456c-492b-8295-c3d89a527895)

<i>Figure 7.1 – Sequence Diagram</i><br>
The Interaction  in Figure 3 starts with the Services registering for monitoring using the configuration file with Dynamic Configuration Handler<br>
The Data collection Service triggers the request for the metrics on the scheduled time interval and the metrics is returned by the service<br>
The Scheduler service initiates the health check at regular intervals configured<br>
The health check service triggers the request for health check of service and checks for the service health which returns the heartbeat of the service <br>
The further interaction with Logfile happens when the logs collected are written to the log file which is periodically read by Logstash and send message to elastic search<br>
The Support user actor request for specific metrics and filtered in Kibana which displays the elastic search data based on the index chosen by support user<br>
The Kibana starts interaction with support user when the alert rules set are triggered and the interaction ends by sending a mail to support users<br>

## Class Diagram
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/903b3c0f-471c-45e5-9b3b-bae0c5efc818)

<i>Figure  8.1 – Class Diagram</i><br>
The Class Diagram in Figure 4 shows different classes that are involved in the development of the Monitoring and Alerting service <br>
The ‘DynamicConfigurationHandlerController’ class collects the list of services by reading the config file and updating global values so as the other classes to be picked up. It also has a method to trigger checking for updates on configuration file/database based on inbuilt timer<br>
The ‘DataCollectionService’ class is responsible for collecting the metrics and handling the request by sending the collected data to further processing<br>
The ‘ModifyResponse’ class collects the response in the form of string and modifies by parsing it as JSON object and adds the timestamp and details for displaying and sends to data sensitivity check<br>
The ‘DataSensitivityCheck’ class checks for the sensitive data within the response and masks the sensitive data and sends logs to log file which is then picked up by logstash<br>
The ‘HealthCheckService’ class is responsible for reading the configuration file and get the status of health for all services and it is triggered by scheduler service methods<br>
The ‘SchedulerService’ class is responsible for triggering health checks for all the services <br>
The ‘DataCollectionController’ exposes all the endpoints which will initiate the service methods<br>
The ‘HealthCheckController’ exposes the endpoints to initiate the health check and uses the methods in Service class<br>
The ‘ServiceRegistryService’ supports the Dynamic Configuration Handler Controller to perform the register and deregister operations<br>
## Object Diagram
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/6cb46df1-360e-4be7-bbb1-456f6432cc8b)

<i>Fig:9.1-Object Diagram</i><br>
The Object Diagram represents the servicesList object is obtained from the Dynamic Configuration Handler by fetching all the registered services and then passed to the Data collection service and Health Check Service<br>
The Object is then used by the Services to collect the data from respective services and publish them on to the logs for further monitoring <br>
## Package Diagram
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/c5d418ff-0431-4bd2-8138-141c209a2a93)

<i>Fig 10.1- Package Diagram</i><br>
The provided package diagram outlines the structure of the MonitoringService project, organized into several packages to maintain a modular and well-organized codebase. Here's a description of each package:<br>
### 1.	com.mock.component:
<b>Description: </b>
This package houses the MockEndPoints class, which is presumably responsible for defining mock endpoints or services. These mock services may be used for testing or simulating interactions during development.
### 2.	com.monitor.configuration:
<b>Description:</b>
 This package encapsulates classes related to configuration settings for the monitoring service. The MonitorConfig class is present, indicating its role in configuring the monitoring service.
### 3.	com.monitor.controller:
<b>Description:</b>
 This package contains controllers responsible for handling various aspects of the monitoring service. Notable controllers include DataCollectionController, DynamicConfigurationHandlerController, and HealthcheckController. These controllers likely manage data collection, dynamic configuration, and health checks, respectively.
 ### 4.	com.monitor.objects:
 <b>Description:</b>
 The objects package contains classes representing key entities or data structures within the monitoring service. Metrics and ServiceInfo classes suggest a focus on encapsulating metrics and service-related information.
### 5.	com.monitor.services:
<b>Description:</b>
 This package hosts service classes essential for the functioning of the monitoring service. Notable services include DataCollectionService, HealthCheckService, SchedulerService, and ServiceRegistryService, indicating responsibilities related to data collection, health checks, scheduling, and service registration.
### 6.	com.monitor.utilities:
<b>Description:</b>
 The utilities package accommodates utility classes crucial for auxiliary functionalities. DataSensitivityCheck and ModifyResponse classes imply roles related to data sensitivity checks and response modifications, respectively.
## Hardware and Software Specification
- OS - Windows
- Java Version – JDK 17
- Build Tool – Maven
- Framework Used – Springboot
- Version of Spring – 3.1.4
- Dependencies Used – Wiremock, logstash, ElasticSearch, Swagger
- Tools Used – Kibana, Elastic Search, Logstash - (Version -8.11.0), FileBeat ( 8.11.1),Postman (10.20)
## Output
### Mock Configuration
The output of mock configuration which was created using WireMock


![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/c2607837-d78f-4d23-85fe-664f62f59416)

<i>Fig 12.1 – Mock Service Endpoint for Health</i><br>
![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/46a7d24d-a434-4fd5-81b1-15633d108f00)

<i>Fig 12.2 – Mock Service Endpoint for Metrics</i><br>
The registered services can be obtained by calling the endpoint which is exposed by Dynamic configuration Handler Controller<br>
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/d3dc05f8-3d27-4748-a19c-d6b353b539bc)

<i>Fig 12.3 – Registered Services Endpoint</i><br>
Data Collection Controller exposes the endpoint for collecting the metrics. This endpoint can be used by the services to initiate the metrics monitoring or it will be triggered by scheduler service every 5 minutes<br>
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/08b6b654-a1c8-447e-bac6-ae88d72527b1)

<i>Fig 12.4 – Collect Data Endpoint</i><br>

Health check controller exposes the endpoint for collecting the health check details of the services. This can also be initiated by the endpoint which is shown in the below postman request or it is auto triggered by the Scheduler Service every 5 minutes<br>
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/ad42b147-c500-4bc1-b224-13b824b0b583)

<i>Fig 12.5 – Payment Health Endpoint</i><br>

On calling these endpoints it would be logged on to the logstash by using filebeat. This filebeat can run on the server those services to be monitored will be running and it collects and sends to logstash. Using logstash configuration file, we define and filter the logs based on the category and map them to the index in elastic search.
The logstash configuration is shown below for filtering<br>
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/4b43714b-ac86-48ad-89da-e8908c9088e2)

<i>Fig 12.6 – Logstash Configuration</i><br>

Kibana shows the output as follows for the health index for example<br>
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/803aa4bf-18f9-4863-9bcb-809b23541a98)

<i>Fig 12.7 – Kibana Output</i><br>

We configured logs for each of the requirements which is shown below<br>
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/d351c97d-fef1-4447-988f-9eb5f3b7a658)

<i>Fig 12.7 – Kibana Rules</i><br>

These rules can be enhanced by linking them to trigger mail alerts using gold version of the Kibana
## API Documentation
 ![image](https://github.com/shilpathota/RealTimeMonitoringAndAlertingSystem/assets/36531617/5f4b857e-6f49-4057-bc8d-3d46a7b6bb23)

<i>Fig 13.1 – Swagger Documentation</i><br>

## Future Scope
•	The alerts can be linked to email with the gold version of Kibana
•	The solution can be leveraged for enterprise wide so they have common solution across by adding security standards for accessing the services
•	The Metrics can be widened based on the company requirements
•	Can be auto scaled by integrating with Kubernetes and docker
•	The service can be leveraged for the common features across enterprise by adding those functionalities
## Conclusion
In conclusion, the outlined project aims to establish a comprehensive Monitoring and Alerting System with a user-friendly Dashboard. The system is designed to collect, modify, and visualize performance metrics from various services, ensuring the reliability and efficiency of the monitored services. The Alerting Mechanism enhances proactive issue identification by notifying relevant stakeholders based on predefined rules, allowing for timely intervention and resolution.<br>
The Dashboard, powered by Kibana, provides users with real-time and historical performance data, contributing to informed decision-making. Administrators have the flexibility to configure and customize alert rules tailored to each service's specific criteria, ensuring adaptability to evolving operational requirements.<br>
On the non-functional side, the system prioritizes operational excellence, aiming for a high availability rate of 99.99%. Real-time monitoring latency is targeted to be less than 1 second, ensuring swift responsiveness. The system is designed to handle a substantial data volume, supporting up to 100,000 requests per second without compromising performance.<br>
Security measures are robust, with access control mechanisms, data encryption, and restricted dashboard access, safeguarding the system from unauthorized access. Scalability is a key focus, with the system built to accommodate a growing number of services through both scaling capacity and horizontal scaling.<br>
Logging and auditing capabilities are integral for troubleshooting and auditing purposes, with logs stored securely and accessible within a short retrieval time of 5 seconds.<br>
In summary, the proposed Monitoring and Alerting System aligns with industry best practices and standards, addressing both functional and non-functional requirements. It establishes a robust foundation for maintaining the health, performance, and security of the monitored services, contributing to overall system reliability and user satisfaction. Continuous monitoring, evaluation, and potential adjustments will be essential to ensure the system evolves alongside the changing needs of the services it monitors.<br>
## File Beats Configuration
<pre>input {
  beats {
    port => 5044
    codec => "json"
    type => "syslog"
  }
}
filter{
grok {
    match => {
      "message" => "%{DATESTAMP:timestamp} \[%{DATA:thread}\] %{LOGLEVEL:loglevel} %{DATA:logger}.%{WORD:method} - %{GREEDYDATA:json_data}"
    }
  }
if [json_data] =~ /\"logtype\"/{
  json {
    source => "json_data"
    target => "parsed_data"
  }

  if [parsed_data][logtype] == "health" {
    mutate {
      add_field => { "index_type" => "health" }
	  add_field =>  { "status" => "%{[parsed_data][status]}" }
    }
  } else if [parsed_data][logtype] == "metrics" {
    mutate {
      add_field => { "index_type" => "metrics" }
    }
  }
  }
}

output {
  if [index_type] == "health" {
    elasticsearch {
      hosts => ["127.0.0.1:9200"]
      index => "health_index"
    }
  } else if [index_type] == "metrics" {
    elasticsearch {
      hosts => ["127.0.0.1:9200"]
      index => "metrics_index"
    }
  } else {
    elasticsearch {
      hosts => ["127.0.0.1:9200"]
      index => "monitoring_index"
    }
  }
}
</pre>

