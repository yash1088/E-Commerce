/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.User.Controller;

import com.user.User.Model.Cart;
import com.user.User.Model.Product;
import com.user.User.Model.WishList;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Yash
 */
@Controller
public class CartController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addcart")
    public String addcart(HttpServletRequest request, @RequestParam("quantity") int quantity, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        System.out.println("cart");
//        System.out.println("Quantity: " + quantity);
//        System.out.println(product);
        Cart cart = new Cart();
        String userId = (String) request.getSession().getAttribute("userId");
        String url = "http://User-Microservice/cart/" + userId + "/" +product.getPid() ;
        System.out.println(url);
        cart.setPId(product.getPid());
        cart.setUserID(userId);
        cart.setQuantity(quantity);

        if (product.getQuantity() == 0) {
            redirectAttributes.addFlashAttribute("errorMessage", "Product Can`t be Added!!");
            return "redirect:/dashboard";
        } else {
            ResponseEntity<String> response = restTemplate.postForEntity(url, cart, String.class);
            System.out.println("Response form server..." + response.getBody());

            if (response.getBody().contains("added")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Product Added!!");
                return "redirect:/cart/checkout";
            } else if (response.getBody().contains("Duplicate")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Product already added to cart!!");
                System.out.println("Err.." + redirectAttributes.getAttribute("errorMessage"));
                return "redirect:/dashboard";
            } else if (response.getBody().contains("connect")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong Please try again!!");
                System.out.println("Err.." + redirectAttributes.getAttribute("errorMessage"));
                return "redirect:/dashboard";
            }
        return "redirect:/dashboard";
    }
}

    @PostMapping("/removecart")
    public String deletecart(HttpServletRequest request, String pid, RedirectAttributes redirectAttributes) {
        String userId = (String) request.getSession().getAttribute("userId");
        String url = "http://User-Microservice/cartitemremove/" + userId + "/" +pid ;
        
        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
        
        if(response.getBody().contains("Error")){
            redirectAttributes.addFlashAttribute("errorMessage", "Error in deleting Cart Product!!");
            return "redirect:/cart/checkout";
        }
        else if(response.getBody().contains("connect")){
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong Please try again!!");
            return "redirect:/cart/checkout";
        }
        else{
            redirectAttributes.addFlashAttribute("errorMessage", "Product removed!!");
            return "redirect:/cart/checkout";
        }
        
    }   
}
