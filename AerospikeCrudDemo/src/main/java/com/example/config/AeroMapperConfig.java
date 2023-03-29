package com.example.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.mapper.tools.AeroMapper;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AeroMapperConfig {
	@Inject
    AerospikeConfig config;

    AeroMapper mapper = null;

    @PostConstruct
    public void aerospikeClient()
    {
        ClientPolicy policy = new ClientPolicy();

        policy.readPolicyDefault.socketTimeout = 50;
        policy.readPolicyDefault.totalTimeout = 110;
        policy.readPolicyDefault.sleepBetweenRetries = 10;
        policy.writePolicyDefault.socketTimeout = 200;
        policy.writePolicyDefault.totalTimeout = 450;
        policy.writePolicyDefault.sleepBetweenRetries = 50;

        AerospikeClient client = new AerospikeClient(policy,config.getHost(),config.getPort());

        mapper = new AeroMapper.Builder(client).build();
    }

    public AeroMapper getMapper()
    {
        return this.mapper;
    }
}
