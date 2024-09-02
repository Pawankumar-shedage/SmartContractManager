package com.scm.scm20.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm20.forms.UserForm;

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
    @RequestMapping("/register")
    public String signupPage(Model model){
        // Default field data
        UserForm userForm = new UserForm();
        // userForm.setName("Pawan");
        // userForm.setAbout("Write something about yourself");
        model.addAttribute("userForm", userForm);       //setting blank object User Form.
        return "signup";
    }
    
    @PostMapping(value="/do-register")
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("User registration");
        // form-fields => object attributes.
        //fetch data from sign up form
        System.out.println(userForm);
        // validate data

        // Save form data to database

        // message: "Registration Successfull"
        // redirect 
        return "redirect:/home";
    }
}
