# Aerospike

1.  In Aerospike CRUD operation while fetching all Data from Aerospike Database
    Query without a filter will initiate a scan. Since scans are potentially dangerous operations, they are disabled by default in spring-data-aerospike. If you still need to use them, enable them via `scans Enabled` property in `org.springframework.data.aerospike.config.Aerospike Data Settings`.

    ->  Add this Bean in Aerospike Configuration File
        @Bean
        public AerospikeDataSettings aerospikeDataSettings() {
          return AerospikeDataSettings.builder().scansEnabled(true).sendKey(true).build();
        }

2.  Constructor with '3' parameters is already defined

    ->  This is Lombok Problem