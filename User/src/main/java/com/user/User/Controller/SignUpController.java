/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.User.Controller;

import com.user.User.Model.Product;
import com.user.User.Model.User;
import com.user.User.Service.ApiServiceMicro;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SignUpController {

    @Autowired
    ApiServiceMicro api;
    
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println(user);
       if (bindingResult.hasErrors()) {
            // If there are errors, redirect back to signup page with error message
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid form data. Please check your input.");
            return "redirect:/signup";
        }
       
        ResponseEntity<String> response = restTemplate.postForEntity("http://User-Microservice/signup", user, String.class);
        System.out.println("Res..."+response.getBody());

        // Check if username is already taken
        if (response.toString().contains("Error")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Username or UserID already exists. Please choose a different one.");
            System.out.println("Err.."+redirectAttributes.getAttribute("errorMessage"));
            return "redirect:/signup";
        }

        return "redirect:/login";
    }

}
