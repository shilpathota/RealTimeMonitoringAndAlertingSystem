package com.monitor.objects;

public class ServiceInfo {
	        private final String name;
	        private final String host;
	        private final int port;

	        public ServiceInfo(String name, String host, int port) {
	            this.name = name;
	            this.host = host;
	            this.port = port;
	        }

	        public String getName() {
	            return name;
	        }

	        public String getHost() {
	            return host;
	        }

	        public int getPort() {
	            return port;
	        }
}
