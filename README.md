# Logs Aggregator

This repository contains functionality for `Aggregating Logs` from different source files. 
The code demonstrates agregation of Logs into a single file with ability to run nightly builds in case we need to perform nightly run of Synchronising Logs.


### Requirements to build solution
 
 - [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-2133151.html). JDK 11 has been 		used as compiler but the project should compile on JDK 8 as well. 
 - [Maven 3](https://maven.apache.org) 
 

 
### Coding standards 

 - DAO pattern has been followed to abstract the File reading and writing process to the File Sources.
 
 - The Logs Aggregator is a controller for the API and the entry point for anyone calling API
 
 - Dependency Injection has been used by injecting dependencies to the Controller, Service and DAO
 
 - Abstraction (to a level) has been done
 
 - Test framework(JUnit 5) has been used to write test cases(have just blue printed the test cases and has been tested 	for some scenarios)
 
 - Ideally Id use Jacoco for the code coverage, I would always want a very high l;evel of code coverage which ensures 	all code branches are reachable
 
 - Project is mavenised
 
 - Pub/Sub model could be used between the Log Generator and Log Consumer using a queue in between like Kafka , 			ActiveMq etc. This will mitigate the single point of failure and even if the Consumer or  Generator is down the 		persistence can be achieved
 
 
 
	


### Assumptions

 - Log files will be provided to the Logging service at a central place.
 
	
 - It could be a log reciever service 			recieving logs from a queue and putting them in 	respective files
	
	
 - The Service should have a method to integrate out of timings logs in case there 		was a downtime in service to 	send the logs.
	
	
 - It is assumed that the log sender will be responsible to send the logs to the log 	reciever servie in a specific 	format. The log reciever will be responsible to 		transform the logs into format understandable by the log 		aggregator
	
	
 - The Log agregator service wil be runnig on a stand alone server and should provide 	interfacing to various data 		sinks such as Database AWS S3, GCP, File system etc.


 - The log files will have logs from same time zone and if the time zone is not same then the log recieving service 		should transfor the logs into desirable format.


 - The Log aggregator should be run every half an hour to agregate the logs from the sources using either a scheduler


 - It is assumes that the functionality of the log aggregator will be exposed as REST endpoint to be consumed by the         	LogReciever service. The Log reciever service is responsible to call the REST endpoint after a specific/				desired/agreed period 	of time


 - For streaming Log aggregator it is assumed that the data will be appended at the end of the aggregated file and the 	sorting will take place at a later date/time as per agreement


 - Log aggregator will have a replica and will be created as soon as the batch activity has completed
 
 - Log aggregator assumes that the `LogsAggregator` Api will be called in a scheduled manner if the use case is Batched 
 	aggregation of Logs.
 
 
 - For Streamed Logs (Eg from IOTs) consider using `Apache Beam API` recommended and used highly by Google.
 
 
 - Data Streaming and engineering is a complete science in itself , I have tried to model that as much as possible in 	this short time  but appreciate it is a big project in iotself which requires a very thorough understanding of the 	target system.
 
 
 - The Api assumes that te Logs in the Inoput source files will be in a chronological order which will be how they 		will be placed in the aggregator
 






 