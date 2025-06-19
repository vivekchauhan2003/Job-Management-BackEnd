package com.example.spring_boot_rest.repository;

import com.example.spring_boot_rest.model.JobPost;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Repository
public class JobRepo {

    private static final Logger logger = LoggerFactory.getLogger(JobRepo.class);

    // Thread-safe list to store JobPost objects
    private final List<JobPost> jobs = Collections.synchronizedList(new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),

            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),

            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),

            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    )));

    // Method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return new ArrayList<>(jobs); // Return a copy to avoid external modification
    }

    // Method to save a job post object into the list
    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println(jobs);
        logger.info("Job added: {}", job);
    }


    public JobPost getJob(int postId) {
        postId--;
        if (postId >= 0 && postId < jobs.size()) {
            return jobs.get(postId);
        }
        return null;
    }


    public void updateJob(JobPost jobPost) {
        for (JobPost jobPost1 : jobs) {
            if (jobPost1.getPostId() == jobPost.getPostId()) {
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
                break; // Optional: break after match
            }
        }
    }


//    public void deleteJob(int postId) {
//        for(int i = 0; i < jobs.size(); i++) {
//            JobPost jobPost = jobs.get(i);
//            if(jobPost.getPostId() == postId) {
//                jobs.remove(i);
//                i--; // Important: decrement index after removal to avoid skipping elements
//            }
//        }
//    }

    public void deleteJob(int postId) {
        synchronized (jobs) {
            Iterator<JobPost> iterator = jobs.iterator();
            while (iterator.hasNext()) {
                JobPost job = iterator.next();
                if (job.getPostId() == postId) {
                    iterator.remove(); // Safe way to delete during iteration
                    break;
                }
            }
        }
    }


//    public void deleteJob(int postId) {
//        synchronized (jobs) {
//            jobs.removeIf(job -> job.getPostId() == postId);
//        }
//    }



}































