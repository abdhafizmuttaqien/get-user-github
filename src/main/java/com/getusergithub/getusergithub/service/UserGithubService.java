package com.getusergithub.getusergithub.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.getusergithub.getusergithub.models.User;

@Service
public class UserGithubService {

    private RestTemplate restTemplate =  new RestTemplate();

    // Service ResponseEntity return
    public ResponseEntity<User[]> getGithubUserEntity(){
        User[] user = restTemplate.getForObject("https://api.github.com/users?per_page=50", User[].class);
        return ResponseEntity.ok(user);
    }

    // Service Class return
    public User[] getGithubUser(){
        User[] user = restTemplate.getForObject("https://api.github.com/users?per_page=50", User[].class);
        return user;
    }

}
