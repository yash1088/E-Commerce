/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.User.Controller;

import com.user.User.Model.Product;
import com.user.User.Model.WishList;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Yash
 */

@Controller
public class WishListController {
    
    @Autowired
    RestTemplate restTemplate;
    
    @PostMapping("/addwishlist")
    public String addwishlist(HttpServletRequest request, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        //System.out.println("Product Quantity"+product.getQuantity());
        WishList wishlist = new WishList();
        String userId = (String) request.getSession().getAttribute("userId");
        String url = "http://User-Microservice/wishlist/"+product.getPid()+"/"+userId;
        System.out.println(url);
        wishlist.setPId(product.getPid());
        wishlist.setUserID(userId);
        ResponseEntity<String> response = restTemplate.postForEntity(url, wishlist, String.class);
        
        System.out.println("Response form server..."+response.getBody());
        
        
        if(response.getBody().contains("added")){
            redirectAttributes.addFlashAttribute("errorMessage", "Product Added!!");
            return "redirect:/dashboard";
        }
        else if (response.getBody().contains("Duplicate")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Product already added to cart!!");
            System.out.println("Err.."+redirectAttributes.getAttribute("errorMessage"));
            return "redirect:/dashboard";
        }
        else if (response.getBody().contains("connect")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong Please try again!!");
            System.out.println("Err.."+redirectAttributes.getAttribute("errorMessage"));
            return "redirect:/dashboard";
        }
        return "redirect:/dashboard";
    }
}
