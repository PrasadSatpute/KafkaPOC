package com.restapi.kafka;

import java.util.Scanner;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import com.restapi.kafka.model.Person;

public class AerospikeCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
		
		boolean choice = true;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			do {
				
				System.out.println("Enetr ID 	:	");
				int ID = sc.nextInt();
				System.out.println("Enetr Name 	:	");
				String Name = sc.next();
				System.out.println("Enetr Age	:	");
				int Age = sc.nextInt();
				System.out.println("Enetr City 	:	");
				String City = sc.next();
				
				Person p = new Person(ID, Name, Age, City);
				
				//Create Aerospike key: We create a unique Aerospike key using the namespace "test", the set name "testSet", and the offset of the record in the Kafka topic.
		        Key key = new Key("test", "testSet", p.getId()); // Use record offset as the primary key
		        //Create Aerospike bin: We create an Aerospike bin (a container for a data field) with the name "data" and the value of the Kafka record.
		        Bin bin = new Bin("data", p);

		        //WritePolicy: We create a write policy and set sendKey to true. This tells Aerospike to store the primary key along with the record.
		        WritePolicy writePolicy = new WritePolicy();
		        writePolicy.sendKey = true;

		        //Put record into Aerospike: We insert the record into Aerospike using the key, bin, and write policy.
		        client.put(writePolicy, key, bin);
				
		        System.out.println("Record Insert Succesefully");
		        
		        System.out.println("Choose Option To Continue : 1 Or 2");
		        int i = sc.nextInt();
		        if(i == 1)
		        {
		        	choice = true;
		        }
		        else {
		        	choice = false;
				}
		        
			} while (choice);
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			client.close();
		}
		
		
	}

}
