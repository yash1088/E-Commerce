/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.User.Controller;

import com.user.User.Model.Product;
import com.user.User.Service.ApiServiceMicro;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String login(HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        System.out.println("Session..."+userId);
        if(userId!=null){
            return "redirect:/dashboard";
        }
        else{
            return "Login";
        }
        
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
    public String dashboard(HttpServletRequest request, Model model) {
        List<Product> products = api.fetchDataProduct();
        System.out.println(products);
        model.addAttribute("products", products);
        String userId = (String) request.getSession().getAttribute("userId");
        //System.out.println("Session..."+userId);
        return "Dashboard";
    }
    
    @RequestMapping("/wishlist")
    public String wishlist(HttpServletRequest request, Model model) {
        String userId = (String) request.getSession().getAttribute("userId");
        List<Product> products = api.fetchDataWishList(userId);
        System.out.println("WishListData.."+products);
        model.addAttribute("products", products);
        return "Wishlist";
    }
    
    @RequestMapping("cart/checkout")
    public String cart(HttpServletRequest request, Model model) {
        String userId = (String) request.getSession().getAttribute("userId");
        List<Product> products = api.fetchDataCart(userId);
        System.out.println("CartData.."+products);
        model.addAttribute("products", products);
        return "Cart";
    }
    
    @RequestMapping("/orders")
    public String order(Model model) {
        return "Orders";
    }
    
    @RequestMapping("/profile")
    public String profile(Model model) {
        return "Profile";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        session.removeAttribute("userId");
        System.out.println("Session.."+session.getAttribute("userId"));
        return "redirect:/";
    }
    
}
