package com.example.AerospikeCrudDemo.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.data.aerospike.repository.config.ReactiveAerospikeRepositoryConfigurationExtension;

import com.aerospike.client.Host;

@Configuration
@EnableConfigurationProperties(AerospikeConfigProperties.class)
@EnableAerospikeRepositories(basePackageClasses = ReactiveAerospikeRepositoryConfigurationExtension.class)
public class AerospikeConfig extends AbstractAerospikeDataConfiguration{

	@Autowired
	private AerospikeConfigProperties aerospikeConfigProperties;
	
	@Override
	protected Collection<Host> getHosts() {
		return Collections.singleton(new Host(aerospikeConfigProperties.getHost(), aerospikeConfigProperties.getPort()));
	}

	@Override
	protected String nameSpace() {
		return aerospikeConfigProperties.getNamespace();
	}
	
}
