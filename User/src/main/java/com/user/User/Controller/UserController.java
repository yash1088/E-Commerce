/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.User.Controller;

import com.user.User.Model.Product;
import com.user.User.Service.ApiServiceMicro;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yash
 */

@Controller
public class UserController {
    
    @Autowired
    ApiServiceMicro api;
    
    @RequestMapping("/")
    public String welcome() {
        return "Welcome";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "Login";
    }
    
    @RequestMapping("/signup")
    public String signUp() {
        return "SignUp";
    }
    
    @RequestMapping("/forgotpassword")
    public String forgotpassword() {
        return "ForgotPassword";
    }
    
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Product> products = api.fetchDataFromApi();
        model.addAttribute("products", products);
        
        return "Dashboard";
    }
}
