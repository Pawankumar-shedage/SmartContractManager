package com.scm.scm20.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControllers {

    // home page
    @RequestMapping({"/home","/"})
    public String homePage(Model model){

        // Controllers: handles requests,processes them using SERVICES and send data to the view
        // Sending data to view.
        model.addAttribute("name", "Pawankumar Shedage");
        model.addAttribute("githubRepo","https://github.com/Pawankumar-shedage");
        return "home";
    }

    // About page
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        return "about";
    }

    // services page
    @RequestMapping("/services")
    public String servicesPage(){
        return "services";
    }

    // contact page
    @RequestMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    // login page
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    // signup page
    @RequestMapping("/signup")
    public String signupPage(){
        return "signup";
    }
    
}
