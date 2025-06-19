package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //this will allow spring boot to send data to react.js
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping(path="jobPosts", produces ={"application/json"})
    //this wil tell that whatever we are returning is a body, not a file.
    public List<JobPost> getAllJobs(){
        return service.getAllJobs(); // returning the data itself. "JSON"

    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
    return service.getJob(postId);

    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        // return jobPost; // this will tell that we added some data.(bad practise)
        return service.getJob(jobPost.getPostId()); // now this will come form the collection (best practise)
    }
    //@RequestBody allow us to get data sent by client.

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return ("Delete a post with id : " + postId);

    }






































}
