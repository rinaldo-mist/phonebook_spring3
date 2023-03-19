package com.assessment.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RolesApiController {
    
    @GetMapping({"","/"})
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/logout")
    public String signOut(){
        return "studentviews/index";
    }

    @PostMapping("/logout")
    public String postSignOut(){
        return "/index";
    }
    
    
    

}
