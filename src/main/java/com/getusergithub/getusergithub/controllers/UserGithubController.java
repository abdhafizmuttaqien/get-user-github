package com.getusergithub.getusergithub.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.getusergithub.getusergithub.models.User;
import com.getusergithub.getusergithub.service.PDFGeneratorService;
import com.getusergithub.getusergithub.service.UserGithubService;

import jakarta.servlet.http.HttpServletResponse;

@RestController

@RequestMapping("/getdata")
public class UserGithubController{

    @Autowired
    private UserGithubService service;

    // Get Data With Entity Return
    @GetMapping("/githubUserEntity")
    public ResponseEntity<User[]> getGithubUserEntity(){
        return service.getGithubUserEntity();
    }
    
    // Get Data With Entity Return
    @GetMapping("/githubUser")
    public User[] getGithubUsers(){
        return service.getGithubUser();
    }
    
    private PDFGeneratorService pdfGeneratorService;

    public UserGithubController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    // Download PDF file
    @GetMapping("/pdf")
    public void generatePDF(HttpServletResponse response) throws DocumentException, IOException{
        User[] user = service.getGithubUser();
        this.pdfGeneratorService.export(response, user);
    }
}