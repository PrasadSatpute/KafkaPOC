package com.restapi.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import com.restapi.kafka.model.Person;
import com.aerospike.client.Record;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@SpringBootApplication
public class SpringBootRestApiKafkaToAerospikeApplication {
	
	//createKafkaConsumer: This method creates a Kafka consumer with the given configuration.
    public static KafkaConsumer<String, Person> createKafkaConsumer(String bootstrapServers, String groupId, String topic) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        KafkaConsumer<String, Person> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
        return consumer;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiKafkaToAerospikeApplication.class, args);
		
		String bootstrapServers = "127.0.0.1:9092";
        String groupId = "myGroup";
        String topic = "KafkaPerson";

        //KafkaConsumer and AerospikeClient setup: We create a Kafka consumer and an Aerospike client. The consumer connects to the Kafka broker, and the client connects to the Aerospike server.
        KafkaConsumer<String, Person> consumer = createKafkaConsumer(bootstrapServers, groupId, topic);
        AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);

        try {
            //Consume records from Kafka and store them in Aerospike: We poll the Kafka topic for new records, and for each record, we insert it into Aerospike using the Aerospike client.
            while (true) {
                ConsumerRecords<String, Person> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, Person> record : records) {
                	
                    //Create Aerospike key: We create a unique Aerospike key using the namespace "test", the set name "testSet", and the offset of the record in the Kafka topic.
                    Key key = new Key("test", "testSet", String.valueOf(record.offset())); // Use record offset as the primary key
                    //Create Aerospike bin: We create an Aerospike bin (a container for a data field) with the name "data" and the value of the Kafka record.
                    Bin bin = new Bin("data", record.value());

                    //WritePolicy: We create a write policy and set sendKey to true. This tells Aerospike to store the primary key along with the record.
                    WritePolicy writePolicy = new WritePolicy();
                    writePolicy.sendKey = true;

                    //Put record into Aerospike: We insert the record into Aerospike using the key, bin, and write policy.
                    client.put(writePolicy, key, bin);
                    
                    //Get record from Aerospike: We retrieve the record from Aerospike using the key and log the retrieved data.
                    Record retrievedRecord = client.get(null, key);
                    }
                //Commit Kafka offsets: We commit the processed Kafka offsets asynchronously to keep track of the records that we've already processed.
                consumer.commitAsync();
            }
        }
        //Close resources: After processing all records, we close the Kafka consumer and Aerospike client. Although this code is inside a while (true) loop that doesn't exit, it's good practice to close resources within a finally block to handle unexpected shutdowns or errors.
        finally {
            consumer.close();
            client.close();
        }
		
	}

}
