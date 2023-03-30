package com.example.AerospikeCrudDemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "aerospike")
public class AerospikeConfigProperties {
	private String host;
    @Override
	public String toString() {
		return "AerospikeConfigProperties [host=" + host + ", port=" + port + ", namespace=" + namespace + "]";
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	private int port;
    private String namespace;
}
