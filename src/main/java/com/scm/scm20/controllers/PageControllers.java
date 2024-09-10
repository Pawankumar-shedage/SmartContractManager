package com.scm.scm20.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageControllers {

    @Autowired              //injecting bean , bean: object of a class. here injecting UserServiceImpl object into Controller class.
    private UserService userService;

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
    public String processRegister(@ModelAttribute UserForm userForm,HttpSession session){
        System.out.println("User registration");
        // form-fields => object attributes.
        //1.fetch data from sign up form
        System.out.println(userForm);
        //2. validate data

        //3.Save form data to database
        // UserForm data -> User

        // User savedUser = User.builder()
        //     .name(userForm.getName())
        //     .email(userForm.getEmail())
        //     .about(userForm.getAbout())
        //     .password(userForm.getPassword())
        //     .phoneNumber(userForm.getPhoneNumber())
        //     .profilePic("https://static.vecteezy.com/system/resources/thumbnails/030/504/836/small/avatar-account-flat-isolated-on-transparent-background-for-graphic-and-web-design-default-social-media-profile-photo-symbol-profile-and-people-silhouette-user-icon-vector.jpg")
        //     .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setAbout(userForm.getAbout());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://static.vecteezy.com/system/resources/thumbnails/030/504/836/small/avatar-account-flat-isolated-on-transparent-background-for-graphic-and-web-design-default-social-media-profile-photo-symbol-profile-and-people-silhouette-user-icon-vector.jpg");

        User savedUser = userService.saveUser(user);

        System.out.println("User saved "+ savedUser);

        //4.Add message: "Registration Successfull/failed/Warning"
        // Message message = Message.builder().
        session.setAttribute("message", "Registration Successfull");

        //5.redirect 
        return "redirect:/home";
    }
}
