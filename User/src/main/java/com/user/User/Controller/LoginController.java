/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.User.Controller;

import com.user.User.Model.Product;
import com.user.User.Model.User;
import com.user.User.Service.ApiServiceMicro;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Yash
 */

@Controller
public class LoginController {

    @Autowired
    ApiServiceMicro api;
    
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/login")
    public String login(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
       System.out.println(user);
       if (bindingResult.hasErrors()) {
            // If there are errors, redirect back to signup page with error message
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid form data. Please check your input.");
            return "redirect:/signup";
        }
       
        ResponseEntity<String> response = restTemplate.postForEntity("http://User-Microservice/login", user, String.class);
        System.out.println("Res..."+response.getBody());

        // Check if username is already taken
        if(response.getBody().equals("Not Exist")){
            redirectAttributes.addFlashAttribute("errorMessage", "User not exist please Register!!");
            return "redirect:/signup";
        }
        else if (response.getBody().contains("Not") || response.getBody().contains("wrong")) {
            redirectAttributes.addFlashAttribute("errorMessage", "UserID or Password is wrong. Please try again!!");
            System.out.println("Err.."+redirectAttributes.getAttribute("errorMessage"));
            return "redirect:/login";
        }
        
         HttpSession session = request.getSession(true);
         session.setAttribute("userId", user.getUserID());
        
        return "redirect:/dashboard";
    }

}
