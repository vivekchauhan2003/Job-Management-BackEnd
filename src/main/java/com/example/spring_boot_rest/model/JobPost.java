package com.example.spring_boot_rest.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor : not work use @RequiredArgsConstructor because our private List<JobPost> was "final".
@AllArgsConstructor
@RequiredArgsConstructor
@Component
public class JobPost {

	private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
