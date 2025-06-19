# JOB MANAGEMENT APP

This is the **backend** of the **Job Management Application**, developed using **Spring Boot**.

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Maven
- RESTful APIs
- Lombok
- IntelliJ IDEA

## 🚀 Features

- Add, update, delete job posts
- Retrieve job listings
- Prevent duplicate job entries
- Thread-safe job storage using `Collections.synchronizedList`


## jackson-dataformat-xml

#### helps to convert the json data to XML

- STEP 1)
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
			<version>2.19.0</version>
		</dependency>

- STEP 2)
        POSTMAN
        GET : localhost:8080/jobPosts
        Headers
        Key : Accept
        Value : application/xml
