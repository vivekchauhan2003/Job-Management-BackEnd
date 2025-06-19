# ✅ JOB MANAGEMENT APP

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


## ✅ jackson-dataformat-xml

#### helps to convert the json data to XML

- STEP 1)
````
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
			<version>2.19.0</version>
		</dependency>
````
- STEP 2)
````
        POSTMAN
        GET : localhost:8080/jobPosts
        Headers
        Key : Accept
        Value : application/xml
````

## ✅ produces ={"application/json"}

- means this Get request will only send Json data. not xml data.
````
    @GetMapping(path="jobPosts", produces ={"application/json"})
    //this wil tell that whatever we are returning is a body, not a file.
    public List<JobPost> getAllJobs() {
        return service.getAllJobs(); // returning the data itself. "JSON"

    }
````
Similarly, 
## ✅ produces ={"application/json"}
````
- means this Post request will only accept/consume Json data. not xml data.
````

## ✅ QUIZ
1. Which annotation is used to bind a method parameter to a URL template variable in Spring Boot? : @PathVariable 
2. What is the purpose of the @RequestBody annotation in Spring Boot?  : To pass JSON / XML data to a method. 
3. Which of the following best describes the difference between @PathVariable and @RequestParam? : @PathVariable maps to URL segments, @RequestParam maps to query parameters.
4. Which annotation is used to handle HTTP PUT requests in Spring Boot? : @PutMapping
5. Which HTTP library is commonly used in React to make API calls to a Spring Boot backend? : Axios










