package com.example.demo;

import java.util.Properties;
import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ConsumerAppJsonData {

	public static void main(String[] args) throws Exception {
		String topicName = "TestTopic";
		Properties props = new Properties();

		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		// Kafka Consumer subscribes list of topics here.
		consumer.subscribe(Arrays.asList(topicName));

		// print the topic name
		System.out.println("Subscribed to topic " + topicName);
		int i = 0;

		java.util.List<person> list = new ArrayList<person>();

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

				for (ConsumerRecord<String, String> record : records) {
					// print the offset,key and value for the consumer records.
					System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(),
							record.value());
					String a = record.value();
					JSONObject jo = new JSONObject(a);
					int JoPrice = (int) jo.get("Price");
					int JoID = (int) jo.get("id");
					person p = new person((String) jo.getString("Name"), JoPrice, JoID);
					list.add(p);
					
					String values = "'" + p.getName() + "', " + JoPrice + ", " + JoID + " ";
					
    	         	Insert.insert("PName, PPrice, Pid",values,p);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------------Catch Block (Consumer)-------------");
		}

	}
}